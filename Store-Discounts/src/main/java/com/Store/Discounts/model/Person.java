package com.Store.Discounts.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5438349304415814509L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private long personId;
	@Column(nullable = false)
	private String phone;
	@OneToMany(mappedBy = "person")
	private Set<Employee> employees;

	@OneToMany(mappedBy = "person")
	private Set<Bill> bills;

	public Person() {
	}

	public Person(long personId, String phone) {
		this.personId = personId;
		this.phone = phone;
	}

	public Person(String phone) {

		this.phone = phone;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Set<Bill> getBills() {
		return bills;
	}

	public void setBills(Set<Bill> bills) {
		this.bills = bills;
	}

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Person{" + "personId='" + personId + '\'' + ", phone='" + phone + '\'' + "}";
	}

}
