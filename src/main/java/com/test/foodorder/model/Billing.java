package com.test.foodorder.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "billing")
public class Billing {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double costTotal;
	private int totalItems;
	private LocalDateTime billingDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	private FoodOrder foodorder;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCostTotal() {
		return costTotal;
	}

	public void setCostTotal(double costTotal) {
		this.costTotal = costTotal;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public LocalDateTime getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(LocalDateTime billingDate) {
		this.billingDate = billingDate;
	}

	public FoodOrder getFoodorder() {
		return foodorder;
	}

	public void setFoodorder(FoodOrder foodorder) {
		this.foodorder = foodorder;
	}

	@Override
	public String toString() {
		return "Billing [id=" + id + ", costTotal=" + costTotal + ", totalItems=" + totalItems + ", billingDate="
				+ billingDate + ", foodorder=" + foodorder + "]";
	}
	
	
	
	
	
}
