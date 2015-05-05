
Ext.onReady(function(){
		//创建数据包数据模型
		Ext.regModel('Dictionary', {
		    fields: [
				{name: 'id'},
				{name: 'examTypeID'},
				{name: 'areaId'},
				{name: 'areaName'},
				{name: 'examYear'}
			]
		});
		//定义数据包数据源对象
		var dictionaryStore = Ext.create('Ext.data.Store',{
			autoLoad :true,
			model : 'Dictionary',
			pageSize:2,
			proxy: {
		        type: 'ajax',
		        url : 'dictionary/pagination',
		        reader: {
		            type: 'json',
		            root:'data',
		            totalProperty: 'totalCount'  
		        }
		    }
		});

		//创建Grid表格组件
		var dictionaryGrid = new Ext.grid.Panel({
			region: 'center',
			store: dictionaryStore,
			selModel : new Ext.selection.CheckboxModel(),
			columns: [//配置表格列
			//	{text: "行号", width:"10%", xtype:'rownumberer' },
				{text: "编号", width: "20%", dataIndex: 'id', sortable: true},
				{text: "考试类别", width: "20%", dataIndex: 'examTypeID', sortable: true
				 ,xtype:'booleancolumn',
				 trueText:'是',
				 falseText:'否'
				},
				{text: "省份编号", width: "20%", dataIndex: 'areaId', sortable: true,
					editor:{
						xtype:'textfield',
						allowBlank:false
						
					
					}
				},
				{text: "年度", width: "20%", dataIndex: 'examYear', sortable: true,
					xtype:'templatecolumn',
					tpl:'{examYear}<tpl if="examYear==2013">年</tpl>'
				},
				{text: "操作", width: "20%", 
					xtype:'actioncolumn',
					items:[
//					{
//						icon:'images/edit.gif',
//						handler:function(grid, rowIndex, colIndex){
//							var rec = grid.getStore().getAt(rowIndex);
//		                    alert("编辑 " + rec.get('id'));
//						}
//					},
						{
						icon:'resources/images/del.gif',
						handler:function(grid,rowIndex,colIndex){
							var rec = grid.getStore().getAt(rowIndex);
							var idW = rec.get('id'); 
							var requestConfig ={
								url:"dictionary/delete",
								params:{id:idW},
								success:function(response,options){
									var result = Ext.JSON.decode(response.responseText);
									if(result.success){
										  dictionaryStore.remove(rec);
										  Ext.Msg.alert('提示','删除数据包信息成功。');
									}else{
										Ext.Msg.alert('提示','删除数据包信息失败。');
									}
								}
							}
							Ext.Ajax.request(requestConfig);
						}
					}
//					,{
//		                icon: 'images/save.gif',//指定编辑图标资源的URL 
//		                handler: function(grid, rowIndex, colIndex) {
//		                    var rec = grid.getStore().getAt(rowIndex);
//		                    
//		                    alert("保存 " + rec.get('examYear'));
//		                }                
//		            }
		            ]
				}
			],
			plugins:[
				Ext.create('Ext.grid.plugin.CellEditing',{
					clicksToEdit:2
				})
			],
			
			dockedItems:[{
				dock: 'top',
            	xtype: 'toolbar',
            	items:[
            		{text : '新增',iconCls:'option',width:"10%",handler:addDic}
            		
            	]
            }],
			bbar: new Ext.PagingToolbar({
	            store: dictionaryStore,//与grid是相同的store
	            displayInfo: true,
	            displayMsg: '当前显示记录: {0} - {1} 共计: {2}',
	            emptyMsg: "没有记录可以显示"
        	})
		});
		
		new Ext.container.Viewport({
			layout:'border',//表格布局
			items : dictionaryGrid
		});
		
		dictionaryGrid.on('edit',function (editor, e){
			var dictionary= e.record;
			var idP =dictionary.get('id');
			var examTypeIDP =dictionary.get('examTypeID');
			var areaIdP =dictionary.get('areaId');
			var areaNameP =dictionary.get('areaName');
			var examYearP =dictionary.get('examYear');
			
			var requestConfig = {
				url:'dictionary/update',
				params:{id:idP,
						examTypeID:examTypeIDP,
						areaId:areaIdP,
						areaName:areaNameP,
						examYear:examYearP
					}
			}
			Ext.Ajax.request(requestConfig);
			e.record.commit();
		});
		
		//add
		
		
		var dicForm = new Ext.form.Panel({
			fieldDefaults:{//统一设置表单字段默认属性
				labelSeparator :'：',//分隔符
				labelWidth : 80,//标签宽度
				msgTarget : 'side',
				width : 300
			},
			bodyPadding: 5,
			frame:true,
			items : [{
				xtype:'textfield',
				allowBlank : false,
				blankText : '不能为空',
				name : 'examTypeID',
				fieldLabel:'考试类型'
			},{
				xtype:'textfield',
				allowBlank : false,
				blankText : '不能为空',
				name : 'areaId',
				fieldLabel:'省份编码'
			
			},{
				xtype:'textfield',
				allowBlank : false,
				blankText : '不能为空',
				name : 'examYear',
				fieldLabel:'年度'
				
			}],
			buttons:[{
				text : '提交',
				handler : submitForm
			},{
				text : '关闭',
				handler : function(){
					win.hide();
				}
			},'->']
		});
		
		var win = new Ext.window.Window({
			layout:'fit',
		    width:380,
		    closeAction:'hide',
		    height:280,
			resizable : false,
			shadow : true,
			modal :true,
		    closable:true,
			items:dicForm
		});
		
		function addDic(){
			win.setTitle("新增编码");
		    win.show();
		}
		function submitForm(){
			dicForm.form.submit({
					clientValidation:true,//进行客户端验证
					waitMsg : '正在提交数据请稍后',//提示信息
					waitTitle : '提示',//标题
					method:'POST',
					url : 'dictionary/addDic',//请求的url地址
					success:function(form,action){//加载成功的处理函数
						win.hide();
						updateDicGrid(action.result.areaId);
						Ext.Msg.alert('提示','增加成功');
					}
			})
		}
			
		//明细数据修改后，同步更新列表信息
		function updateDicGrid(id){
			var values = dicForm.form.getValues();
			var index = dictionaryStore.find('id',values['id']);
			var examTypeIDField = dicForm.form.findField('examTypeID');
			var examTypeID = examTypeIDField.getRawValue();
			var areaIdField = dicForm.form.findField('areaId');
			var areaId = areaIdField.getRawValue();
			var examYearField = dicForm.form.findField('examYear');
			var examYear = examYearField.getRawValue();
			if(index != -1){
				var item = dictionaryStore.getAt(index);
				for(var fieldName in values){
					item.set(fieldName,values[fieldName]);
				}
				item.set('id',id);
				item.set('examTypeID',examTypeID);
				item.set('areaId',areaId);
				item.set('examYear',examYear);
				item.commit();
			}
		}	
		
	});