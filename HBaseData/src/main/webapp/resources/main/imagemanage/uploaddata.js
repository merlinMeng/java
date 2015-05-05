Ext.onReady(function(){
	
		Ext.create('Ext.form.Panel', {
        width: 400,
        bodyPadding: 10,
        margin:'50 10 50 80',
        frame: true,
        renderTo: 'upload',
        items: [{
          	//D:\apache-tomcat-6.0.39\webapps\images\gaokao\2012\06
            xtype: 'textfield',
            name: 'datapaDescri',
            fieldLabel: '考试类别',
            labelWidth: 90,
            msgTarget: 'side',
            allowBlank: false,
            anchor: '100%'
          
        },{
            xtype: 'textfield',
            name: 'datapaDescri',
            fieldLabel: '考试年份',
            labelWidth: 90,
            msgTarget: 'side',
            allowBlank: false,
            anchor: '100%'
            
        },{
            xtype: 'textfield',
            name: 'datapaDescri',
            fieldLabel: '地区编号',
            labelWidth: 90,
            msgTarget: 'side',
            allowBlank: false,
            anchor: '100%'
        },{
            xtype: 'textfield',
            name: 'datapaSource',
            fieldLabel: '图片数据包路径',
            labelWidth: 90,
            msgTarget: 'side',
            allowBlank: false,
            anchor: '100%'
          }
        ],
 
        buttons: [{
            text: '上传',
            handler: function() {
                var form = this.up('form').getForm();
                if(form.isValid()){
                    form.submit({
                        url: 'dapama/addList',
                        type:'ajax',
                        waitMsg: '正在保存文件...',
                        success: function(fp, o) {
                          // Ext.Msg.alert('提示信息', '文件成功上传,文件名字为：'+o.result.file);
                          Ext.Msg.show({
                            title:'提示信息',
                            msg:'数据包导入成功',
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

})