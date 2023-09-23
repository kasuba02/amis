package com.amis.ms.Bean;

import java.util.Date;

public class OrderBean extends BaseBean{
	
	private String empName;
	private String empEmail;
	private String empContactNo;
	private String leaveType;
	private Date leaveTo;
	private String leavedescription;
	private long userid;
	private String status;
	private String department;
	private Long order;
	private Long item;
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	private Long Qty;
	private Long amount;
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	private Long code;
	private String uom;
	private Long price;
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public Long getQty() {
		return Qty;
	}
	public void setQty(Long qty) {
		Qty = qty;
	}
	public Long getItem() {
		return item;
	}
	public void setItem(Long item) {
		this.item = item;
	}
	public Long getOrder() {
		return order;
	}
	public void setOrder(Long order) {
		this.order = order;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpContactNo() {
		return empContactNo;
	}
	public void setEmpContactNo(String empContactNo) {
		this.empContactNo = empContactNo;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	

	public Date getLeaveTo() {
		return leaveTo;
	}
	public void setLeaveTo(Date leaveTo) {
		this.leaveTo = leaveTo;
	}
	
	public String getLeavedescription() {
		return leavedescription;
	}
	public void setLeavedescription(String leavedescription) {
		this.leavedescription = leavedescription;
	}
	

}
