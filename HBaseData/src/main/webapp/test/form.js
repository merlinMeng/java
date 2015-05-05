Ext.onReady(function(){
	Ext.QuickTips.init();
	
	var loginForm = new Ext.form.Panel({
		title:'表单',
		height:1200,
		width:2200,
		frame:true,
//		layout:'fit',
		bodyStyle:'padding:5 5 5 5',
		
		renderTo:'form',
		//defaultType:'textfield',
		defaults:{
			labelSeparator:':',
			labelWidth:105,
			width:150,
			//allowBlank:false,
			//blankText:'不允许为空',
			labelAlign:'left'
			//msgTarget:'side'
		},
		items:[{
			xtype:'textfield',
			//fieldLabel:'姓名',minLength:6,minLengthText:'最小长度为6',maxLength:8,maxLengthText:'最大长度为8'
			
			fieldLabel:'用户名',
			name:'username',
			selectOnFocus:true,
			regex:/^([\w]+)(.[\w]+)*@([\w-]+\.){1,5}([A-Za-z]){2,4}$/,
			regexText:'格式错误'
		},{
			xtype:'numberfield',
			//fieldLabel:'年龄'
			name:'password',
			fieldLabel:'密码',
			allowBlank:false,
			inputType:'password'
		},{
			xtype:'radiogroup',
			fieldLabel:'性别',
			columns:2,
			items:[
				{boxLabel:'男',name:'sex',inputValue:'male'},
				{boxLabel:'女',name:'sex',inputValue:'female'}]
		},{
			xtype:'checkboxgroup',
			fieldLabel:'爱好',
			allowBlank:false,
			columns:3,
			items:[
			{boxLabel:'游泳',name:'swim'},
			{boxLabel:'散步',name:'walk'},
			{boxLabel:'阅读',name:'read'},
			{boxLabel:'游戏',name:'game'},
			{boxLabel:'电影',name:'movie'}
			
			]
		},{
			xtype:'triggerfield',
			id:'memo',
			fieldLabel:'触发字段',
			width:100,
			labelWidth:400,
			hideTrigger:false,
			items:[
				{boxLabel:'游泳',name:'swim'},
				{boxLabel:'散步',name:'walk'},
				{boxLabel:'阅读',name:'read'},
				{boxLabel:'游戏',name:'game'},
				{boxLabel:'电影',name:'movie'}
			],
			onTriggerClick:function(){
				var memo =loginForm.getForm().findField('memo');
				alert(memo.getValue());
				Ext.getCmp('memo').setValue('test');
			}
		}
		],
		buttons:[
			{	text:'登陆',
				handler:function(){
					loginForm.form.setValues({userName:'user@com',password:'123456'});
				}
			}
		]
		
	});
	
});