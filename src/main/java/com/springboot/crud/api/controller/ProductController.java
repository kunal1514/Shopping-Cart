package com.springboot.crud.api.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.crud.api.dto.ProductDto;
import com.springboot.crud.api.dto.ResponseDto;
import com.springboot.crud.api.model.Category;
import com.springboot.crud.api.model.Image;
import com.springboot.crud.api.model.Product;
import com.springboot.crud.api.service.CategoryService;
import com.springboot.crud.api.service.ProductService;

@RestController
@CrossOrigin(origins = {"http://localhost:4080"})
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ResponseDto responseDto;
	
	
	@PostMapping(value = {"/add/product"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<Object> addproduct(@RequestPart("product") Product product,
											 @RequestPart("imageFile") MultipartFile file) {
		
		product.setCurrentStock(product.getCurrentStock() - product.getQuantity());
		try {
			Image image = uploadImage(file);
			product.setProductImage(image);
			productService.addproduct(product);
			responseDto.setMsg("Product added successfully");
			return ResponseEntity.status(HttpStatus.OK).body(responseDto);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}
	
	public Image uploadImage(MultipartFile file) throws IOException {
		Image image = new Image();
		image.setName(file.getOriginalFilename());
		image.setType(file.getContentType());
		image.setPicBytes(file.getBytes());
		
		return image;
	}
	
	@PutMapping(value = {"/edit/product/{id}"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<Object> editProduct(@RequestPart("product") Product newProduct,
											  @RequestPart("imageFile") MultipartFile file,
											  @PathVariable("id") Long id) {
		Product product = productService.getproductById(id);
		if(product == null) {
			responseDto.setMsg("Invalid Product ID");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDto);
		}
		product.setName(newProduct.getName());
		product.setDescription(newProduct.getDescription());
		product.setPrice(newProduct.getPrice());
		product.setCategory(newProduct.getCategory());
		product.setInShellStock(newProduct.getInShellStock());
		product.setCurrentStock(newProduct.getCurrentStock());
		try {
			Image image = uploadImage(file);
			product.setProductImage(image);
			productService.addproduct(product);
			responseDto.setMsg("Product updated successfully");
			return ResponseEntity.status(HttpStatus.OK).body(responseDto);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@DeleteMapping("/delete/product/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable("id") Long id) {
		Product product = productService.getproductById(id);
		if(product == null) {
			responseDto.setMsg("Invalid Product ID");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDto);
		}
		productService.deleteProduct(id);
		responseDto.setMsg("Product deleted successfully");
		return ResponseEntity.status(HttpStatus.OK).body(responseDto);
	}
	
	@GetMapping("/get/products")
	public List<ProductDto> getAllProducts() {
		List<Product> prodList = productService.getAllProducts();
		List<ProductDto> dtoList = new ArrayList<>();
		for(Product p: prodList) {
			ProductDto dto = new ProductDto();
			dto.setId(p.getId());
			dto.setName(p.getName());
			dto.setDescription(p.getDescription());
			dto.setPrice(p.getPrice());
			dto.setQuantity(p.getQuantity());
			dto.setInShellStock(p.getInShellStock());
			dto.setCurrentStock(p.getCurrentStock());
			dto.setDateCreated(p.getDateCreated());
			dto.setCategory(p.getCategory());
			dto.setProductImage(p.getProductImage());
			
			dtoList.add(dto);
		}
		
		return dtoList;
	}
	
	@GetMapping("/get/product/{id}")
	public ResponseEntity<Object> getProductById(@PathVariable("id") Long id) {
		Product product = productService.getproductById(id);
		if(product == null) {
			responseDto.setMsg("Invalid Product ID");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDto);
		}
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setDescription(product.getDescription());
		productDto.setPrice(product.getPrice());
		productDto.setQuantity(product.getQuantity());
		productDto.setInShellStock(product.getInShellStock());
		productDto.setCurrentStock(product.getCurrentStock());
		productDto.setDateCreated(product.getDateCreated());
		productDto.setCategory(product.getCategory());
		productDto.setProductImage(product.getProductImage());
		return ResponseEntity.status(HttpStatus.OK).body(productDto);
	}
	

}
