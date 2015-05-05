Ext.onReady(function(){
	//toolbar 工具条。
	var toolbar = Ext.create('Ext.toolbar.Toolbar',{
		renderTo:'toolbar',
		width:1000
	});
	
	toolbar.add([
		
		{ text:'数据包管理',handler:onButtonClick,iconCls:'newIcon'},
		'-',
		{ text:'元数据管理',handler:onButtonClick,iconCls:'saveIcon'},
		'-',
		{ text:'用户管理',handler:onButtonClick,iconCls:'saveIcon'},
		'-',
		{ 
			xtype:'textfield',
			hideLabel:true,
			width:100
		},
		'-',
		'->',
		'-',
		'<a href="www.baidu.com">dfd</a>',
		'-',
		{ xtype:'tbspacer',width:50},
		'-',
		'test toolbar'
	]);
	
	function onButtonClick(btn){
		alert(btn.text);
	};
	
	Ext.get('enabledBtn').on('click',function(){
		toolbar.enable();
	});
	Ext.get('disenabledBtn').on('click',function(){
		toolbar.disable();
	});
	
	//menu
	
	var fileMenu  = Ext.create('Ext.menu.Menu',{
		shadow :'frame',
		allowOtherMenus:true,
		ignoreParentClicks:true,
		items:[
			new Ext.menu.Item({
				text:'new',
				handler:onMenuItem
			}),
			{text:'open',handler:onMenuItem},
			{text:'close',handler:onMenuItem},
			{
				text:'各人信息',
				menu:new Ext.menu.Menu({
					ignoreParentClicks:true,
					items:[
						{	text:'basic info',
							handler:onMenuItem,
							checked:false,
							group:'theme'
						},
						{	
							text:'fkdlfk',
							handler:onMenuItem,
							checked:false,
							group:'theme'
							
						}
					]
					
				}),
				handler:onMenuItem
			}
			
		]
	});
	
	var editMenu  = Ext.create('Ext.menu.Menu',{
		shadow :'drop',
		allowOtherMenus:true,
		items:[
			
			{text:'copy',handler:onMenuItem},
			{text:'paste',handler:onMenuItem},
			{text:'cut',handler:onMenuItem},
			{	text:'颜色选择',
				menu : new Ext.menu.ColorPicker()
			},
			{ xtype:'datepicker'},
			{ xtype:'buttongroup',
			  columns:3,	
			  ttitle:'按钮组',
			  items:[
			  	{
			  		text:'用户管理',
			  		scale:'large',
			  		colspan:3,
			  		width:170,
			  		iconCls:'userManagerIcon',
			  		iconAlign:'top'
			  	},{
			  		text:'new',iconCls:'newIcon'
			  	},{
			  		text:'open',iconCls:'openIcon',href:'/menu/menuList.do'
			  	}
			  ]
			}
			
		]
	});
	
	toolbar.add(
		{text:'文本',menu:fileMenu},
		{text:'编辑',menu:editMenu}
		);
	function onMenuItem(item){
		alert(item.text);
	}
});