package com.sky.util.imageUpload;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.MapFile;
import org.apache.hadoop.io.Text;

import com.sky.util.FileUtil;

public class UploadByCourse implements Callable<String> {
	
	private String sourceURL;
	private String prefixPath;
	private Configuration conf;
	private FileSystem fs;
	public UploadByCourse(Configuration conf,FileSystem fs,String sourceURL,String prefixPath){
		this.conf=conf;
		this.fs = fs;
		this.sourceURL=sourceURL;
		this.prefixPath=prefixPath;
	} 
	
	
	
	
	public void write() throws Exception {
		
			List lst = new ArrayList();
			FileUtil.getFileList(sourceURL, lst);
			//往hdfs里写
			MapFile.Writer writer = null;
			
	        Text key=new Text();
	    	byte[]b = new byte[1*1024*1024];
	    	BytesWritable value = new BytesWritable();
	    	
	    	
	    	if(lst!=null && !"".equals(lst)&& lst.size()>0){
		    	String detailPath= "";
		    	Path prefixhdfsPath = new Path(prefixPath);
		    	FileInputStream fis = null;
		        BufferedInputStream buff = null;
		        
		         try{
		        	if(!fs.exists(prefixhdfsPath)){
					        if(fs.mkdirs(prefixhdfsPath)){
			    	            writer = new MapFile.Writer(conf,fs,prefixPath,key.getClass(),value.getClass());							 
						    	for(int i = 0; i<lst.size(); i++){	
						    	   detailPath = lst.get(i).toString();
					    		   String hdfsDstURL = prefixPath + detailPath.substring(detailPath.lastIndexOf(sourceURL)+sourceURL.length(),detailPath.length()).replace("\\", "/");;
					    		   fis = new FileInputStream(detailPath);
					    		   key.set(hdfsDstURL);
					    		   buff = new BufferedInputStream(fis);
					    		   if(buff.read(b)!= -1){
					    		      value.set(b, 0, b.length);
					    		      writer.append(key, value);						    			   
					    		      }
						    		   
							    }
						    }
					}
		        	System.out.println(sourceURL+"-----------线程successfull");	
		    	}catch(IOException e){
		    		System.out.println(sourceURL+"-----------线程错误");
		    	    e.printStackTrace();
	    	   }finally{
	    		    if(fis!=null){
	    		    	fis.close();
		                buff.close();
	    		    }
	               
	    	   }
	      }else{
				System.out.println(sourceURL + ":     配置的目录下，没有对应的任何文件，请确认！");	
		  }
	     
	}




	public String call() throws Exception {
		write();
		return prefixPath+"-------end";
	}
	
	
	


	
}
