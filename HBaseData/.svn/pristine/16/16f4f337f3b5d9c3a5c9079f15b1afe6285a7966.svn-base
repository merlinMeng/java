<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ctxpath = request.getContextPath();
	String theme = request.getParameter("theme");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书籍类型列表</title>
	<link rel="stylesheet" type="text/css" href="ext-4.0/resources/css/<%=theme %>" />
	<link rel="stylesheet" type="text/css" href="examples/chapter08/pagesExt/css/style.css" />
	<script type="text/javascript" src="ext-4.0/bootstrap.js"></script>
  	<script type="text/javascript" src="ext-4.0/src/core/src/locale/ext-lang-zh_CN.js"></script>
</head>
<script type="text/javascript">
	var ctxpath = '<%=ctxpath%>';
	//切换主题
	function themeChange(theme) {
		Ext.util.CSS.swapStyleSheet('theme', 'ext-4.0/resources/css/'+theme);
	}
	Ext.onReady(function(){
		//创建数据模型
		Ext.regModel('BookType', {
		    fields: [{name: 'id'},{name: 'title'},{name:'detail'}]
		});
		//定义组合框中显示的数据源
		var typeStore = Ext.create('Ext.data.Store',{
			model : 'BookType',
			proxy: {
		        type: 'ajax',
		        url : ctxpath+'/bookext.do?method=getBookTypeList',
		        reader: {
		            type: 'xml',
		            totalRecords: 'results',
		            idProperty : 'id',
		            record: 'BookType'
		        }
		    },
		    autoLoad: true
		});
		//创建工具栏组件
		var toolbar = [
			{text : '新增书籍类型',iconCls:'add',handler : showAddBookType},
			{text : '修改书籍类型',iconCls:'option',handler : showModifyBookType},
			{text : '删除书籍类型',iconCls:'remove',handler : showDeleteBookType}
		];
		//创建Grid表格组件
		var bookTypeGrid = new Ext.grid.Panel({
			tbar : toolbar,
			store: typeStore,
			region: 'center',
			selModel : new Ext.selection.CheckboxModel(),
			columns: [//配置表格列
				{text: "类型编号", width: 80, dataIndex: 'id', sortable: true},
				{text: "类型名称", width: 180, dataIndex: 'title', sortable: true},
				{text: "类型说明", width: 280, dataIndex: 'detail', sortable: true}
			]
		});
		new Ext.container.Viewport({
			layout:'border',//表格布局
			items : bookTypeGrid
		});
		//创建新增或修改书籍类型信息的form表单
		Ext.QuickTips.init();
		var bookTypeForm = new Ext.form.Panel({
			fieldDefaults:{//统一设置表单字段默认属性
				labelSeparator :'：',//分隔符
				labelWidth : 80,//标签宽度
				msgTarget : 'side',
				width : 300
			},
			bodyPadding: 5,
			frame : true,
			items : [{
				xtype:'textfield',
				allowBlank : false,
				blankText : '类型名称不能为空',
				name : 'title',
				fieldLabel:'类型名称'
			},{
				xtype:'textarea',
				name : 'detail',
				height : 80,
				fieldLabel:'类型说明'
			},{
				xtype:'hidden',
				name : 'id'
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
		    height:200,
			resizable : false,
			shadow : true,
			modal :true,
		    closable:true,
			items:bookTypeForm
		});
		//显示新建书籍类型窗口
		function showAddBookType(){
			bookTypeForm.form.reset();
			bookTypeForm.isAdd = true;
			win.setTitle("新增书籍类型信息");
			win.show();
		}
		//显示修改书籍类型窗口
		function showModifyBookType(){
			var bookTypeList = getBookTypeIdList();
			var num = bookTypeList.length;
			if(num > 1){
				Ext.MessageBox.alert("提示","每次只能修改一条书籍信息。");
			}else if(num == 1){
				bookTypeForm.isAdd = false;
				win.setTitle("修改书籍信息");
				win.show();
				var bookTypeId = bookTypeList[0];
				loadForm(bookTypeId);
			}
		}
		//显示删除书籍对话框
		function showDeleteBookType(){
			var bookTypeList = getBookTypeIdList();
			var num = bookTypeList.length;
			if(num > 1){
				Ext.MessageBox.alert("提示","每次只能删除一条书籍信息。");
			}else if(num == 1){
				Ext.MessageBox.confirm("提示","您确定要删除所选书籍类型吗？",function(btnId){
					if(btnId == 'yes'){
						var bookTypeId = bookTypeList[0];
						deleteBookType(bookTypeId);
					}
				});
			}
		}
		//删除书籍类型
		function deleteBookType(bookTypeId){
			var msgTip = Ext.MessageBox.show({
				title:'提示',
				width : 250,
				msg:'正在删除书籍类型信息请稍后......'
			});
			Ext.Ajax.request({
				url : ctxpath+'/bookext.do?method=deleteBookType',
				params : {bookTypeId : bookTypeId},
				method : 'POST',
				success : function(response,options){
					msgTip.hide();
					var result = Ext.JSON.decode(response.responseText);
					if(result.success){
						//服务器端数据成功删除后，同步删除客户端列表中的数据
						var index = typeStore.find('id',bookTypeId);
						if(index != -1){
							var rec = typeStore.getAt(index);
							typeStore.remove(rec);
						}
						Ext.Msg.alert('提示','删除书籍类型信息成功。');
					}else{
						Ext.Msg.alert('提示','该书籍类型已包含'+result.num+'本书籍信息不能删除！');
					}
				},
				failure : function(response,options){
					msgTip.hide();
					Ext.Msg.alert('提示','删除书籍类型请求失败！');
				}
			});
		}
		//加载表单数据
		function loadForm(bookTypeId){
			bookTypeForm.form.load({
				waitMsg : '正在加载数据请稍后',//提示信息
				waitTitle : '提示',//标题
				url : ctxpath+'/bookext.do?method=getBookTypeById',//请求的url地址
				params : {bookTypeId:bookTypeId},
				method:'GET',//请求方式
				failure:function(form,action){//加载失败的处理函数
					Ext.Msg.alert('提示','数据加载失败');
				}
			});
		}
		//提交表单数据
		function submitForm(){
			//判断当前执行的提交操作，isAdd为true表示执行书籍类型新增操作，false表示执行书籍类型修改操作
			if(bookTypeForm.isAdd){
				//新增书籍类型信息
				bookTypeForm.form.submit({
					clientValidation:true,//进行客户端验证
					waitMsg : '正在提交数据请稍后',//提示信息
					waitTitle : '提示',//标题
					url : ctxpath+'/bookext.do?method=addBookType',//请求的url地址
					method:'POST',//请求方式
					success:function(form,action){//加载成功的处理函数
						win.hide();
						updateBookTypeGrid(action.result.bookTypeId);
						Ext.Msg.alert('提示','新增书籍类型成功');
					},
					failure:function(form,action){//加载失败的处理函数
						Ext.Msg.alert('提示','新增书籍类型失败');
					}
				});
			}else{
				//修改书籍类型信息
				bookTypeForm.form.submit({
					clientValidation:true,//进行客户端验证
					waitMsg : '正在提交数据请稍后',//提示信息
					waitTitle : '提示',//标题
					url : ctxpath+'/bookext.do?method=modifyBookType',//请求的url地址
					method:'POST',//请求方式
					success:function(form,action){//加载成功的处理函数
						win.hide();
						updateBookTypeGrid(action.result.bookTypeId);
						Ext.Msg.alert('提示','修改书籍类型成功');
					},
					failure:function(form,action){//加载失败的处理函数
						Ext.Msg.alert('提示','修改书籍类型失败');
					}
				});
			}
		}
		//明细数据修改后，同步更新书籍列表信息
		function updateBookTypeGrid(bookTypeId){
			var values = bookTypeForm.form.getValues();
			var index = typeStore.find('id',values['id']);
			if(index != -1){
				var item = typeStore.getAt(index);
				for(var fieldName in values){
					item.set(fieldName,values[fieldName]);
				}
				item.commit();
			}else{
				var rec = Ext.ModelMgr.create({
					id : bookTypeId,
				 	title : values['title'],
				 	detail : values['detail'] 
				}, 'BookType');
				typeStore.add(rec);
			}
		}
		
		//取得所选书籍
		function getBookTypeIdList(){
			var recs = bookTypeGrid.getSelectionModel().getSelection();
			var list = [];
			if(recs.length == 0){
				Ext.MessageBox.alert('提示','请选择要进行操作的书籍！');
			}else{
				for(var i = 0 ; i < recs.length ; i++){
					var rec = recs[i];
					list.push(rec.get('id'));
				}
			}
			return list;
		}
	});
</script>
<body></body>
</html>