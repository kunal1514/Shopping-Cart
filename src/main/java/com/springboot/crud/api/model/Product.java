package com.springboot.crud.api.model;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	private Double price;
	private int quantity;
	private int inShellStock;
	private int currentStock;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Image productImage;
	
	@CreationTimestamp
	private LocalDate dateCreated;
	
	@ManyToMany(
			fetch = FetchType.LAZY,
		    cascade = {
		        CascadeType.MERGE
		    })
	@JoinTable(name = "products_category",
			   joinColumns = { @JoinColumn(name = "product_id") },
	           inverseJoinColumns = { @JoinColumn(name = "category_id") })
	private List<Category> category;
	
	@ManyToMany(fetch = FetchType.LAZY,
		        cascade = {
		          CascadeType.MERGE
		        },
		        mappedBy = "products")
	private List<Orders> orders;
	
	public Product() {
		
	}

	public Product(Long id, String name, String description, Double price, int quantity, int inShellStock,
			int currentStock, Image productImage, LocalDate dateCreated, List<Category> category, List<Orders> orders) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.inShellStock = inShellStock;
		this.currentStock = currentStock;
		this.productImage = productImage;
		this.dateCreated = dateCreated;
		this.category = category;
		this.orders = orders;
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

	public Image getProductImage() {
		return productImage;
	}

	public void setProductImage(Image productImage) {
		this.productImage = productImage;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", quantity=" + quantity + ", inShellStock=" + inShellStock + ", currentStock=" + currentStock
				+ ", productImage=" + productImage + ", dateCreated=" + dateCreated + ", category=" + category
				+ ", orders=" + orders + "]";
	}

}
