package com.sky.dao;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.sky.pojo.DataPackage;

@Repository
public class DataPackageDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private  RowMapper<DataPackage> rowMapper = ParameterizedBeanPropertyRowMapper.newInstance(DataPackage.class);
	
	public List<DataPackage> query() {
		String sql = "select * from packagecurseinfo";
		List<DataPackage> list = jdbcTemplate.query(sql,rowMapper);
		return list;
	}
	
	public DataPackage queryById(int id) {
		String sql = "select * from packagecurseinfo where packageId=?";
		DataPackage  dataPackage= jdbcTemplate.queryForObject(sql, rowMapper,id);
		return dataPackage;
	}
	
	public List<DataPackage> queryByPackageId(int id) {
		String sql = "select * from packagecurseinfo where packageId=?";
		List<DataPackage>  list= jdbcTemplate.query(sql, rowMapper, new Object[]{
				id
		});
		return list;
	}	
	
	public void updateById(DataPackage dataPackage) {  
        String sql = "update packagecurseinfo set ScanFileName=?,scanImgDir=? where PackageId=?";  
        jdbcTemplate.update(sql, dataPackage.getScanFileName(),dataPackage.getScanImgDir(), dataPackage.getPackageId());  
    }  
	public void deleteById(int PackageId) {  
        String sql = "delete from packagecurseinfo  where PackageId=?";  
        jdbcTemplate.update(sql, PackageId);
    }
	
	public int queyrForCount(){
		String sql = "select count(*) from packagecurseinfo";
		int count = jdbcTemplate.queryForInt(sql);
		return count;
	}
	
	
	public List<DataPackage> queyrForPagination(String start,String limit){
		String sql = "select * from packagecurseinfo limit "+start +" , "+limit;
		System.out.println(sql);
		List<DataPackage> list = jdbcTemplate.query(sql,rowMapper);
		return list;
	}
	
	public void addDataPackage(DataPackage dataPackage)  {  
        String sql = "insert into packagecurseinfo (packageId,examName,courseId,courseName,BMKFileName,BMKMode,scanFileName,"
        		+ "scanMode,PjFileName,PjMode,CjFileName,CjMode,scanImgDir,writeItemId,cardNum,fullScore,KgMaxScore,ZHgMaxScore)"
        		+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";  
        
        jdbcTemplate.update(sql, new Object[]{
        		dataPackage.getPackageId(),dataPackage.getExamName(),
        		dataPackage.getCourseId(),dataPackage.getCourseName(),
        		dataPackage.getBMKFileName(),dataPackage.getBMKMode(),
        		dataPackage.getScanFileName(),dataPackage.getScanMode(),
        		dataPackage.getPjFileName(),dataPackage.getPjMode(),
        		dataPackage.getCjFileName(),dataPackage.getCjMode(),
        		dataPackage.getScanImgDir(),dataPackage.getWriteItemId(),
        		dataPackage.getCardNum(),dataPackage.getFullScore(),
        		dataPackage.getKgMaxScore(),dataPackage.getZHgMaxScore()
        }); 
        
    }  
	
	
	
	

}
