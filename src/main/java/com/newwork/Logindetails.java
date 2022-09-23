package com.newwork;

public class Logindetails {
	
	private String uniqueCode;
	private int empId;
	public String getUniqueCode() {
		return uniqueCode;
	}
	public void setUniqueCode(String uniqueCode) {
		this.uniqueCode = uniqueCode;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public Logindetails(String uniqueCode, int empId) {
		super();
		this.uniqueCode = uniqueCode;
		this.empId = empId;
	}
	public Logindetails() {
		super();
	}
	

}
