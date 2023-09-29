package com.mysmartshop.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mysmartshop.product.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, String> {

}
