package com.sky.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.sky.pojo.PackageInfo;

@Repository
public class PackageInfoDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private  RowMapper<PackageInfo> rowMapper = ParameterizedBeanPropertyRowMapper.newInstance(PackageInfo.class);
	
	public List<PackageInfo> query() {
		String sql = "select * from packageinfo";
		List<PackageInfo> list = jdbcTemplate.query(sql,rowMapper);
		return list;
	}
	
	public PackageInfo queryById(int id) {
		String sql = "select * from packageinfo where packageId=?";
		PackageInfo  PackageInfo= jdbcTemplate.queryForObject(sql, rowMapper,id);
		return PackageInfo;
	}
	
	public List<PackageInfo> queyrForPagination(String start,String limit){
		String sql = "select * from packageinfo limit "+start +" , "+limit;
		
		List<PackageInfo> list = jdbcTemplate.query(sql,rowMapper);
		return list;
	}
	
	public int countPackageInfo(){
		String sql = "select count(*) from packageinfo ";
		int count = jdbcTemplate.queryForInt(sql);
		return count;
	}
	
	public int queryMaxId() {
		String sql = "select max(packageid) from packageinfo ";
		int queryMaxId= jdbcTemplate.queryForInt(sql);
		return queryMaxId;
	}
	
	public void addPackInfo(PackageInfo packageInfo){
		 String sql = "insert into packageinfo(examName,examTypeID,areaId,areaName,examYear,examDate,courseNum,rootDir,courseStr,reg_Date,state,imageUploadStatus) "
		 		+ " values (?,?,?,?,?,?,?,?,?,?,?,?)";
		 jdbcTemplate.update(sql, new Object[]{
				 packageInfo.getExamName(),packageInfo.getExamTypeID(),
				 packageInfo.getAreaId(),packageInfo.getAreaName(),
				 packageInfo.getExamYear(),packageInfo.getExamDate(),
				 packageInfo.getCourseNum(),packageInfo.getRootDir(),
				 packageInfo.getCourseStr(),packageInfo.getReg_Date(),
				 packageInfo.getState(),packageInfo.getImageUploadStatus()
		 });
	}
	
	public void delPackInfo(int packageId){
		 String sql = "delete from `packageinfo`  where PackageId=?";
		 jdbcTemplate.update(sql, packageId);
	}
	/**
	 * 图片上传查询 条件查询
	 */
	public List<Map<String,Object>>  queryIdForUploadImage(){
		String sql = "SELECT distinct p1.`PackageId` "
				+ "FROM `packageinfo` p1,`packagecurseinfo` p2 "
				+ "WHERE p1.`PackageId`=p2.`PackageId` AND p1.`imageuploadstatus`='0' AND p2.`ScanImgDir`!=''";
		List<Map<String,Object>> list =  jdbcTemplate.queryForList(sql);
		return list;
	}
	/**
	 * 图片上传查询 条件查询
	 */
	public List<Map<String,Object>> queryForUploadImage(int packageId){
		String sql = "SELECT p1.`ExamTypeID`,p1.`ExamYear`,p1.`AreaId`,p1.`RootDir`,"
				+ "p2.`CourseId`,p2.`ScanImgDir` "
				+ "FROM `packageinfo` p1,`packagecurseinfo` p2 "
				+ "WHERE p1.`PackageId`=p2.`PackageId` AND p1.`imageuploadstatus`='0' AND p1.PackageId=?";
		List<Map<String,Object>> list =  jdbcTemplate.queryForList(sql,new Object[]{packageId});
		return list;
	}
	
	
	
}
