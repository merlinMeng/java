Ext.onReady(function(){
	 alert("dddd");
	 var testPanel = new Ext.panel.Panel({
	 	title:'header',
	 	tbar:['top toolbars'],
	 	bbar:['bottom toolbars'],
	 	height:200,
	 	width:300,
	 	frame:true,
	 	renderTo:Ext.getBody(),
	 	//bodyPadding:5,
	 	//bodyStyle:'background-color:#FFFFFF',
	 	html:'body',
	 	tools:[
	 	{id:'toggle'},
	 	{id:'close'},
	 	{id:'maximize'}
	 	],
	 	buttons:[{
	 		text:'footer'
	 	}]
	 	
	 	
	 });
	
});