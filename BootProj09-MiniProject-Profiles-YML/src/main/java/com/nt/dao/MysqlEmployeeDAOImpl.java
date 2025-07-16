package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import com.nt.BootProj09MiniProjectLayeredApplication;
import com.nt.model.Employee;

@Repository("mysqlEmpDAO")
@Profile({"dev","test"})
public class MysqlEmployeeDAOImpl implements IEmployeeDAO {

	//private final BootProj03MiniProjectLayeredApplication bootProj03MiniProjectLayeredApplication;
	private static final String GET_EMP_BY_DESGS = "SELECT ENO,ENAME,DESG,SALARY FROM EMP_PROFILE WHERE DESG IN(?,?,?) ORDER BY DESG";
	@Autowired
	private DataSource ds;

	public MysqlEmployeeDAOImpl() {
		System.out.println("MysqlEmployeeDAOImpl:: 0 Param constructor");
	}

	@Override
	public List<Employee> getEmpsByDesgs(String desg1, String desg2, String desg3) throws Exception {
		System.out.println("MysqlEmployeeDAOImpl.getEmpsByDesgs()::"+ds.getClass());
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
					emp.setJob(rs.getString(3));
				 	emp.setSalary(rs.getFloat(4));
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
