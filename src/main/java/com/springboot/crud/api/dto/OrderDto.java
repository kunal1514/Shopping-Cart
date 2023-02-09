package com.springboot.crud.api.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class OrderDto {
	
	private Long id;
	private String orderNo;
	private LocalDateTime orderDate;
	private int totalQuantity;
	private Double total_amt;
	private List<ProductDto> productDto;
	
	public OrderDto() {
		
	}

	public OrderDto(Long id, String orderNo, LocalDateTime orderDate, int totalQuantity, Double total_amt,
			List<ProductDto> productDto) {
		super();
		this.id = id;
		this.orderNo = orderNo;
		this.orderDate = orderDate;
		this.totalQuantity = totalQuantity;
		this.total_amt = total_amt;
		this.productDto = productDto;
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

	public List<ProductDto> getProductDto() {
		return productDto;
	}

	public void setProductDto(List<ProductDto> productDto) {
		this.productDto = productDto;
	}

	@Override
	public String toString() {
		return "OrderDto [id=" + id + ", orderNo=" + orderNo + ", orderDate=" + orderDate + ", totalQuantity="
				+ totalQuantity + ", total_amt=" + total_amt + ", productDto=" + productDto + "]";
	}
	
}
