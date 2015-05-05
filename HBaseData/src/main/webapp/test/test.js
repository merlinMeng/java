Ext.onReady(function(){
	
	var progressbar = Ext.create('Ext.ProgressBar',{
		text:'进度条定位 用renderTo',
		width:300,
		renderTo:'progressBar1'
	});
	
//	var count =0;
//	var percentage =0;
//	var progressText ='';
//	
//	Ext.TaskManager.start({
//		run:function(){
//			count++;
//			if(count>10){
//				progressbar.hide();
//			}
//			
//			percentage = count/10;
//			progressText = percentage*100+'%';
//			progressbar.updateProgress(percentage,progessText,true);
//			
//		},
//		interval:1000,
//		repeat:6
//	});
//	progressbar.wait({
//		duration:1000,
//		interval:100,
//		increment:9,
//		text:'waitin...',
//		animate:true,
//		scop:this,
//		fn:function(){
//			alert('update success');
//		}
//		
//	})
	
	
	
	
});