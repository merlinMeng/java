Ext.onReady(function(){
	Ext.regModel('Bookinfo',{
		fields:[
				{name:'bookName'}
		]
	})
	
	var bookStore = Ext.create('Ext.data.Store',{
		model:'Bookinfo',
		proxy:{
			type:'ajax',
			url:'menu/menuList.do',
			reader:new Ext.data.ArrayReader({
				medol:'Bookinfo'
			})
		}
		
	});
	//create form
	var uploadForm = Ext.create('Ext.form.Panel',{
		title:'Ext.form.field.ComboBox 远程数据员示例',
		frame:true,
		height:200,
		width:270,
		renderTo:Ext.getBody(),
		bodyPadding:5,
		defaluts:{
			labelSeparator:':',
			labelWidth:70,
			width:200,
			labelAlig:'left'
		},
		items : [
				
				{
					xtype:'combo',
					fieldLabel:'书籍类别',
					listConfig:{
						loadingText:'正在加载书籍信息',
						emptyText:'未找到匹配值',
						maxHeigth:60
					},
					//allQuery:'allbook',
					minChars:3,
					queryDelay:300,
					queryParam:'searchbook',
					triggerAction:'all',
					store:bookStore,
					displayField:'bookName',
					valueField:'bookName',
					queryMode:'remote'
			    },{
					xtype:'datefield',
					fieldLabel:'日期选择',
					labelSeparator:':',
					msgTarget:'side',
					format:'Y-m-d',
					width:220,
					value:'2014-05-07'
					
			    },{
					xtype:'filefield',
					name:'photo',
					fieldLabel:'照片',
					anchor:'100%',
					buttonText:'选择照片。。'
					
			    }
		],
		buttons : [
			{
				text:'上传文件',
				handler:function(){
					var form = uploadForm.getForm();
					if(form.isValid()){
						form.submit({
							url:'menu/menuList.do',
							waitMsg:'kjdkjfd',
							success:function(fp,o){
								Ext.Msg.alert('提示信息','dfd');
							}
						});
					}
				}
			}
		]
		
		
	})
});