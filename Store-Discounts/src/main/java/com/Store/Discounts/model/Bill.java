package com.Store.Discounts.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Bill implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9168345126005395696L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long billId;
	@ManyToOne
	@JoinColumn(name = "personId", nullable = false)
	Person person;
	private double billAmount;
	private double discountAmount;
	private String reson;
	private double billTotal;

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public String getReson() {
		return reson;
	}

	public void setReson(String reson) {
		this.reson = reson;
	}

	public double getBillTotal() {
		return billTotal;
	}

	public void setBillTotal(double billTotal) {
		this.billTotal = billTotal;
	}

	@Override
	public String toString() {
		return "Bill{"+ 
					"billId='" + billId + "'"+
					", person='" + person + "'"+
					", billAmount=" + billAmount + "'"+
					", discountAmount="+ discountAmount + "'"+
					", reson=" + reson + "'"+
					", billTotal=" + billTotal + "'"+
					"}";
	}

}
