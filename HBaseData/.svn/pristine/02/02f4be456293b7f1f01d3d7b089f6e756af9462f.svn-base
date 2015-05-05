package com.sky.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.MapFile;
import org.apache.hadoop.io.Text;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class HandleSmallFiles {
	/**
	 * 根据key获取数据
	 * @param params
	 * @param conf
	 * @param fs
	 */
	public String mapFileReader(String examType, String year,String areaId,
			String imageUrl,String absolutePath){	 
		
		   String key_value = "/" + examType +"/" +year +"/"+ areaId+ "/scanlib/" + imageUrl ;
		   if(new File(absolutePath+key_value).isFile()){
			   return key_value;
		   }
		   //配置链接hdfs的信息
		   Configuration conf = new Configuration();
		   //conf.addResource(new Path("conf/hdfs-site.xml"));
		   //conf.addResource(new Path("conf/core-site.xml"));
		   conf.addResource(new Path("hdfs-site.xml"));
		   conf.addResource(new Path("core-site.xml"));
		   //初始化key value reader
		   Text key=new Text();
    	   BytesWritable value = new BytesWritable();
		   MapFile.Reader reader=null;
		   
		   String url_value = "/" + examType +"/" +year +"/"+ areaId +"/scanlib/"+imageUrl.split("/")[0] ;
		   //String dst = "D:\\hytyun\\apache-tomcat-7.0.47-windows-x86\\apache-tomcat-7.0.47\\webapps\\images";
		   
		   ///gaokao/2012/06/scanlib/lishu
		   String dst = absolutePath + key_value;
		    	   
		   try{
			key.set(key_value);
			FileSystem fs = (DistributedFileSystem)FileSystem.get(conf);
		    reader=new MapFile.Reader(fs,url_value,conf);
		    File file = null;
		    BufferedOutputStream boutput =null;
		    FileOutputStream out= null;
		    if(reader.seek(key)){
		    	 reader.get(key, value);
				 file  = new File(dst);
			     File parent = file.getParentFile();
			     if(!parent.exists()){
			    	 parent.mkdirs();
			     }
			     
			     file.createNewFile();
			     out = new FileOutputStream(dst);
			     boutput = new BufferedOutputStream(out);
			     out.write(value.getBytes());
			     out.flush();
		         out.close();
		         boutput.close();	    	
		    }else{
				System.out.println(key + ":     没有需要查找的图片!");			    	
		    }
		    fs.close();
		   }catch(Exception e){
			   e.printStackTrace();
		   }finally{
			   IOUtils.closeStream(reader);
		   }
		   return key_value;
	}
}
