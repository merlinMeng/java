package com.sky.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.sky.pojo.User;
@Repository
public class UserDao   {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private  RowMapper<User> rowMapper = ParameterizedBeanPropertyRowMapper.newInstance(User.class);
	
	
	public int getMatchCount(String userName, String password) {
		String sqlStr = " SELECT count(*) from ed_user  "
				+ " WHERE UserName =? and Password=? ";
		return jdbcTemplate.queryForInt(sqlStr, new Object[] { userName, password });
	}
	
	public void save(User user) {
		 String sql = "insert into ed_user (UserName,Password,UserGroup,CreateDate) "
		 		+ " values(?,?,?,?)";  
		 jdbcTemplate.update(sql,user.getUserName(),
				 user.getPassWord(),user.getUserGroup(),user.getCreateDate());  
		
	}

	public List<User> query() {
		String sql = "select * from ed_user";
		
		List<User> list = jdbcTemplate.query(sql,rowMapper);
		return list;
	}
	
	
	
	


	

}
