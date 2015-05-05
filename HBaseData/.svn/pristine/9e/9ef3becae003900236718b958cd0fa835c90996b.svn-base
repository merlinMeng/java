Ext.onReady(function(){
	//主题数据
		var themes = [
			{theme:'默认', css:'ext-all.css'},
			{theme:'黑色',css: 'ext-all-gray.css'},
			{theme:'红色',css: 'ext-all-neptune.css'}];
		//创建主题数据模型
		Ext.regModel('Theme', {
		    fields: ['theme','css']
		});
		//创建主题数据源
		var themeStore = Ext.create('Ext.data.Store',{
			model : 'Theme',
			data : themes
		});
		//创建主题切换选择框
		var themeChange = Ext.create('Ext.form.ComboBox',{
			id : 'themeChange',
			width : 150,
			labelWidth : 60,
			labelSeparator :'：',//分隔符
			fieldLabel:'样式选择',
			store : themeStore,
			editable : false,
			triggerAction: 'all',//单击触发按钮显示全部数据
			store : themeStore,//设置数据源
			displayField : 'theme',
			valueField : 'css',
			queryMode: 'local',//本地模式
			value:'ext-all.css',//默认风格
			listeners : {
				'collapse' : function() {
					Ext.util.CSS.swapStyleSheet('theme', 'resources/extjs/resources/css/'+ this.getValue());
					contentIframe.window.themeChange(this.getValue());
				}
			}
		});
	
		
	//头部信息。。。。
	var toolbarTop = Ext.create('Ext.toolbar.Toolbar',{
		items:[
			'-',
			{ xtype:'tbspacer',width:'90%'},
			'-',
			{ text:'退出登录',handler:exit,width:'10%'}
		]
	});
	function onButtonClick(btn){
		alert(btn.text);
	};
	function exit(){
		window.location.href='login/loginExit';
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
					text:'数据包导入',
					leaf:true,
					url:'dapama/peparedaddList'
				},
//					{
//					text:'数据包导出',
//					leaf:true,
//					url:'dapama/pepareddownList.do'
//				},
				{
					text:'数据包管理',
					leaf:true,
					url:'packageinfo/turnList'
				},{
					text:'元数据管理',
					leaf:true,
					url:'table/turnList'
				},{
					text:'任务管理',
					leaf:true,
					url:'jobinfo/turnList'
				}
//				,{
//					text:'角色管理',
//					leaf:true,
//					url:'dataPackManager/daPaMa'
//				}
//				,{
//					text:'字典管理',
//					leaf:true,
//					url:'dictionary/turnlist'
//				}	
//				},{
//					text:'图片上传',
//					leaf:true,
//					url:'imagemanage/turnupload'
//				}                    
			],
			listeners:{
	        	expand : function(node){
	        		//切换内容页面
	        		changePage(node.get('url'), node.get('text'));
	        	}
	        }
		},
        root: {
            text: '系统管理',
            url : 'main/about.jsp',
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
				title:'<font size=3>海云天大数据管理平台（Seaskylight DaaS）</font>',
				dockedItems:toolbarTop
			},{
				title : '功能菜单',
				items : menuTree,
				split:true,
				collapsible: true,
				region:'west',//指定子面板所在区域为west
				tbar : [themeChange],
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