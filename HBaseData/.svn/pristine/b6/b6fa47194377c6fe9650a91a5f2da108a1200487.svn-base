
Ext.onReady(function(){
		//创建数据包数据模型
		Ext.regModel('PackageInfo', {
		    fields: [
				{name: 'packageId'},
				{name: 'examName'},
				{name: 'examTypeID'},
				{name: 'areaId'},
				{name: 'areaName'},
				{name: 'examYear'},
				{name: 'examDate'},
				{name: 'courseNum'},
				{name: 'rootDir'},
				{name: 'courseStr'},
				{name: 'reg_Date'},
				{name: 'state'},
				{name:	'imageUploadStatus'}
				
			]
		});
		//定义数据包数据源对象
		var PackageInfoStore = Ext.create('Ext.data.Store',{
			autoLoad :true,
			model : 'PackageInfo',
			pageSize:20,
			proxy: {
		        type: 'ajax',
		        url : 'packageinfo/listjsonforpagination',
		        reader: {
		            type: 'json',
		            root:'data',
		            totalProperty: 'totalCount'  
		        }
		    }
		});

		//创建Grid表格组件
		var PackageInfoGrid = new Ext.grid.Panel({
			region: 'center',
			store: PackageInfoStore,
			selModel : new Ext.selection.CheckboxModel(),
			columns: [//配置表格列
				{text: "数据包编号", width: "10%", dataIndex: 'packageId', sortable: true},
				{text: "考试名称", width: "10%", dataIndex: 'examName', sortable: true},
				{text: "考试类别", width: "10%", dataIndex: 'examTypeID', sortable: true},
				{text: "省份", width: "20%", dataIndex: 'areaName', sortable: true},
				{text: "年度", width: "10%", dataIndex: 'examYear', sortable: true},
				{text: "科目数", width: "10%", dataIndex: 'courseNum', sortable: true},
				{text: "状态", width: "10%", dataIndex: 'state', sortable: true},
				{text: "上传状态", width: "10%", dataIndex: 'imageUploadStatus', sortable: true},
				{text: "操作", width: "20%", 
					xtype:'actioncolumn',
					items:[{
							icon:'resources/images/del.gif',
							handler:function(grid,rowIndex,colIndex){
								var rec = grid.getStore().getAt(rowIndex);
								var idW = rec.get('packageId'); 
								var requestConfig ={
									url:"packageinfo/delete",
									params:{id:idW},
									success:function(response,options){
										var result = Ext.JSON.decode(response.responseText);
										if(result.success){
											  PackageInfoStore.remove(rec);
											  Ext.Msg.alert('提示','删除数据包信息成功。');
										}else{
											Ext.Msg.alert('提示','删除数据包信息失败。');
										}
									}
								}
								Ext.Ajax.request(requestConfig);
							}
						}
		            ]
				}
			],
			dockedItems:[{
				dock: 'top',
            	xtype: 'toolbar',
            	items:[
            		
            		{text : '查看',iconCls:'option',width:"10%",handler:showCourse},
            		{text : '生成测评数据包',iconCls:'option',width:"10%",handler:createJob}
            	]
            }],
			bbar: new Ext.PagingToolbar({
	            store: PackageInfoStore,//与grid是相同的store
	            displayInfo: true,
	            displayMsg: '当前显示记录: {0} - {1} 共计: {2}',
	            emptyMsg: "没有记录可以显示"
        	})
        
		});
		
		new Ext.container.Viewport({
			layout:'border',//表格布局
			items : PackageInfoGrid
		});
		
		
		//创建数据包数据模型
		Ext.regModel('PackageCourse', {
		    fields: [
				{name: 'packageId'},
				{name: 'examName'},
				{name: 'courseId'},
				{name: 'courseName'},
				{name: 'scanFileName'},
				{name: 'scanMode'},
				{name: 'scanImgDir'},
				{name: 'writeItemId'},
				{name: 'cardNum'},
				{name: 'fullScore'},
				{name: 'bmkfileName'},
				{name: 'bmkmode'},
				{name: 'pjFileName'},
				{name: 'pjMode'},
				{name: 'cjFileName'},
				{name: 'cjMode'},
				{name: 'kgMaxScore'},
				{name: 'zhgMaxScore'}
			]
		});
		
		//定义数据包数据源对象
		var packageCourseStore = Ext.create('Ext.data.Store',{
			autoLoad :true,
			model : 'PackageCourse',
					pageSize:20,
					proxy: {
				        type: 'ajax',
				        url : 'dapama/listcoursejson',
				        reader: {
				            type: 'json',
				            root:'data'
				        }
				    }
			
		});
		
		//创建Grid表格组件
		var packageCourseGrid = new Ext.grid.Panel({
			store: packageCourseStore,
			columns: [//配置表格列
				{text: "科目编码", width: "20%", dataIndex: 'courseId', sortable: true},
				{text: "科目名称", width: "20%", dataIndex: 'courseName', sortable: true},
				{text: "科目满分", width: "20%", dataIndex: 'fullScore', sortable: true},
				{text: "客观题满分", width: "20%", dataIndex: 'kgMaxScore', sortable: true},
				{text: "主观题满分", width: "20%", dataIndex: 'zhgMaxScore', sortable: true}	
				
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
			items:packageCourseGrid
		});
		//生成任务
		function createJob(){
			var packageList = getPackageInfoIdList();
			var flag = isEnd();
			var num = packageList.length;
			if(num == 0){
				Ext.MessageBox.alert("提示","请选择数据。");
			}else{
				if(flag){
					Ext.Ajax.request({
						url : 'packageinfo/createJob',
						params : {packageIds : packageList},
						method : 'POST',
						success : function(response,options){
							
							var result = Ext.JSON.decode(response.responseText);
							if(result.success){
								Ext.Msg.alert('提示','任务进行中，请查看任务管理！');
							}else{
								Ext.Msg.alert('提示','任务进行中，请查看任务管理！');
							}
						
						},
						failure : function(response,options){
							Ext.Msg.alert('提示','任务生成失败！');
						}
						
					});
				}
			}
			
			
		}
		//显示窗口
		function showCourse(){
			var packageList = getPackageInfoIdList();
			var num = packageList.length;
			if(num > 1){
				Ext.MessageBox.alert("提示","每次只能查看一条数据包信息。");
			}else if(num == 1){
				var packageid = packageList[0];
				win.setTitle(packageid);
				packageCourseStore.load({
					params:{packageId:packageid}
				});
				win.show();
			}
		}
		
		//取得所选数据包id
		function getPackageInfoIdList(){
			var recs = PackageInfoGrid.getSelectionModel().getSelection();
			var list = [];
			if(recs.length == 0){
				Ext.MessageBox.alert('提示','请选择要进行操作的数据包！');
			}else{
				for(var i = 0 ; i < recs.length ; i++){
					var rec = recs[i];
					list.push(rec.get('packageId'));
				}
			}
			return list;
		}
		function isEnd(){
			var recs = PackageInfoGrid.getSelectionModel().getSelection();
			var list = [];
			if(recs.length == 0){
				Ext.MessageBox.alert('提示','请选择要进行操作的数据包！');
			}else{
				for(var i = 0 ; i < recs.length ; i++){
					var rec = recs[i];
					if(!(rec.get('state')=="END")){
						Ext.MessageBox.alert('提示','选择中有未导入数据库的，请重新选择！');
						return false;
					}
					
				}
			}
			return true;
		}
	});