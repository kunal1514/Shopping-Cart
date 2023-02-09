package com.springboot.crud.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.crud.api.model.Orders;
import com.springboot.crud.api.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	public void placeOrder(Orders order) {
		orderRepository.save(order);
	}

	public List<Orders> getAllOrders() {
		return orderRepository.findAll();
	}

}
