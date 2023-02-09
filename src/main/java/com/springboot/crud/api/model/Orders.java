package com.springboot.crud.api.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String orderNo;
	private LocalDateTime orderDate;
	private int totalQuantity;
	private Double total_amt;
	
	@ManyToMany(
			fetch = FetchType.LAZY,
		    cascade = {
		        CascadeType.MERGE
		    })
	@JoinTable(name = "order_product",
			   joinColumns = { @JoinColumn(name = "order_id") },
	           inverseJoinColumns = { @JoinColumn(name = "product_id") })
	private List<Product> products;

	public Orders() {
		
	}

	public Orders(Long id, String orderNo, LocalDateTime orderDate, int totalQuantity, Double total_amt,
			List<Product> products) {
		super();
		this.id = id;
		this.orderNo = orderNo;
		this.orderDate = orderDate;
		this.totalQuantity = totalQuantity;
		this.total_amt = total_amt;
		this.products = products;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public Double getTotal_amt() {
		return total_amt;
	}

	public void setTotal_amt(Double total_amt) {
		this.total_amt = total_amt;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderNo=" + orderNo + ", orderDate=" + orderDate + ", totalQuantity="
				+ totalQuantity + ", total_amt=" + total_amt + ", products=" + products + "]";
	}

}
