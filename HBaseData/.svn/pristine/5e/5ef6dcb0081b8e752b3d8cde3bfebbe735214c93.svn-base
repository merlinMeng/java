package com.sky.util;

import java.io.File;
import java.util.List;

public class FileUtil {
	
	
	public static void getFileList(String path, List fileLst){
		
		if(path!=null && !"".equals(path)){
			try {
				File file = new File(path);
				if(file.exists()){
					File[] filesList = file.listFiles();
					for(int i=0;i<filesList.length;i++){
						if(filesList[i].isDirectory()){
							getFileList(filesList[i].toString(),fileLst);
						}else if(filesList[i].isFile()){
							fileLst.add(filesList[i]);
						}
					}
			    }
				
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}

}
