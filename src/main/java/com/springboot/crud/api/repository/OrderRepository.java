package com.springboot.crud.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.crud.api.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {

}
