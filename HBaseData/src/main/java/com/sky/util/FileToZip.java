package com.sky.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
    
public class FileToZip {     
     
	private static byte[] buf = new byte[1024*10];  
    /**   
     *    
     * @param inputFileName 输入一个文件夹   
     * @param zipFileName   输出一个压缩文件夹，打包后文件名字   
     * @throws Exception   
     */    
    public  void zip(String inputFileName, String zipFileName) throws Exception {     
        System.out.println(zipFileName);     
        zip(zipFileName, new File(inputFileName));     
    }     
    private void zip(String zipFileName, File inputFile) throws Exception {     
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(     
                zipFileName));     
        zip(out, inputFile, "");     
        System.out.println("zip done");     
        out.close();     
    }     
    private void zip(ZipOutputStream out, File f, String base) throws Exception {     
        if (f.isDirectory()) {  //判断是否为目录     
            File[] fl = f.listFiles();     
            out.putNextEntry(new ZipEntry(base + "/"));     
            base = base.length() == 0 ? "" : base + "/";     
            for (int i = 0; i < fl.length; i++) {     
                zip(out, fl[i], base + fl[i].getName());     
            }     
        } else {                //压缩目录中的所有文件     
        	out.putNextEntry(new ZipEntry(base));     
            FileInputStream in = new FileInputStream(f);     
            int b;     
            System.out.println(base);     
            while ((b = in.read(buf)) != -1) { 
            	out.write(buf, 0, b);
            }     
            in.close();     
        }     
    }    
    
   
  
}    