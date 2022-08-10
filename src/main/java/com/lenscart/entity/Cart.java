package com.lenscart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue
	@Column(name = "itemId")
	private int itemId;

	@Column(name = "name")
	private String name;

	@Column(name = "brand")
	private String brand;

	@Column(name = "price")
	private double price;

	public Cart() {
		super();
	}

	public Cart(int itemId, String name, String brand, double price) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.brand = brand;
		this.price = price;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
