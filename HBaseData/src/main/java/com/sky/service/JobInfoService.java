package com.sky.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.dao.JobInfoDao;
import com.sky.pojo.JobInfo;

@Service
public class JobInfoService {
	@Autowired
	private JobInfoDao JobInfoDao;
	
	public List<JobInfo> queryAll() {
		return JobInfoDao.query();
	}
	
	public JobInfo queryById(String id) {
		return JobInfoDao.queryById(id);
	}
	
	public List<JobInfo> queyrForPagination(String start,String limit){
		
		return JobInfoDao.queyrForPagination(start, limit);
	}
	
	public int countJobInfo(){
		return JobInfoDao.countJobInfo();
	}
	
	public void addJobInfo(JobInfo JobInfo){
		JobInfoDao.addPackInfo(JobInfo);
	}
	
	public int queryMaxId(){
		
		return JobInfoDao.queryMaxId();
	}
	
	public int save(int packageId){
		JobInfo job = new JobInfo();
		job.setJobDes("测评数据导出");
		job.setPackageId(packageId);
		job.setJobType("1");
		job.setStatus("REGISTER");
		JobInfoDao.addPackInfo(job);
		return queryMaxId();
	}
	public int save(){
		JobInfo job = new JobInfo();
		job.setJobDes("学生考试成绩导出");
		job.setPackageId(0);
		job.setStatus("REGISTER");
		JobInfoDao.addPackInfo(job);
		return queryMaxId();
	}
	
}
