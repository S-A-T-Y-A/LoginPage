package com.empdetails;

public class Employee {
	
	private int empId;
	private String userName;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Employee(int empId, String userName) {
		super();
		this.empId = empId;
		this.userName = userName;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", userName=" + userName + "]";
	}
	

}
