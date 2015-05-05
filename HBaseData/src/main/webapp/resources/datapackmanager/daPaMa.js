
Ext.onReady(function(){
	
	//创建菜单数据模型
	Ext.regModel('Menu',{
		fields:['text','url']
	});
	//创建菜单树数据源
	var menuStore = new Ext.data.TreeStore({
		model:'Menu',
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
		root:{
			text:'系统说明',
			leaf:false,
			url:'dataPackManager/pagesExt/about.jsp',
			expanded:true
		},
		listeners:{
	        	expand : function(node){
	        		//切换内容页面
	        		changePage(node.get('url'), node.get('text'));
	        	}
	        }
	
	});
	
	function changePage(url,title){
		//Ext.getDom('contentIframe').src =url;
		
		
	}
	
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
	

	var bookStore = Ext.create('Ext.data.Store',{
		autoLoad :true,
		model:'Subject',
		proxy:{
			type:'memory',
			data:datas,
			reader:'array'
			
		}
	});
	var  datas=[
			['ls','理数','150','24','126'],
			['ws','文数','150','25','126']
			];
	var  datasPack=[
			['0001','2012宁夏高考','高考','宁夏','2012','6','完成','完成']
			];	
	var  datasUser=[
			['zhangsan','super','研发','1231546','wqwq@qq.com','2013-06-04'],
			['zhangsan','super','研发','1231546','wqwq@qq.com','2013-06-04'],
			['zhangsan','super','研发','1231546','wqwq@qq.com','2013-06-04'],
			['zhangsan','super','研发','1231546','wqwq@qq.com','2013-06-04'],
			['zhangsan','super','研发','1231546','wqwq@qq.com','2013-06-04'],
			['zhangsan','super','研发','1231546','wqwq@qq.com','2013-06-04'],
			['zhangsan','super','研发','1231546','wqwq@qq.com','2013-06-04']
			];	
	var  metadata=[
			['id','columnName','tableName','descript'],
			['2','user','user','用户表'],
			['2','name','user','用户名字'],
			['2','password','user','用户密码']
			];			
			

	
	//toolbar 工具条。
	var toolbarTop = Ext.create('Ext.toolbar.Toolbar',{
		
	});
	
	toolbarTop.add([
		
		'-',
		{ xtype:'tbspacer',width:'80%'},
		'-',
		{ text:'当前用户:mmmm',handler:onButtonClick,iconCls:'saveIcon',width:'10%'},
		'-',
		{ text:'退出登录',handler:onButtonClick,iconCls:'saveIcon',width:'10%'}
	]);
	
	function onButtonClick(btn){
		alert(btn.text);
	};
	

	//数据包考试科目信息
	var bookGrid = new Ext.grid.Panel({
	
		store:{
			autoLoad :true,
			fields:['id','name','fullScore','objScore','subScore'],
			proxy:{
			type:'memory',
			data:datas,
			reader:'array'
			}
		},
		columns:[
		{	text:'科目编号',width:'20%',dataIndex:'id',sortable:true },
		{	text:'科目名称',width:'20%',dataIndex:'name',sortable:true },
		{	text:'科目满分',width:'20%',dataIndex:'fullScore',sortable:true },
		{	text:'客观题分数',width:'20%',dataIndex:'objScore',sortable:true },
		{	text:'主观题分数',width:'20%',dataIndex:'subScore',sortable:true }
		]
		
	});
	//数据包管理列表
	var bookGridPack = new Ext.grid.Panel({
		//tbar:toolbar,
		//renderTo:Ext.getBody(),
		store:{
			autoLoad :true,
			fields:['id','name','class','province','year','subject','num','bar1'],
			proxy:{
			type:'memory',
			data:datasPack,
			reader:'array'
			}
		},
		columns:[
		{	text:'包id',width:'10%',dataIndex:'id',sortable:true },
		{	text:'考试名称',width:'20%',dataIndex:'name',sortable:true },
		{	text:'课程id',width:'20%',dataIndex:'class',sortable:true },
		{	text:'课程名字',width:'10%',dataIndex:'province',sortable:true },
		{	text:'报名文件名',width:'10%',dataIndex:'year',sortable:true },
		{	text:'报名文件格式',width:'10%',dataIndex:'subject',sortable:true },
		{	text:'扫描文件名',width:'10%',dataIndex:'num',sortable:true },
		{	text:'扫描文件格式',width:'10%',dataIndex:'bar1',sortable:true },
		
		{	text:'评卷文件名',width:'10%',dataIndex:'id',sortable:true },
		{	text:'评卷文件格式',width:'20%',dataIndex:'name',sortable:true },
		{	text:'成绩文件名',width:'20%',dataIndex:'class',sortable:true },
		{	text:'成绩文件格式',width:'10%',dataIndex:'province',sortable:true },
		{	text:'扫描图片路径',width:'10%',dataIndex:'year',sortable:true },
		{	text:'作文题目',width:'10%',dataIndex:'subject',sortable:true },
		{	text:'答题卡的数量',width:'10%',dataIndex:'num',sortable:true },
		{	text:'满分',width:'10%',dataIndex:'bar1',sortable:true },
		{	text:'客观题分数',width:'10%',dataIndex:'bar1',sortable:true }
		
		]
		
		
	});
	//用户列表
	var gridUser = new Ext.grid.Panel({
		//tbar:toolbar,
		//renderTo:Ext.getBody(),
		store:{
			autoLoad :true,
			fields:['name','group','dept','phone','mail','date'],
			proxy:{
			type:'memory',
			data:datasUser,
			limit:2,
			page:2,
			start:0,
			reader:'array'
			}
		},
		columns:[
		{	text:'用户名',width:'20%',dataIndex:'name',sortable:true },
		{	text:'用户组',width:'20%',dataIndex:'group',sortable:true },
		{	text:'部门',width:'20%',dataIndex:'dept',sortable:true },
		{	text:'电话',width:'10%',dataIndex:'phone',sortable:true },
		{	text:'邮箱',width:'20%',dataIndex:'mail',sortable:true },
		{	text:'添加日期',width:'10%',dataIndex:'date',sortable:true }
		],
		bbar: Ext.create('Ext.PagingToolbar', {
                    store: datasUser,
                    displayInfo: true,
                    displayMsg: '显示{0}-{1}条，共{2}条',
                    emptyMsg: "没有数据"
                })
		
	});
	
	//用户列表
	var gridMeta = new Ext.grid.Panel({
		//tbar:toolbar,
		//renderTo:Ext.getBody(),
		store:{
			autoLoad :true,
			fields:['id','column','tableName','description'],
			proxy:{
			type:'memory',
			data:metadata,
			reader:'array'
			}
		},
		columns:[
		{	text:'主键',width:'10%',dataIndex:'id',sortable:true },
		{	text:'列名',width:'10%',dataIndex:'column',sortable:true },
		{	text:'表名',width:'10%',dataIndex:'tableName',sortable:true },
		{	text:'描述',width:'70%',dataIndex:'description',sortable:true }
		
		],
		bbar: Ext.create('Ext.PagingToolbar', {
                    store: metadata,
                    displayInfo: true,
                    displayMsg: '显示{0}-{1}条，共{2}条',
                    emptyMsg: "没有数据"
                })
		
	});
	//复选框
	var examTypeData = Ext.create('Ext.data.Store', {
    fields: ['abbr', 'name'],
    data : [
        {"abbr":"AL", "name":"111111"},
        {"abbr":"AK", "name":"22222"},
        {"abbr":"AZ", "name":"33333"}
        //...
    ]
	});
	
	var examType =  Ext.create('Ext.form.ComboBox', {
	    fieldLabel: '考试类别',
	    store: examTypeData,
	    queryMode: 'local',
	    displayField: 'name',
	    valueField: 'abbr'
	   
	});
	
	var examProvinceData = Ext.create('Ext.data.Store', {
    fields: ['abbr', 'name'],
    data : [
        {"abbr":"AL", "name":"成都"},
        {"abbr":"AK", "name":"上海"},
        {"abbr":"AZ", "name":"广州"}
        //...
    ]
	});
	
	var examProvince =  Ext.create('Ext.form.ComboBox', {
	    fieldLabel: '考试省份',
	    store: examTypeData,
	    queryMode: 'local',
	    displayField: 'name',
	    valueField: 'abbr'
	   
	});
	//整体结构
	Ext.create('Ext.container.Viewport',{
		layout:'border',
		title:'border 布局',
		frame:true,
		defaults:{
			//collapsible:true
		},
		items:[
			{
			//html:'<center><font size=6>海云天数据管理系统 </font></center>',
			region:'north',
			height:50,
			
			title:'<center><font size=3>数据管理系统 </font></center>',
			dockedItems:[toolbarTop]
		},{
			title:'<center><font size=2>功能菜单 </font></center>',
			
			split:true,
			region:'west',
			width:180,
			collapsible:true,
			items:[menuTree]

		
		}, {
					id : 'center',
					// items:[bookGrid],
					xtype: 'tabpanel',  

					// html:' center 内容',
					region : 'center',
					layout : 'fit',
					items : [{
								title : '<center><font size=2>考试信息科目</font></center>',
								// html: '添加数据包',
								items : [bookGrid]
							}, {
								title : '<center><font size=2>数据包管理</font></center>',
								// html: '数据包管理',
								// xtype:'grid'
								items : [bookGridPack]

							}, {
								title : '<center><font size=2>添加数据包</font></center>',
								// html: '添加数据包',
								items : [{
											xtype : 'filefield',
											name : 'photo',
											fieldLabel : '数据包员',
											anchor : '100%',
											buttonText : '选择路径。。'

										}, {
											buttons : [{
												text : '上传路径'
											}]
										}]

							},{
								title:'用户管理',
								items:[
									{buttons : [
										{text:'添加'},{text:'删除'}
									]},
									gridUser
								]
								
							},{
								title:'元数据展示',
								items:[gridMeta]
							},{
								title:'批量数据服务',
								items:[
									examType,
									{ 
										
        								fieldLabel: '考试年度',
										xtype:'textfield',
										hideLabel:false
										
									},
									examProvince
								],
								buttons:[
									{text:'分析数据包输出'}
								]
							}
							

					]

				},{ 
                // lazily created panel (xtype:'panel' is default)
                region: 'south',
                //contentEl: 'south',
                //split: false,
                minSize: 100,
                maxSize: 200,
              	title: '<center><font size=2>欢迎访问</font></center>',
                margins: '0 0 0 0'
            }
		]
	});
	
	
	
	


	

});