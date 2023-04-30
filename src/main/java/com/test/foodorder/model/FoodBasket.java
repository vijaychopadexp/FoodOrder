package com.test.foodorder.model;

import java.util.List;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "foodbasket")
public class FoodBasket {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Users users;
	
	
	@OneToMany(targetEntity = Items.class,cascade = CascadeType.ALL)
	private List<Items> itemList;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	

	public List<Items> getItemList() {
		return itemList;
	}


	public void setItemList(List<Items> itemList) {
		this.itemList = itemList;
	}


	@Override
	public String toString() {
		return "FoodBasket [id=" + id + ", user=" + users + ", itemList=" + itemList + "]";
	}
	
	
	

}
