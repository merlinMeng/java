
Ext.onReady(function(){
		var examType = Ext.create("Ext.data.Store",{
			fields:["abbr","examType"],
			data:[
				{"abbr":"gk","examType":"gaokao"}
			]
		});
		
		var area =Ext.create("Ext.data.Store",{
			fields:["abbr","area"],
			data:[{
				"abbr":"11","area":"通化"
			}]
		});
	
		Ext.create("Ext.form.Panel",{
			width:400,
			bodyPadding:10,
			margin:"50 50 10 90",
			frame:true,
			renderTo:"download",
			items:[{
				xtype:"combo",
				store:examType,
				fieldLabel:'考试类别',
				name:'examType',
				queryMode:'local',
				displayField:'examType',
				valueField:'examType'
			},{
				xtype:"textfield",
				name:'year',
				fieldLabel:'考试年度'
			},{
				xtype:'combo',
				store:area,
				name:'area',
				fieldLabel:'考试省份',
				queryMode:'local',
				displayField:'area',
				valueField:'abbr'
			},{
	            xtype: 'textfield',
	            name: 'filedir',
	            fieldLabel: '导出路径'
	
	         
	         }
			],
			
			buttons: [{
            text: '提交导出任务',
            handler: function() {
                var form = this.up('form').getForm();
                if(form.isValid()){
                    form.submit({
                        url: 'dapama/downList',
                        type:'ajax',
                        waitMsg: '正在导出文件...',
                        success: function(fp, o) {
                      	  Ext.Msg.show({
                            title:'提示信息',
                            msg:'文件导出成功',
                            minWidth:200,
                            modal:true,
                            buttons:Ext.Msg.OK 
                          })
                          form.findField('fileName').setRawValue('');
                        }
                    });
                }
            }
        }]
		});
});