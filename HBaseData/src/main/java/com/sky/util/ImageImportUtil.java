package com.sky.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.MapFile;
import org.apache.hadoop.io.Text;
import org.apache.log4j.Logger;

public class ImageImportUtil implements Runnable {
	
	private String sourceURL;
	private String dstURL;
	private Configuration conf;
	private FileSystem fs;
	private Path path  =  null;
	
	private static final Logger LOG = Logger.getLogger(ImageImportUtil.class);
	public ImageImportUtil(Configuration conf,FileSystem fs, String sourceURL,String dstURL){
		this.conf=conf;
		this.fs=fs;
		this.sourceURL=sourceURL;
		this.dstURL=dstURL;
	}
	public void run() {
		try {
			write();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		    	path = new Path(dstURL);
		    	FileInputStream fis = null;
		        BufferedInputStream buff = null;	
	  	         if(!fs.exists(path)){
				        if(fs.mkdirs(path)){
		    	            writer = new MapFile.Writer(conf,fs,path.toString(),key.getClass(),value.getClass());							 
					    	for(int i = 0; i<lst.size(); i++){	
					    		detailPath = lst.get(i).toString();
				    		   String hdfsDstURL = dstURL + detailPath.substring(detailPath.lastIndexOf(sourceURL)+sourceURL.length(),detailPath.length()).replace("\\", "/");
							   try{
					    		   fis = new FileInputStream(detailPath);
					    		   key.set(hdfsDstURL);
					    		   buff = new BufferedInputStream(fis);
					    		   if(buff.read(b)!= -1){
					    		      value.set(b, 0, b.length);
					    		      writer.append(key, value);						    			   
					    		      }
						    	   }catch(IOException e){
							    	    fis.close();
						                buff.close();
						    	   }
							      fis.close();
							      buff.close();
							    					      
							     }
					    	   }
						    }else{
			    	            writer = new MapFile.Writer(conf,fs,path.toString(),key.getClass(),value.getClass());							 
						    	for(int i = 0; i<lst.size(); i++){	
						    		detailPath = lst.get(i).toString();
						    		String hdfsDstURL = dstURL + detailPath.substring(detailPath.lastIndexOf(sourceURL)+sourceURL.length(),detailPath.length()).replace("\\", "/");
									try{
					    		       fis = new FileInputStream(detailPath);
					    		       key.set(hdfsDstURL);
					    		       buff = new BufferedInputStream(fis);					    			   
					    		       if(buff.read(b)!= -1){
					    			      value.set(b, 0, b.length);
					    			      writer.append(key, value);						    			   
					    		       }				    	   
								     }catch(IOException ex){
						    	       fis.close();
					                   buff.close();
								     } 
								      fis.close();
								      buff.close();	
						        }
					         }			
	          }else{
					LOG.info(sourceURL + ":     配置的目录下，没有对应的任何文件，请确认！");	
			}
	}
	

}
