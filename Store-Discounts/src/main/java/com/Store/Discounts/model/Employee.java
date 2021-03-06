package com.Store.Discounts.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Employee implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -1751427592310718049L;
	@Id
	@Column(nullable = false, updatable = false)
	private long id;
	@Column(nullable = false)
	private String role;
	@Column(nullable = false)
	private Date startDate;
	@Column(nullable = true)
	private Date endDate;
	@ManyToOne
	@JoinColumn(name = "personId" ,nullable = false)
	Person person;
	
	public Employee() {}

	public Employee(long id, String role, Date startDate, Date endDate) {
		this.id = id;
		this.role = role;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "employee{ "+
					"id='" + id + "'"+
					", role='" + role +"'"+ 
					", startDate='" + startDate + "'"+
					", endDate='" + endDate + "'"+
					"}";
	}

}
