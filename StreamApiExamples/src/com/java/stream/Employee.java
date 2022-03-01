package com.java.stream;

public class Employee {
	
    private int empId;
    private String empName;
    private int deptId;
    private String status;
    private int salary;
    
    // getter-setter
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	// parameterized constructor
	public Employee(int empId, String empName, int deptId, int salary, String status) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.deptId = deptId;
		this.status = status;
		this.salary = salary;
	}
	
	// toString()
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", deptId=" + deptId + ", status=" + status
				+ ", salary=" + salary + "]";
	}	

}
