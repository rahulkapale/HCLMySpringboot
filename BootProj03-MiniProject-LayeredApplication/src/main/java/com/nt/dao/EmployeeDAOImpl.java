package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.nt.BootProj03MiniProjectLayeredApplication;
import com.nt.model.Employee;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {

	//private final BootProj03MiniProjectLayeredApplication bootProj03MiniProjectLayeredApplication;
	private static final String GET_EMP_BY_DESGS = "SELECT ENO,ENAME,SALARY,JOB FROM EMP WHERE JOB IN(?,?,?) ORDER BY JOB";
	@Autowired
	private DataSource ds;

	@Override
	public List<Employee> getEmpsByDesgs(String desg1, String desg2, String desg3) throws Exception {
		List<Employee> listEmps = null;
		// get pooled jdbc connection obj
		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(GET_EMP_BY_DESGS)) { // try  with resources
			// set query param values
			ps.setString(1, desg1);
			ps.setString(2, desg2);
			ps.setString(3, desg3);
			// execute the Query
			try (ResultSet rs = ps.executeQuery()) {
				// copy ResultSet obj to List collection as Employee class objects
				listEmps = new ArrayList();
				while (rs.next()) {
					Employee emp = new Employee();
					emp.setEmpno(rs.getInt(1));
					emp.setEname(rs.getString(2));
					emp.setSalary(rs.getFloat(3));
					emp.setJob(rs.getString(4));
					listEmps.add(emp);
				} // while
			} // try2
		} // try1
		catch (SQLException se) {
			se.printStackTrace();
			throw se; // exception re-throwing
		} catch (Exception e) {
			e.printStackTrace();
			throw e; // exception re-throwing
		}
		return listEmps;
	}//method

}// class
