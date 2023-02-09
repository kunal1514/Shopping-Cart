package com.springboot.crud.api.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crud.api.dto.OrderDto;
import com.springboot.crud.api.dto.ProductDto;
import com.springboot.crud.api.dto.ResponseDto;
import com.springboot.crud.api.model.Orders;
import com.springboot.crud.api.model.Product;
import com.springboot.crud.api.service.OrderService;

@RestController
@CrossOrigin(origins = {"http://localhost:4080"})
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ResponseDto responseDto;
	
	@PostMapping("/add/order")
	public ResponseEntity<Object> placeOrder(@RequestBody Orders order) {
		Double d = Math.random();
		String random = String.valueOf(d);
		order.setOrderNo(random);
		order.setOrderDate(LocalDateTime.now());
		orderService.placeOrder(order);
		responseDto.setMsg("Order Placed Successfully");
		return ResponseEntity.status(HttpStatus.OK).body(responseDto);
	}
	
	@GetMapping("/get/orders")
	public List<OrderDto> getAllOrders() {
		List<OrderDto> dtoList = new ArrayList<>();
		List<Orders> orders = orderService.getAllOrders();
		for(Orders order: orders) {
			OrderDto dto = new OrderDto();
			dto.setId(order.getId());
			dto.setOrderNo(order.getOrderNo());
			dto.setOrderDate(order.getOrderDate());
			dto.setTotalQuantity(order.getTotalQuantity());
			dto.setTotal_amt(order.getTotal_amt());
			List<Product> products = order.getProducts();
			List<ProductDto> productDtoList = new ArrayList<>();
			products.forEach(p -> {
				ProductDto productDto = new ProductDto();
				productDto.setId(p.getId());
				productDto.setName(p.getName());
				productDto.setDescription(p.getDescription());
				productDto.setPrice(p.getPrice());
				productDto.setQuantity(p.getQuantity());
				productDto.setInShellStock(p.getInShellStock());
				productDto.setCurrentStock(p.getCurrentStock());
				productDto.setCategory(p.getCategory());
				productDto.setDateCreated(p.getDateCreated());
				productDto.setProductImage(p.getProductImage());
				
				productDtoList.add(productDto);
			});
			dto.setProductDto(productDtoList);
			
			dtoList.add(dto);
		}
		
		return dtoList;
	}

}
