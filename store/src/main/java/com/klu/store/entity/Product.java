package com.klu.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="skill_product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pid;
	
	@Column(length=20,nullable = false)	
	private String pname;

	@Column(length=100)
	private String description;
	
	@Column(nullable = false)	
    private double price;
	
	@Column(nullable = false)
	private int qty;
	
	public Product() {
    }

	 public Product(String pname, String desc, double price, int qty) {
		super();
		this.pname = pname;
		this.description = desc;
		this.price = price;
		this.qty = qty;
	}
	 public int getPid() {
		 return pid;
	 }
	 public void setPid(int pid) {
		 this.pid = pid;
	 }
	 public String getPname() {
		 return pname;
	 }
	 public void setPname(String pname) {
		 this.pname = pname;
	 }
	 public String getDesc() {
		 return description;
	 }
	 public void setDesc(String desc) {
		 this.description = desc;
	 }
	 public double getPrice() {
		 return price;
	 }
	 public void setPrice(double price) {
		 this.price = price;
	 }
	 public int getQty() {
		 return qty;
	 }
	 public void setQty(int qty) {
		 this.qty = qty;
	 }
	 @Override
	 public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", desc=" + description + ", price=" + price + ", qty=" + qty
				+ "]";
	 }
	 

}
