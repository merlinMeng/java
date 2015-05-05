
Ext.onReady(function(){
		//创建数据包数据模型
		Ext.regModel('JobInfo', {
		    fields: [
				{name: 'jobId'},
				{name: 'jobDes'},
				{name: 'packageId'},
				{name: 'status'}
			]
		});
		//定义数据包数据源对象
		var JobInfoStore = Ext.create('Ext.data.Store',{
			autoLoad :true,
			model : 'JobInfo',
			pageSize:20,
			proxy: {
		        type: 'ajax',
		        url : 'jobinfo/listjsonforpagination',
		        reader: {
		            type: 'json',
		            root:'data',
		            totalProperty: 'totalCount'  
		        }
		    }
		});

		//创建Grid表格组件
		var JobInfoGrid = new Ext.grid.Panel({
			region: 'center',
			store: JobInfoStore,
			selModel : new Ext.selection.CheckboxModel(),
			columns: [//配置表格列
				{text: "任务编号", width: "20%", dataIndex: 'jobId', sortable: true},
				{text: "任务描述", width: "40%", dataIndex: 'jobDes', sortable: true},
				{text: "考试编号", width: "20%", dataIndex: 'packageId', sortable: true},
				{text: "状态", width: "20%", dataIndex: 'status', sortable: true}
			
			],
			dockedItems:[{
				dock: 'top',
            	xtype: 'toolbar',
            	items:[
            		
            		{text : '下载任务',iconCls:'option',width:"10%",handler:downfile}
            	]
            }],
			bbar: new Ext.PagingToolbar({
	            store: JobInfoGrid,//与grid是相同的store
	            displayInfo: true,
	            displayMsg: '当前显示记录: {0} - {1} 共计: {2}',
	            emptyMsg: "没有记录可以显示"
        	})
        
		});
		
		new Ext.container.Viewport({
			layout:'border',//表格布局
			items : JobInfoGrid
		});
		
		
		//显示窗口
		function downfile(){
			var idList = getInfoIdList();
			var num = idList.length;
			var flag = isEnd();
			if(flag){
				if(num > 1){
				Ext.MessageBox.alert("提示","每次只能查看一条数据包信息。");
				}else if(num == 1){
				window.location.href = "jobinfo/down?fileName="+idList[0]
				}
			}
			
		}
		
		//取得所选数据包id
		function getInfoIdList(){
			var recs = JobInfoGrid.getSelectionModel().getSelection();
			var list = [];
			if(recs.length == 0){
				Ext.MessageBox.alert('提示','请选择要进行操作的数据包！');
			}else{
				for(var i = 0 ; i < recs.length ; i++){
					var rec = recs[i];
					list.push(rec.get('jobId'));
				}
			}
			return list;
		}
		function isEnd(){
			var recs = JobInfoGrid.getSelectionModel().getSelection();
			var list = [];
			if(recs.length == 0){
				Ext.MessageBox.alert('提示','请选择要进行操作的数据包！');
			}else{
				for(var i = 0 ; i < recs.length ; i++){
					var rec = recs[i];
					if(!(rec.get('status')=="END")){
						Ext.MessageBox.alert('提示','选择中有未导入数据库的，请重新选择！');
						return false;
					}
					
				}
			}
			return true;
		}
	});