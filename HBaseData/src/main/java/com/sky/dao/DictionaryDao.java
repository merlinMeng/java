package com.sky.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.sky.pojo.Dictionary;

@Repository
public class DictionaryDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private  RowMapper<Dictionary> rowMapper = ParameterizedBeanPropertyRowMapper.newInstance(Dictionary.class);
	
	public Dictionary queryById(String id) {
		String sql = "select * from Dictionary where Id=?";
		Dictionary  dictionary= jdbcTemplate.queryForObject(sql, rowMapper,id);
		return dictionary;
	}
	
	public List<Dictionary> queyrForPagination(String start,String limit){
		String sql = "select * from Dictionary limit "+start +" , "+limit;
		List<Dictionary> list = jdbcTemplate.query(sql,rowMapper);
		return list;
	}
	
	public int countDictionary(){
		String sql = "select count(*) from Dictionary ";
		int count = jdbcTemplate.queryForInt(sql);
		return count;
	}
	
	public int queryMaxId() {
		String sql = "select max(id) from Dictionary ";
		int queryMaxId= jdbcTemplate.queryForInt(sql);
		return queryMaxId;
	}
	
	public void addDictionary(Dictionary dictionary){
		 String sql = "insert into Dictionary(id,examTypeID,areaId,areaName,examYear) "
		 		+ " values (?,?,?,?,?)";
		 jdbcTemplate.update(sql, new Object[]{
				 dictionary.getId(),
				 dictionary.getExamTypeID(),
				 dictionary.getAreaId(),
				 dictionary.getAreaName(),
				 dictionary.getExamYear()
		 });
	}
	
	public void updateDictionary(Dictionary dictionary){
		String sql = "update Dictionary set examTypeID=?,areaId=?,areaName=?,examYear=? where id=?";
		jdbcTemplate.update(sql,new Object[]{
				 dictionary.getExamTypeID(),
				 dictionary.getAreaId(),
				 dictionary.getAreaName(),
				 dictionary.getExamYear(),
				 dictionary.getId()
		});
	}
	
	public void delDictionary(String id){
		String sql = "delete from dictionary where id=?";
		jdbcTemplate.update(sql, id);
	}
	
	
}
