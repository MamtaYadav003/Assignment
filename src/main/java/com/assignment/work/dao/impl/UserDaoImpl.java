package com.assignment.work.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import com.assignment.work.dao.UserDao;
import com.assignment.work.model.Users;

@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao{
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	@Override
	public void insertUser(Users usr) {
		String sql = "INSERT INTO users " +
				"(Id, username, password, enabled) VALUES (?, ?, ?, ?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				usr.getId(), usr.getUsername(), usr.getPassword(), usr.isEnabled()
		});
	}
	
	@Override
	public void insertUsers(final List<Users> user) {
		String sql = "INSERT INTO users " + "(Id, username, password, enabled) VALUES (?, ?, ?, ?)";
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Users usr = user.get(i);
				ps.setString(1, usr.getId());
				ps.setString(2, usr.getUsername());
				ps.setString(3, usr.getPassword());
				ps.setBoolean(4, usr.isEnabled());
			}
			
			public int getBatchSize() {
				return user.size();
			}
		});

	}
	@Override
	public List<Users> getAllUser(){
		String sql = "SELECT * FROM users";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Users> result = new ArrayList<Users>();
		for(Map<String, Object> row:rows){
			Users usr = new Users();
			usr.setId((String)row.get("Id"));
			usr.setPassword((String)row.get("password"));
			usr.setUsername((String)row.get("username"));
			usr.setEnabled((boolean)row.get("enabled"));
			result.add(usr);
		}
		
		return result;
	}

	@Override
	public Users getUserById(String Id) {
		String sql = "SELECT * FROM users WHERE Id = ?";
		return (Users)getJdbcTemplate().queryForObject(sql, new Object[]{Id}, new RowMapper<Users>(){
			@Override
			public Users mapRow(ResultSet rs, int rwNumber) throws SQLException {
				Users usr = new Users();
				usr.setId(rs.getString("Id"));
				usr.setUsername(rs.getString("username"));
				usr.setPassword(rs.getString("password"));
				usr.setEnabled(rs.getBoolean("enabled"));
				return usr;
			}
		});
	}
	
	@Override
	public void deleteById(String Id) {
		System.out.println("I am in delete DAO");
		String sql = "delete * from users,authorities WHERE Id = ?";
		getJdbcTemplate().update(sql);
		
	}
}