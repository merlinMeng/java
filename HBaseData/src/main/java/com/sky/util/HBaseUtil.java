package com.sky.util;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HConnection;
import org.apache.hadoop.hbase.client.HConnectionManager;

public class HBaseUtil {
	
	private static Configuration conf = null;   
	//private static HTablePool pool = null;  
	private static HConnection HCONNECTION = null;
	static{
		 conf = HBaseConfiguration.create();   
		// pool = new HTablePool(conf, Integer.MAX_VALUE);
		 try {
			 HCONNECTION = HConnectionManager.createConnection(conf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	
	public static HConnection gethConnection(){
		return HCONNECTION;
	}

}
