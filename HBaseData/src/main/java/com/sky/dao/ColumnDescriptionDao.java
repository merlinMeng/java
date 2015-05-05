package com.sky.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.sky.pojo.ColumnDescription;


@Repository
public class ColumnDescriptionDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private  RowMapper<ColumnDescription> rowMapper = ParameterizedBeanPropertyRowMapper.newInstance(ColumnDescription.class);
	
	public List<ColumnDescription> query() {
		String sql = "select * from user_tbl_cols";
		List<ColumnDescription> list = jdbcTemplate.query(sql,rowMapper);
		return list;
	}
	
	public List<ColumnDescription> queryById(String tableName) {
		String sql = "select * from user_tbl_cols where table_name=?";
		return jdbcTemplate.query(sql, rowMapper,tableName);
	}
	
	
}
