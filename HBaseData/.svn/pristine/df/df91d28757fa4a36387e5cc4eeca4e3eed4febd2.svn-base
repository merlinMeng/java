
Ext.onReady(function(){
		//创建数据包数据模型
		Ext.regModel('Dapama', {
		    fields: [
				{name: 'tableName'},
				{name: 'dirName'},
				{name: 'tblDesc'},
				{name: 'creator'},
				{name: 'createDate'}
			]
		});
		//定义数据包数据源对象
		var dapamaStore = Ext.create('Ext.data.Store',{
			autoLoad :true,
			model : 'Dapama',
			pageSize:20,
			proxy: {
		        type: 'ajax',
		        url : 'table/listJson',
		        reader: {
		            type: 'json',
		            root:'data'
		        }
		    }
		});

		//创建Grid表格组件
		var dapamaGrid = new Ext.grid.Panel({
			region: 'center',
			store: dapamaStore,
			selModel : new Ext.selection.CheckboxModel(),
			plugins:[
				Ext.create('Ext.grid.plugin.CellEditing',{
					clicksToEdit:1
				})
			],
			
			columns: [//配置表格列
				{text: "表名", width: "50%", dataIndex: 'tableName', sortable: true},
				{text: "表描述", width: "50%", dataIndex: 'tblDesc', sortable: true}
//				{text: "创建日期", width: "30%", dataIndex: 'createDate', sortable: true
//				 ,xtype:'datecolumn'
//				 ,format:'Y年m月d日'
//				 editor:{
//				 	xtype:'datefield'
//				 }
//				}
			],
			dockedItems:[{
				dock: 'top',
            	xtype: 'toolbar',
            	items:[
            		{text : '查看',iconCls:'option',width:"10%",handler:showTable}
            	]
            }]
		});
		
		new Ext.container.Viewport({
			layout:'border',//表格布局
			items : dapamaGrid
		});
		
		
	//------------------------------------column--------------------------------------------------------------	
		//创建数据包数据模型
		Ext.regModel('Column', {
		    fields: [
				{name: 'tableName'},
				{name: 'columnName'},
				{name: 'colDescription'},
				{name: 'dataType'},
				{name: 'dataLenght'},
				{name: 'creator'},
				{name: 'createDate'}
			]
		});
		
		
	
		//显示窗口
		function showTable(){
			var talbeList = getTableIdList();
			var num = talbeList.length;
			if(num > 1){
				Ext.MessageBox.alert("提示","每次只能查看一条数据包信息。");
			}else if(num == 1){
				win.setTitle("查看表信息");
				var tableName = talbeList[0];
				columnStore.load({
					params:{tableName:tableName}
					
				});
				win.show();
			}
		}
		
		
		//定义数据包数据源对象
		var columnStore = Ext.create('Ext.data.Store',{
			autoLoad :true,
			model : 'Column',
					pageSize:20,
					proxy: {
				        type: 'ajax',
				        url : 'table/listJsonForColumn',
				        reader: {
				            type: 'json',
				            root:'data'
				        }
				    }
			
		});
		//创建Grid表格组件
		var columnGrid = new Ext.grid.Panel({
			store: columnStore,
			columns: [//配置表格列
				{text: "表名", width: "25%", dataIndex: 'tableName', sortable: true},
				{text: "列名", width: "15%", dataIndex: 'columnName', sortable: true},
				{text: "列描述", width: "20%", dataIndex: 'colDescription', sortable: true},
				{text: "数据类型", width: "20%", dataIndex: 'dataType', sortable: true},
				{text: "数据长度", width: "20%", dataIndex: 'dataLenght', sortable: true}
//				{text: "创建日期", width: "20%", dataIndex: 'createDate', sortable: true
//				 ,xtype:'datecolumn',
//				 format:'Y年m月d日'
//				}
			]
		});
		//创建弹出窗口
		var win = new Ext.window.Window({
			layout:'fit',
		    width:780,
		    closeAction:'hide',
		    height:480,
			resizable : true,
			shadow : true,
			modal :true,
		    closable:true,
			items:columnGrid
		});
		
		
		
		//取得所选数据包id
		function getTableIdList(){
			var recs = dapamaGrid.getSelectionModel().getSelection();
			var list = [];
			if(recs.length == 0){
				Ext.MessageBox.alert('提示','请选择要进行操作的数据包！');
			}else{
				for(var i = 0 ; i < recs.length ; i++){
					var rec = recs[i];
					list.push(rec.get('tableName'));
				}
			}
			return list;
		}
		
		
		
	});