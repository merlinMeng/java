/**
 * This file includes the required ext-all js and css files based upon "theme" and "direction"
 * url parameters.  It first searches for these parameters on the page url, and if they
 * are not found there, it looks for them on the script tag src query string.
 * For example, to include the neptune flavor of ext from an index page in a subdirectory
 * of extjs/examples/:
 * <script type="text/javascript" src="../../examples/shared/include-ext.js?theme=neptune"></script>
 */
(function() {
    function getQueryParam(name) {
        var regex = RegExp('[?&]' + name + '=([^&]*)');

        var match = regex.exec(location.search) || regex.exec(path);
        return match && decodeURIComponent(match[1]);
    }

    function hasOption(opt, queryString) {
        var s = queryString || location.search;
        var re = new RegExp('(?:^|[&?])' + opt + '(?:[=]([^&]*))?(?:$|[&])', 'i');
        var m = re.exec(s);

        return m ? (m[1] === undefined || m[1] === '' ? true : m[1]) : false;
    }

    function getCookieValue(name){
        var cookies = document.cookie.split('; '),
            i = cookies.length,
            cookie, value;

        while(i--) {
           cookie = cookies[i].split('=');
           if (cookie[0] === name) {
               value = cookie[1];
           }
        }

        return value;
    }

    var scriptEls = document.getElementsByTagName('script'),
        path = scriptEls[scriptEls.length - 1].src,
        rtl = getQueryParam('rtl'),
        theme = getQueryParam('theme') || 'neptune',
        includeCSS = !hasOption('nocss', path),
        neptune = (theme === 'neptune'),
        repoDevMode = getCookieValue('ExtRepoDevMode'),
        suffix = [],
        i = 3,
        neptunePath;

    rtl = rtl && rtl.toString() === 'true'

    while (i--) {
        path = path.substring(0, path.lastIndexOf('/'));
    }
        
    if (theme && theme !== 'classic') {
        suffix.push(theme);
    }
    if (rtl) {
        suffix.push('rtl');
    } 

    suffix = (suffix.length) ? ('-' + suffix.join('-')) : '';

    if (includeCSS) {
        document.write('<link rel="stylesheet" type="text/css" href="' + path + '/resources/css/ext-all' + suffix + '-debug.css"/>');
    }
    document.write('<script type="text/javascript" src="' + path + '/ext-all' + (rtl ? '-rtl' : '') + '.js"></script>');

    if (neptune) {
        // since document.write('<script>') does not block execution in IE, we need to 
        // makes sure we prevent ext-theme-neptune.js from executing before ext-all.js
        // normally this can be done using the defer attribute on the script tag, however
        // this method does not work in IE when in repoDevMode.  It seems the reason for
        // this is because in repoDevMode ext-all.js is simply a script that loads other
        // scripts and so Ext is still undefined when the neptune overrides are executed.
        // To work around this we use the _beforereadyhandler hook to load the neptune
        // overrides dynamically after Ext has been defined.
        neptunePath = (repoDevMode ? path + '/..' : path) +
            '/packages/ext-theme-neptune/build/ext-theme-neptune' +
            (repoDevMode ? '-dev' : '') + '.js';

        if (repoDevMode &&  window.ActiveXObject) {
            Ext = {
                _beforereadyhandler: function() {
                    Ext.Loader.loadScript({ url: neptunePath });
                }
            };
        } else {
            document.write('<script type="text/javascript" src="' + neptunePath + '" defer></script>');
        }
    }

})();



(function() {
    function getQueryParam(name, queryString) {
        var match = RegExp(name + '=([^&]*)').exec(queryString || location.search);
        return match && decodeURIComponent(match[1]);
    }

    function hasOption(opt) {
        var s = window.location.search;
        var re = new RegExp('(?:^|[&?])' + opt + '(?:[=]([^&]*))?(?:$|[&])', 'i');
        var m = re.exec(s);

        return m ? (m[1] === undefined ? true : m[1]) : false;
    }

    var scriptTags = document.getElementsByTagName('script'),
        defaultTheme = 'neptune',
        defaultRtl = false,
        i = scriptTags.length,
        requires = [
            'Ext.toolbar.Toolbar',
            'Ext.form.field.ComboBox',
            'Ext.form.FieldContainer',
            'Ext.form.field.Radio'

        ],
        defaultQueryString, src, theme, rtl;

    while (i--) {
        src = scriptTags[i].src;
        if (src.indexOf('include-ext.js') !== -1) {
            defaultQueryString = src.split('?')[1];
            if (defaultQueryString) {
                defaultTheme = getQueryParam('theme', defaultQueryString) || defaultTheme;
                defaultRtl = getQueryParam('rtl', defaultQueryString) || defaultRtl;
            }
            break;
        }
    }

    Ext.themeName = theme = getQueryParam('theme') || defaultTheme;
    
    rtl = getQueryParam('rtl') || defaultRtl;

    if (rtl.toString() === 'true') {
        requires.push('Ext.rtl.*');
        Ext.define('Ext.GlobalRtlComponent', {
            override: 'Ext.AbstractComponent',
            rtl: true
        });
    }

    Ext.require(requires);

    Ext.onReady(function() {
        Ext.getBody().addCls(Ext.baseCSSPrefix + 'theme-' + Ext.themeName);

        if (Ext.isIE6 && theme === 'neptune') {
            Ext.Msg.show({
                title: 'Browser Not Supported',
                msg: 'The Neptune theme is not supported in IE6.',
                buttons: Ext.Msg.OK,
                icon: Ext.Msg.WARNING
            });
        }
        
        if (hasOption('nocss3')) {
            Ext.supports.CSS3BorderRadius = false;
            Ext.getBody().addCls('x-nbr x-nlg');
        }
        function setParam(param) {
            var queryString = Ext.Object.toQueryString(
                Ext.apply(Ext.Object.fromQueryString(location.search), param)
            );
            location.search = queryString;
        }

        function removeParam(paramName) {
            var params = Ext.Object.fromQueryString(location.search);

            delete params[paramName];

            location.search = Ext.Object.toQueryString(params);
        }

        var toolbar;
            
        setTimeout(function() {
            toolbar = Ext.widget({
                xtype: 'toolbar',
                border: true,
                rtl: false,
                id: 'options-toolbar',
                floating: true,
                fixed: true,
                preventFocusOnActivate: true,
                draggable: {
                    constrain: true
                },
                items: [{
                    xtype: 'combo',
                    rtl: false,
                    width: 170,
                    labelWidth: 45,
                    fieldLabel: 'Theme',
                    displayField: 'name',
                    valueField: 'value',
                    labelStyle: 'cursor:move;',
                    margin: '0 5 0 0',
                    store: Ext.create('Ext.data.Store', {
                        fields: ['value', 'name'],
                        data : [
                            { value: 'access', name: 'Accessibility' },
                            { value: 'classic', name: 'Classic' },
                            { value: 'gray', name: 'Gray' },
                            { value: 'neptune', name: 'Neptune' }
                        ]
                    }),
                    value: theme,
                    listeners: {
                        select: function(combo) {
                            var theme = combo.getValue();
                            if (theme !== defaultTheme) {
                                setParam({ theme: theme });
                            } else {
                                removeParam('theme');
                            }
                        }
                    }
                }, {
                    xtype: 'button',
                    rtl: false,
                    hidden: !(Ext.repoDevMode || location.href.indexOf('qa.sencha.com') !== -1),
                    enableToggle: true,
                    pressed: rtl,
                    text: 'RTL',
                    margin: '0 5 0 0',
                    listeners: {
                        toggle: function(btn, pressed) {
                            if (pressed) {
                                setParam({ rtl: true });
                            } else {
                                removeParam('rtl');
                            }
                        }
                    }
                }, {
                    xtype: 'tool',
                    type: 'close',
                    rtl: false,
                    handler: function() {
                        toolbar.destroy();
                    }
                }],

                // Extra constraint margins within default constrain region of parentNode
                constraintInsets: '0 -' + (Ext.getScrollbarSize().width + 4) + ' 0 0'
            });
            toolbar.show();
            toolbar.alignTo(
                document.body,
                Ext.optionsToolbarAlign || 'tr-tr',
                [
                    (Ext.getScrollbarSize().width + 4) * (Ext.rootHierarchyState.rtl ? 1 : -1),
                    -(document.body.scrollTop || document.documentElement.scrollTop)
                ]
            );
            
            var constrainer = function() {
                toolbar.doConstrain();
            };
            
            Ext.EventManager.onWindowResize(constrainer);
            toolbar.on('destroy', function() { 
                Ext.EventManager.removeResizeListener(constrainer);
            });
        }, 100);

    });
})();