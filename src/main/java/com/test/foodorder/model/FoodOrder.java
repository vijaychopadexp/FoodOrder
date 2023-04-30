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
@Table(name = "foodorder")
public class FoodOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDateTime orderDate;
	private String orderStatus;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private FoodBasket foodbasket;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private  Billing biiling;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public LocalDateTime getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}


	public String getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}


	public FoodBasket getFoodbasket() {
		return foodbasket;
	}


	public void setFoodbasket(FoodBasket foodbasket) {
		this.foodbasket = foodbasket;
	}


	public Billing getBiiling() {
		return biiling;
	}


	public void setBiiling(Billing biiling) {
		this.biiling = biiling;
	}


	@Override
	public String toString() {
		return "FoodOrder [id=" + id + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus + ", foodbasket="
				+ foodbasket + ", biiling=" + biiling + "]";
	}
	
	
	
	
}
