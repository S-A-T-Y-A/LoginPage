package com.empdetails;

public class UserSheet {
	
	private int empId;
	private String inDate;
	private String inTime;
	private String outDate;
	private String outTime;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getInDate() {
		return inDate;
	}
	public void setInDate(String inDate) {
		this.inDate = inDate;
	}
	public String getInTime() {
		return inTime;
	}
	public void setInTime(String inTime) {
		this.inTime = inTime;
	}
	public String getOutDate() {
		return outDate;
	}
	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}
	public String getOutTime() {
		return outTime;
	}
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	public UserSheet(int empId, String inDate, String inTime, String outDate, String outTime) {
		super();
		this.empId = empId;
		this.inDate = inDate;
		this.inTime = inTime;
		this.outDate = outDate;
		this.outTime = outTime;
	}
	public UserSheet() {
		super();
	}
	@Override
	public String toString() {
		return "WorkSheet [empId=" + empId + ", inDate=" + inDate + ", inTime=" + inTime + ", outDate=" + outDate
				+ ", outTime=" + outTime + "]";
	}
	
	

}
