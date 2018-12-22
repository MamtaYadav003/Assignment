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
import com.assignment.work.dao.EmployeeDao;
import com.assignment.work.model.Employee;

public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao{

	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	@Override
	public void insertEmployee(Employee emp) {
		System.out.println("in add new emp insert method");
		String sql = "INSERT INTO employee " +
				"(eid, ename, emailid, emobile) VALUES (?, ?, ?, ?)" ;
		System.out.println("in add new emp insert method"+sql);
		getJdbcTemplate().update(sql, new Object[]{
				emp.getEid(), emp.getEname(), emp.getEmailid() , emp.getEmobile()
		});
		
	}
	
	@Override
	public void insertEmployees(final List<Employee> emp) {
		
		String sql = "INSERT INTO employee " + "(eid, ename, emailid, emobile) VALUES (?, ?, ?, ?)";
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Employee empl = emp.get(i);
				ps.setLong(1, empl.getEid());
				ps.setString(2, empl.getEname());
				ps.setString(3, empl.getEmailid());
				ps.setString(4, empl.getEmobile());
			}
			
			
			public int getBatchSize() {
				return emp.size();
			}
		});
		

	}
	@Override
	public List<Employee> getAllEmployee(){
		String sql = "SELECT * FROM Employee";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Employee> result = new ArrayList<Employee>();
		for(Map<String, Object> row:rows){
			Employee empl = new Employee();
			empl.setEid((Long) row.get("eid"));
			empl.setEname((String)row.get("ename"));
			empl.setEmailid((String)row.get("emailid"));
			empl.setEmobile((String)row.get("emobile"));
			result.add(empl);
		}
		
		return result;
	}

	
	public Employee getEmployeeById(String Id) {
		String sql = "SELECT * FROM employee WHERE Id = ?";
		return (Employee)getJdbcTemplate().queryForObject(sql, new Object[]{Id}, new RowMapper<Employee>(){
			@Override
			public Employee mapRow(ResultSet rs, int rwNumber) throws SQLException {
				Employee emp = new Employee();
				emp.setEid(rs.getLong("eid"));
				emp.setEname(rs.getString("ename"));
				emp.setEmailid(rs.getString("emailid"));
				emp.setEmobile(rs.getString("emobile"));
				return emp;
			}
		});
	}
	
	@Override
	public void deleteEmployee() {
		System.out.println("I am in delete DAO");
		String sql = "delete * from employee ";
		getJdbcTemplate().update(sql);
		
	}
	
	
}
