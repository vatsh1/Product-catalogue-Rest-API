package com.webapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int ProductCode;
	private String image;
	private String Name;
	private String Brand;
	private String Price;


	public Product() {
	}

	public Product(int id, int ProductCode, String image, String Name, String Brand, String Price) {
		this.id = id;
		this.ProductCode = ProductCode;
		this.Name = Name;
		this.Brand = Brand;
		this.Price = Price;
		this.image = image;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public int getProductCode() {
		return ProductCode;
	}

	public String getName() {
		return Name;
	}

	public String getBrand() {
		return Brand;
	}

	public String getPrice() {
		return Price;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setProductCode(int ProductCode) {
		this.ProductCode = ProductCode;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public void setBrand(String Brand) {
		this.Brand = Brand;
	}

	public void setPrice(String Price) {
		this.Price = Price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", ProductCode=" + ProductCode + ", Name=" + Name + ", Brand=" + Brand
				+ ", Price=" + Price + "]";
	}

}
