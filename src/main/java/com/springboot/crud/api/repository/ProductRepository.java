package com.springboot.crud.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.crud.api.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
