package com.test.foodorder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String mobileNumber;
	private String email;
	

	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private FoodBasket foodbasket;
	
	
	


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public FoodBasket getFoodbasket() {
		return foodbasket;
	}


	public void setFoodbasket(FoodBasket foodbasket) {
		this.foodbasket = foodbasket;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", mobileNumber=" + mobileNumber + ", email=" + email
				+ ", foodbasket=" + foodbasket + "]";
	}
	
	
	
}
