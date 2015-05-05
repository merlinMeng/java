Ext.onReady(function(){
		
	//头部信息。。。。
	var toolbarTop = Ext.create('Ext.toolbar.Toolbar',{
		items:[
			'-',
			{ xtype:'tbspacer',width:'80%'},
			'-',
			{ text:'当前用户:mmmm',handler:onButtonClick,iconCls:'saveIcon',width:'10%'},
			'-',
			{ text:'退出登录',handler:onButtonClick,iconCls:'saveIcon',width:'10%'}
		]
	});
	function onButtonClick(btn){
		alert(btn.text);
	};
	
	//创建菜单数据模型
	Ext.regModel('Menu', {
	    fields: ['text','url']
	});
	
	//切换内容页面
	function changePage(url,title){
		
		Ext.getDom('contentIframe').src = url;
		
	}
	//创建菜单树数据源
	var menuStore = Ext.create('Ext.data.TreeStore',{
		model : 'Menu',
        proxy:{
			type:'memory',
			data:[{
					text:'数据包管理',
					leaf:true,
					url:'/dataPackManager/daPaMa'
				},{
					text:'元数据展示',
					leaf:true,
					url:'/dataPackManager/daPaMa'
				},{
					text:'角色管理',
					leaf:true,
					url:'/dataPackManager/daPaMa'
				}
			]
		},
        root: {
            text: '系统说明',
            url : 'dataPackManager/pagesExt/about.jsp',
            leaf: false,
            expanded: true
        },
        listeners:{
        	expand : function(node){
        		//切换内容页面
        		changePage(node.get('url'), node.get('text'));
        	}
        }
    });
	
	//创建菜单树
	var menuTree = Ext.create('Ext.tree.Panel',{
		border : false,
		store : menuStore,
		hrefTarget : 'mainContent',
		listeners : {
			itemclick : function(view, rec, item, index, e){
				changePage(rec.get('url'), rec.get('text'));
			}
		}
		
	});
	
	var mainContent = {
				layout : 'fit',
				contentEl : 'contentIframe',
				collapsible: true,
				id : 'mainContent',
				region:'center'//指定子面板所在区域为center
	};
	Ext.create('Ext.container.Viewport',{
			layout:'border',//Border布局
			items: [{
				region:'north',
				height:50,
				title:'<font size=3>数据管理系统 </font>',
				dockedItems:toolbarTop
			},{
				title : '功能菜单',
				items : menuTree,
				split:true,
				collapsible: true,
				region:'west',//指定子面板所在区域为west
				width: 180
			},{
				layout : 'fit',
				contentEl : 'contentIframe',
				collapsible: true,
				id : 'mainContent',
				region:'center'//指定子面板所在区域为center
			}]
		});
	
	
});