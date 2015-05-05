package com.sky.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.sky.pojo.TableDescription;


@Repository
public class TableDescriptionDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private  RowMapper<TableDescription> rowMapper = ParameterizedBeanPropertyRowMapper.newInstance(TableDescription.class);
	
	public List<TableDescription> query() {
		String sql = "select * from user_tables";
		List<TableDescription> list = jdbcTemplate.query(sql,rowMapper);
		return list;
	}
	
	public TableDescription queryById(String tableName) {
		String sql = "select * from user_tables where table_name=?";
		TableDescription  tableDescription= jdbcTemplate.queryForObject(sql, rowMapper,tableName);
		return tableDescription;
	}
	
	
}
