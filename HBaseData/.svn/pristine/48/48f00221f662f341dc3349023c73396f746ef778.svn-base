package com.sky.web.util;

import java.io.File;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.filechooser.FileSystemView;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sky.pojo.FileInfoBak;
import com.sky.util.imageUpload.ExtjsFileUtilsBak;

@Controller
@RequestMapping("/filebrower")
public class FileBrowser {
	private static final long serialVersionUID = 1599390137455995515L;  
	@RequestMapping("/getdir")
	@ResponseBody
    public Object getDir(HttpServletRequest request, HttpServletResponse response,String method) throws Exception  {  
        response.setContentType("text/html");  
        response.setCharacterEncoding("UTF-8");  
        
          
        String path = request.getParameter("path");  
        path = path == null ? "" : URLDecoder.decode(path, "UTF-8");  
       
        FileInfoBak info = new FileInfoBak();  
        if ("getData".equals(method)) {  
            if ("root".equals(path)) {            
                FileSystemView fsv = FileSystemView.getFileSystemView();  
                File[] roots = fsv.getRoots(); //File.listRoots();  
                //桌面  
                for (File f : roots) {  
                    info.getChildren().add(ExtjsFileUtilsBak.getFileInfo(f));  
                }  
                for (File f : roots[0].listFiles()) {  
                    if (f.getName().contains("My Documents")) {  
                        info.getChildren().add(ExtjsFileUtilsBak.getFileInfo(f));  
                    }  
                }  
                FileInfoBak fileInfo = new FileInfoBak();  
                fileInfo.setName("我的电脑");  
                fileInfo.setPath("My Computer");  
                for (File fi : roots[0].listFiles()[0].listFiles()) {  
                    fileInfo.getChildren().add(ExtjsFileUtilsBak.getFileInfo(fi));  
                }  
                info.getChildren().add(fileInfo);  
                fileInfo = new FileInfoBak();  
                fileInfo.setName("网上邻居");  
                fileInfo.setPath("Network Place");  
                for (File fi : roots[0].listFiles()[1].listFiles()) {  
                    fileInfo.getChildren().add(ExtjsFileUtilsBak.getFileInfo(fi));  
                }  
                info.getChildren().add(fileInfo);  
                  
               return info.getChildren();
            } else if (path != null && !"".equals(path)) {  
                ExtjsFileUtilsBak.getFileInfo(info, new File(path), new String[] {"*"});  
               return info.getChildren();  
            }   
        }  
        if ("mkDir".equals(method)) {  
            String dirName = request.getParameter("dirName");  
            dirName = dirName == null ? "" : URLDecoder.decode(dirName, "UTF-8");  
            boolean success = false;  
            try {  
                success = ExtjsFileUtilsBak.mkDir(path, dirName);  
                FileInfoBak node = ExtjsFileUtilsBak.getFileInfo(new File(ExtjsFileUtilsBak.getDoPath(path) + dirName));  
               	return node;
            } catch (Exception e) {  
                e.printStackTrace();  
                success = false;  
            }  
            System.out.println(success);  
        }  
       return "";
    }  
  
    
}
