package com.sky.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.sky.pojo.JobInfo;

@Repository
public class JobInfoDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private  RowMapper<JobInfo> rowMapper = ParameterizedBeanPropertyRowMapper.newInstance(JobInfo.class);
	
	public List<JobInfo> query() {
		String sql = "select * from jobinfo";
		List<JobInfo> list = jdbcTemplate.query(sql,rowMapper);
		return list;
	}
	
	public JobInfo queryById(String id) {
		String sql = "select * from jobinfo where jobId=?";
		JobInfo  jobInfo= jdbcTemplate.queryForObject(sql, rowMapper,id);
		return jobInfo;
	}
	
	public List<JobInfo> queyrForPagination(String start,String limit){
		String sql = "select * from jobinfo limit "+start +" , "+limit;
		
		List<JobInfo> list = jdbcTemplate.query(sql,rowMapper);
		return list;
	}
	
	public int countJobInfo(){
		String sql = "select count(*) from jobinfo ";
		int count = jdbcTemplate.queryForInt(sql);
		return count;
	}
	
	public int queryMaxId() {
		String sql = "select max(jobid) from jobinfo ";
		int queryMaxId= jdbcTemplate.queryForInt(sql);
		return queryMaxId;
	}
	
	public void addPackInfo(JobInfo Jobinfo){
		 String sql = "insert into jobinfo(jobdes,packageId,jobType,status) "
		 		+ " values (?,?,?,?)";
		 jdbcTemplate.update(sql, new Object[]{
				 Jobinfo.getJobDes(),Jobinfo.getPackageId(),
				 Jobinfo.getJobType(),Jobinfo.getStatus()
		 });
	}
	
	
	
}
