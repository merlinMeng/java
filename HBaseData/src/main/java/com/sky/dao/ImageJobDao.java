package com.sky.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.sky.pojo.ImageJob;

@Repository
public class ImageJobDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private  RowMapper<ImageJob> rowMapper = ParameterizedBeanPropertyRowMapper.newInstance(ImageJob.class);
	
	public List<ImageJob> query() {
		String sql = "select * from ImageJob";
		List<ImageJob> list = jdbcTemplate.query(sql,rowMapper);
		return list;
	}
	
	public ImageJob queryById(String id) {
		String sql = "select * from ImageJob where id=?";
		ImageJob  imageJob= jdbcTemplate.queryForObject(sql, rowMapper,id);
		return imageJob;
	}
	
	public List<ImageJob> queyrForPagination(String start,String limit){
		String sql = "select * from ImageJob limit "+start +" , "+limit;
		
		List<ImageJob> list = jdbcTemplate.query(sql,rowMapper);
		return list;
	}
	
	public int countJobInfo(){
		String sql = "select count(*) from ImageJob ";
		int count = jdbcTemplate.queryForInt(sql);
		return count;
	}
	
	public int queryMaxId() {
		String sql = "select max(id) from ImageJob ";
		int queryMaxId= jdbcTemplate.queryForInt(sql);
		return queryMaxId;
	}
	
	public void addImageJob(ImageJob imageJob){
		 String sql = "insert into ImageJob(examType,year,areaId,status) "
		 		+ " values (?,?,?,?)";
		 jdbcTemplate.update(sql, new Object[]{
				 imageJob.getExamType(),imageJob.getYear(),imageJob.getAreaId(),imageJob.getStatus()
		 });
	}
	
	
	
}
