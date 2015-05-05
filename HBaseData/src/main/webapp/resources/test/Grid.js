Ext.onReady(function(){

	

	var bookStore = Ext.create('Ext.data.Store',{
		autoLoad :true,
		model:'Subject',
		proxy:{
			type:'memory',
			data:datas,
			reader:'array'
			
		}
	});
	var  datas=[
			['ls','理数','150','24','126'],
			['ws','文数','150','24','126']
			];
	var toolbar = [
		{
			text:'新增',
			iconCls:'add'
		},{
			text:'修改',
			iconCls:'modify'
			}
	];
	
	var bookGrid = new Ext.grid.Panel({
		tbar:toolbar,
		renderTo:Ext.getBody(),
		store:{
			autoLoad :true,
			fields:['id','name','fullScore','objScore','subScore'],
			proxy:{
			type:'memory',
			data:datas,
			reader:'array'
			}
			
		},
		columns:[
		{	text:'科目编号',width:80,dataIndex:'id',sortable:true },
		{	text:'科目名称',width:80,dataIndex:'id',sortable:true },
		{	text:'科目满分',width:80,dataIndex:'id',sortable:true },
		{	text:'客观题分数',width:80,dataIndex:'id',sortable:true },
		{	text:'主观题分数',width:80,dataIndex:'id',sortable:true }
		]
		
	});
	
});