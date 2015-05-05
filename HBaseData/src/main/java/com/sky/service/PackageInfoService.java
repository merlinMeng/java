package com.sky.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.sky.dao.DataPackageDao;
import com.sky.dao.PackageInfoDao;
import com.sky.pojo.PackageInfo;
import com.sky.util.imageUpload.UploadByCourse;

@Service
public class PackageInfoService {
	@Autowired
	private PackageInfoDao dao;
	@Autowired
	private DataPackageDao coursedao;
	
	public List<PackageInfo> queryAll() {
		return dao.query();
	}
	
	public PackageInfo queryById(int id) {
		return dao.queryById(id);
	}
	
	public List<PackageInfo> queyrForPagination(String start,String limit){
		
		return dao.queyrForPagination(start, limit);
	}
	
	public int countPackageInfo(){
		return dao.countPackageInfo();
	}
	
	public void addPackageInfo(PackageInfo packageInfo){
		dao.addPackInfo(packageInfo);
	}
	
	public int queryMaxId(){
		return dao.queryMaxId();
	}
	
	public List<Map<String,Object>> queryIdForUploadImage(){
		return dao.queryIdForUploadImage();
	}
	
	public void delPackageId(int packageId){
		dao.delPackInfo(packageId);
		coursedao.deleteById(packageId);
	}
	public Map queryForUploadImage(int packageId){
		List<Map<String,Object>> list =dao.queryForUploadImage(packageId);
		
		List imagePathList = new ArrayList();
		Map mapRecourse = new  HashMap();
	
		if(list.size()>0){
			Map<String,Object> mapTemp = list.get(0);
			String prefixPath = new StringBuilder().append("/")
					.append(mapTemp.get("ExamTypeID")).append("/")
					.append(mapTemp.get("ExamYear")).append("/")
					.append(mapTemp.get("AreaId")).toString();
			mapRecourse.put("prefixPath", prefixPath);
			mapRecourse.put("parentPath", mapTemp.get("RootDir"));
		}
		for(Map<String,Object> map :list){
			imagePathList.add(map.get("ScanImgDir").toString());
		}
		mapRecourse.put("imagePathList", imagePathList);
		return mapRecourse;
	}
	
	public void uploadImage() {
		List<Map<String,Object>> list = queryIdForUploadImage();
		
		Configuration conf = new Configuration();
		conf.addResource(new Path("hdfs-site.xml"));
		conf.addResource(new Path("core-site.xml"));
		FileSystem fs = null;
		try {
			fs = (DistributedFileSystem)FileSystem.get(conf);
			for(Map<String,Object> map :list){
				 Map p = queryForUploadImage((Integer)map.get("PackageId"));
				 String prefixPath = p.get("prefixPath").toString();
				 String parentPath = p.get("parentPath").toString();
				 
				 //配置链接hdfs的信息
				 List imagePathList = (List) p.get("imagePathList");
				 ExecutorService ex = Executors.newFixedThreadPool(10);
				 List<Callable<String>> tasks = new ArrayList<Callable<String>>();
				 for(Object imagePath : imagePathList){
					 String sourcePath =  parentPath+imagePath.toString();
					 String hdfsPathKey = prefixPath+imagePath.toString().toLowerCase().replace("tif", "scanlib").replace("\\", "/");
					 UploadByCourse task = new UploadByCourse(conf,fs,sourcePath,hdfsPathKey);
//					 Thread th = new Thread(uc);
//					 th.setName(hdfsPathKey);
//					 th.start();
					 tasks.add(task);
					 //uc.write();
				}
				ex.invokeAll(tasks); 
				
			}
		}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
		}finally{
			try {
				fs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
}
