package com.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.empdetails.Employee;
import com.empdetails.UserSheet;
import com.newwork.Logindetails;

public class CRUD {
	
	public boolean isUser(int empId) {
		String allidsQuery="select empid from employee;";
		PreparedStatement sts;
		try {
			sts = JDBCConnection.getconnect().prepareStatement(allidsQuery);
			ResultSet allEmpIds=sts.executeQuery();
			while(allEmpIds.next()) {
				if(empId==allEmpIds.getInt("empId")) {
					return true;
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	
	
	public boolean logInDetails(Employee emp)
	 {
		String sql="insert into logindetails(empid,indate,intime) values(?,current_date(),current_time());";
		 try
		 {
			PreparedStatement sts = JDBCConnection.getconnect().prepareStatement(sql);
			sts.setInt(1, emp.getEmpId());
			
			
			
			return sts.executeUpdate()>0;
		} 
		 catch (SQLException e) 
		 {
			e.printStackTrace();
		}
		 return false;
	 }
//	
	
	public List<UserSheet> getWorkSheet(int empId){
		
		String sql="select login.empid,login.indate,login.intime,logout.outdate,logout.outtime from logindetails login,logoutdetails logout where login.empid=logout.empid and login.empid=?";
		List<UserSheet> workSheet=new ArrayList<>();
		PreparedStatement sts;
		try {
			sts = JDBCConnection.getconnect().prepareStatement(sql);
			sts.setInt(1,empId);
			ResultSet details=sts.executeQuery();
			while(details.next()) {
				UserSheet sheet=new UserSheet(details.getInt("empid"),details.getString("indate"),details.getString("intime"),details.getString("outdate"),details.getString("outtime"));
				workSheet.add(sheet);
				System.out.println(sheet);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return workSheet;
		
	}
	public boolean logOutDetails(int empId)
	 {
		String sql="insert into logoutdetails(empid,outdate,outtime) values(?,current_date(),current_time());";
		 try
		 {
			PreparedStatement sts = JDBCConnection.getconnect().prepareStatement(sql);
			sts.setInt(1, empId);
			
			
			
			return sts.executeUpdate()>0;
		} 
		 catch (SQLException e) 
		 {
			e.printStackTrace();
		}
		 return false;
	 }

	
	public boolean newRegister(Employee emp) {
		String sql="insert into employee values(?,?)";
		try {
			PreparedStatement sts=JDBCConnection.getconnect().prepareStatement(sql);
			sts.setInt(1, emp.getEmpId());
			sts.setString(2, emp.getUserName());
			return sts.executeUpdate()>0;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
//	
	
	
//	new Work
	public boolean isUniqueCode(String UniqueCode) {
		
		String sql="select uniquecode from worksheet;";
		try {
			PreparedStatement sts=JDBCConnection.getconnect().prepareStatement(sql);
			ResultSet allUniqueCodes=sts.executeQuery();
			while(allUniqueCodes.next()) {
				if(UniqueCode==allUniqueCodes.getString("uniquecode")) {
					return false;
				}
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	
	public boolean newLogin(Logindetails newlogin) {
		
		String sql ="insert into worksheet(uniquecode,empid,indate,intime) values(?,?,current_date(),current_time());";
		try {
			PreparedStatement sts=JDBCConnection.getconnect().prepareStatement(sql);
			sts.setString(1, newlogin.getUniqueCode());
			sts.setInt(2, newlogin.getEmpId());
			return sts.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean logoutentry(String uniqueCode) {
		String sql="update worksheet set outdate=current_date(),outtime=current_time() where uniquecode=?";
		try {
			PreparedStatement sts=JDBCConnection.getconnect().prepareStatement(sql);
			sts.setString(1, uniqueCode);
			return sts.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
public List<UserSheet> newgetWorkSheet(int empId){
		
		String sql="select empid,intime,indate,outtime,outdate from worksheet where empid=? order by indate,intime,outdate,outtime asc";
		List<UserSheet> workSheet=new ArrayList<>();
		PreparedStatement sts;
		try {
			sts = JDBCConnection.getconnect().prepareStatement(sql);
			sts.setInt(1,empId);
			ResultSet details=sts.executeQuery();
			while(details.next()) {
				UserSheet sheet=new UserSheet(details.getInt("empid"),details.getString("indate"),details.getString("intime"),details.getString("outdate"),details.getString("outtime"));
				workSheet.add(sheet);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return workSheet;
		
	}
	
//	public List<Employee> selectAll(){
//		List<Employee> list=new ArrayList<>();
//		String query="select * from registration;";
//		try {
//			PreparedStatement statement=JDBCConnection.getconnect().prepareStatement(query);
//			ResultSet details=statement.executeQuery();
//			while(details.next()) {
//				Employee emp=new Employee();
//				emp.setUsername(details.getString("username"));
//				emp.setPassword(details.getString("password"));
//				emp.setEmail(details.getString("email"));
//				emp.setMobile(details.getString("mobile"));
//				list.add(emp);
//				System.out.println(emp);
//				
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return list;
//		
//	}

}
