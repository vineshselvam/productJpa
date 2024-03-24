package com.example.model;

import jakarta.persistence.*;

@Entity

@NamedQuery(name="showProductNameBrandName",
query="from  Product b where b.brand=?1 and b.name=?2")
public class Product {
	String name;
	@Id // identified as primary key
	@GeneratedValue // spring creates a seq called domain modelname_seq
	Integer Id;
	String brand;
	String category;
	double price;
	
	
	public Product() {
		super();
	}
	
	public Product(String name, Integer id, String brand, String category, double price) {
		super();
		this.name = name;
		Id = id;
		this.brand = brand;
		this.category = category;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", Id=" + Id + ", brand=" + brand + ", category=" + category + ", price="
				+ price + "]";
	}
	
	
	
	
	
}
