package com.springboot.crud.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.crud.api.model.Product;
import com.springboot.crud.api.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	public void addproduct(Product product) {
		productRepository.save(product);
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product getproductById(Long id) {
		Optional<Product> optional = productRepository.findById(id);
		if(optional.isPresent()) {
			Product product = optional.get();
			return product;
		}
		return null;
	}

	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

}
