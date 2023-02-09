package com.springboot.crud.api.dto;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.crud.api.model.Category;
import com.springboot.crud.api.model.Image;

@Component
public class ProductDto {
	
	private Long id;
	private String name;
	private String description;
	private Double price;
	private int quantity;
	private int inShellStock;
	private int currentStock;
	private List<Category> category;
	private LocalDate dateCreated;
	private Image productImage;
	
	public ProductDto() {
		
	}

	public ProductDto(Long id, String name, String description, Double price, int quantity, int inShellStock,
			int currentStock, List<Category> category, LocalDate dateCreated, Image productImage) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.inShellStock = inShellStock;
		this.currentStock = currentStock;
		this.category = category;
		this.dateCreated = dateCreated;
		this.productImage = productImage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getInShellStock() {
		return inShellStock;
	}

	public void setInShellStock(int inShellStock) {
		this.inShellStock = inShellStock;
	}

	public int getCurrentStock() {
		return currentStock;
	}

	public void setCurrentStock(int currentStock) {
		this.currentStock = currentStock;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Image getProductImage() {
		return productImage;
	}

	public void setProductImage(Image productImage) {
		this.productImage = productImage;
	}

	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", quantity=" + quantity + ", inShellStock=" + inShellStock + ", currentStock=" + currentStock
				+ ", category=" + category + ", dateCreated=" + dateCreated + ", productImage=" + productImage + "]";
	}

}
