Ext.onReady(function () {  
        var loginForm = Ext.create("Ext.form.Panel", {  
           // title: '用户登陆',  
            frame: true,  
           	height:180,
          	width: 210,
            renderTo:'dc',
          	bodyStyle:'padding:5px 5px 0',  
            bodyPadding: 10,  
            // absolute, accordion, anchor, border, card, column, fit, form and table. 
            defaultType: 'textfield',  
            defaults: {  
                anchor: '100%',  
                labelWidth: 50,  
                labelAlign: "right"  ,
                msgTarget: 'under'  
            },  
            items: [  
                {  
	                xtype:'textfield',
					fieldLabel:'用户名 ',
					name:'userName',
					width:150,
					
					allowBlank:false,
					blankText:'用户名不能为空',
					minLength:3,
					minLengthText:'用户名的长度为[3-20]',
					maxLength:20,
					maxLengthText:'用户名的长度为[3-20]'
                },  
                {  
	                xtype: 'textfield',   
					inputType:'password', 
					fieldLabel:'密 &nbsp; &nbsp;码',
					name:'password',
					width:150,
					
					allowBlank:false,
					blankText:'密码不能为空',
					minLength:3,
					minLengthText:'密码的长度为[3-20]',
					maxLength:20,
					maxLengthText:'密码的长度为[3-20]'
                }
                //,  
//                {  
//                    xtype: 'checkbox',  
//                    fieldLabel: '记住我',  
//                    name: 'remember'  
//                }  
            ],  
            buttons: [  
             //   { text: '注册' },  
                { 	text: '登陆' ,
                	handler:function(){
                		var form = this.up("form").getForm();
                		if(form.isValid()){
                			 Ext.get("dc").dom.submit();   
                		}
                	}
                
                }  
            ]
           
        });  
	
	
});  
