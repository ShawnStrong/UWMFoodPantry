package com.concretepage.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Donation {

	@Id
	@GeneratedValue
	private int donation_id;
	
	private int donation_type;
	
	private String category_name;
	
	private String category_size;
	
	private float category_weight;
	
	private int category_amount;
	
	private String user_name;

	private String ts;
	
	public Donation() {}
	
	public Donation(int donation_id, int donation_type, 
			String category_name, String category_size,
			int category_weight, int category_amount, 
			String user_name, String ts) {
		this.donation_id = donation_id;
		this.donation_type = donation_type;
		this.category_name = category_name;
		this.category_size = category_size;
		this.category_weight = category_weight;
		this.category_amount = category_amount;
		this.user_name = user_name;
		this.ts = ts;
	}
	
	public int getDonationId() {
		return donation_id;
	}
	
	public void setDonationId(int donation_id) {
		this.donation_id = donation_id;
	}
	
	public int getDonationType() {
		return donation_type;
	}
	
	public void setDonationType(int donation_type) {
		this.donation_type = donation_type;
	}
	
	public String getCategoryName() {return category_name;}
	
	public void setCategoryName(String category_name) {
		this.category_name = category_name;
	}
	
	public String getCategorySize() {
		return category_size;
	}
	
	public void setCategorySize(String category_size) {
		this.category_size = category_size;
	}
	
	public float getCategoryWeight() {
		return category_weight;
	}
	
	public void setCategoryWeight(int category_weight) {
		this.category_weight = category_weight;
	}
	
	public int getCategoryAmount() {
		return category_amount;
	}
	
	public void setCategoryAmount(int category_amount) {
		this.category_amount = category_amount;
	}
	
	public String getUserName() {
		return user_name;
	}
	
	public void setUserName(String user_name) {
		this.user_name = user_name;
	}
	
	public String getTs() {
		return ts;
	}
	
	public void setTs(String ts) {
		this.ts = ts;
	}
}