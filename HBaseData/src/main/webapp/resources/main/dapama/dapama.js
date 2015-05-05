
Ext.onReady(function(){
		//创建数据包数据模型
		Ext.regModel('Dapama', {
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
				{name: 'kgMaxScore'}
			]
		});
		//定义数据包数据源对象
		var dapamaStore = Ext.create('Ext.data.Store',{
			autoLoad :true,
			model : 'Dapama',
			pageSize:20,
			proxy: {
		        type: 'ajax',
		        url : 'dapama/listJsonForPagination',
		        reader: {
		            type: 'json',
		            root:'data',
		            totalProperty: 'totalCount'  
		        }
		    }
		});

		//创建Grid表格组件
		var dapamaGrid = new Ext.grid.Panel({
			region: 'center',
			store: dapamaStore,
			selModel : new Ext.selection.CheckboxModel(),
			columns: [//配置表格列
				{text: "包id", width: 80, dataIndex: 'packageId', sortable: true},
				{text: "考试名称", width: 80, dataIndex: 'examName', sortable: true},
				{text: "课程id", width: 80, dataIndex: 'courseId', sortable: true},
				{text: "课程名字", width: 80, dataIndex: 'courseName', sortable: true},
				{text: "扫描文件名", width: 80, dataIndex: 'scanFileName', sortable: true},
				{text: "扫描文件格式", width: 80, dataIndex: 'scanMode', sortable: true},
				{text: "扫描图片路径", width: 80, dataIndex: 'scanImgDir', sortable: true},
				{text: "作文题目", width: 80, dataIndex: 'writeItemId', sortable: true},
				{text: "答题卡的数量", width: 80, dataIndex: 'cardNum', sortable: true},
				{text: "满分", width: 80, dataIndex: 'fullScore', sortable: true},
				{text: "报名文件名", width: 80, dataIndex: 'bmkfileName', sortable: true},
				{text: "报名文件格式", width: 80, dataIndex: 'bmkmode', sortable: true},
				{text: "评卷文件名", width: 80, dataIndex: 'pjFileName', sortable: true},
				{text: "评卷文件格式", width: 80, dataIndex: 'pjMode', sortable: true},
				{text: "成绩文件名", width: 80, dataIndex: 'cjFileName', sortable: true},
				{text: "成绩文件格式", width: 80, dataIndex: 'cjMode', sortable: true},
				{text: "客观题分数", width: 80, dataIndex: 'kgMaxScore', sortable: true}
			],
			dockedItems:[{
				dock: 'top',
            	xtype: 'toolbar',
            	items:[
            		{text : '修改',iconCls:'option',handler:showModifyDapama,width:"10%"},
            		'-',
            		{text : '删除',iconCls:'remove',handler:showDeleteDapama,width:"10%"},
            		{ xtype:'tbspacer',width:"60%"}
//            		{
//            			width: "20%",
//                		fieldLabel: '搜索',
//                		labelWidth: 50,
//                		xtype: 'searchfield',
//                		store: dapamaStore
//            		}
            	]
            }],
			bbar: new Ext.PagingToolbar({
	            store: dapamaStore,//与grid是相同的store
	            displayInfo: true,
	            displayMsg: '当前显示记录: {0} - {1} 共计: {2}',
	            emptyMsg: "没有记录可以显示"
        	})
        
		});
		
		new Ext.container.Viewport({
			layout:'border',//表格布局
			items : dapamaGrid
		});
		
		//创建新增或修改数据包信息的form表单
		Ext.QuickTips.init();
		
		
		var dapamaForm = new Ext.form.Panel({
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
				name : 'packageId',
				
				fieldLabel:'包id'
			},{
				xtype:'textfield',
				allowBlank : false,
				blankText : '不能为空',
				name : 'scanFileName',
				fieldLabel:'扫描文件名'
			
			},{
				xtype:'textfield',
				allowBlank : false,
				blankText : '不能为空',
				name : 'scanImgDir',
				fieldLabel:'扫描图片路径'
				
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
		//创建弹出窗口
		var win = new Ext.window.Window({
			layout:'fit',
		    width:380,
		    closeAction:'hide',
		    height:280,
			resizable : false,
			shadow : true,
			modal :true,
		    closable:true,
			items:dapamaForm
		});
		
		//显示删除改数据包对话框
		function showDeleteDapama(){
			var dapamaList = getdapamaIdList();
			var num = dapamaList.length;
			if(num == 0){
				return;
			}
			Ext.MessageBox.confirm("提示","您确定要删除所选数据包吗？",function(btnId){
				if(btnId == 'yes'){
					deleteDapama(dapamaList);
				}
			});
		}
		
		//删除数据包
		function deleteDapama(dapamaList){
			var packageIds = dapamaList.join(',');
			var msgTip = Ext.MessageBox.show({
				title:'提示',
				width : 250,
				msg:'正在删除数据包信息请稍后......'
			});
			Ext.Ajax.request({
				url : 'dapama/deleteDataPackage',
				params : {packageIds : packageIds},
				method : 'POST',
				success : function(response,options){
					msgTip.hide();
					var result = Ext.JSON.decode(response.responseText);
					if(result.success){
						//服务器端数据成功删除后，同步删除客户端列表中的数据
						for(var i = 0 ; i < dapamaList.length ; i++){
							var index = dapamaStore.find('packageId',dapamaList[i]);
							if(index != -1){
								var rec = dapamaStore.getAt(index);
								dapamaStore.remove(rec);
							}
						}
						Ext.Msg.alert('提示','删除数据包信息成功。');
					}else{
						Ext.Msg.alert('提示','删除数据包信息失败！');
					}
				},
				failure : function(response,options){
					msgTip.hide();
					Ext.Msg.alert('提示','删除数据包信息请求失败！');
				}
			});
		}
		
		//显示修改数据包窗口
		function showModifyDapama(){
			var dapamaList = getdapamaIdList();
			var num = dapamaList.length;
			if(num > 1){
				Ext.MessageBox.alert("提示","每次只能修改一条数据包信息。");
			}else if(num == 1){
				dapamaForm.form.reset();
				dapamaForm.isAdd = false;
				win.setTitle("修改数据包信息");
				win.show();
				var packageId = dapamaList[0];
				loadForm(packageId);
			}
		}
		
		
		//加载表单数据
		function loadForm(packageId){
			dapamaForm.form.load({
				waitMsg : '正在加载数据请稍后',//提示信息
				waitTitle : '提示',//标题
				url : 'dapama/pojoJson',//请求的url地址
				params : {packageId:packageId},
				method:'GET',//请求方式
				success:function(form,action){
					Ext.Msg.alert('提示','数据加载成功');
				},
				failure:function(form,action){//加载失败的处理函数
					Ext.Msg.alert('提示','数据加载失败');
				}
			});
		}
		//提交表单数据
		function submitForm(){
			//判断当前执行的提交操作，isAdd为true表示执行新增操作，false表示执行修改操作
			if(dapamaForm.isAdd){
				
			}else{
				//修改信息
				dapamaForm.form.submit({
					clientValidation:true,//进行客户端验证
					waitMsg : '正在提交数据请稍后',//提示信息
					waitTitle : '提示',//标题
					url : 'dapama/updateDataPackage',//请求的url地址
					method:'POST',//请求方式
					success:function(form,action){//加载成功的处理函数
						win.hide();
						updateDapamaGrid(action.result.packageId);
						Ext.Msg.alert('提示','修改成功');
					},
					failure:function(form,action){//加载失败的处理函数
						Ext.Msg.alert('提示','修改失败');
					}
				});
			}
		}
		//明细数据修改后，同步更新列表信息
		function updateDapamaGrid(packageId){
			var values = dapamaForm.form.getValues();
			var index = dapamaStore.find('packageId',values['packageId']);
			var scanFileNameField = dapamaForm.form.findField('scanFileName');
			var scanFileName = scanFileNameField.getRawValue();
			var scanImgDirField = dapamaForm.form.findField('scanImgDir');
			var scanImgDir = scanImgDirField.getRawValue();
			if(index != -1){
				var item = dapamaStore.getAt(index);
				for(var fieldName in values){
					item.set(fieldName,values[fieldName]);
				}
				item.set('scanFileName',scanFileName);
				item.set('scanImgDir',scanImgDir);
				item.commit();
			}
		}
		
		//取得所选数据包id
		function getdapamaIdList(){
			var recs = dapamaGrid.getSelectionModel().getSelection();
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
	});