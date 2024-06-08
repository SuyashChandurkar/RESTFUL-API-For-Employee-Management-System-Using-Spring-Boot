package com.spring.springboot.productrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.springboot.pojo.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	
	
	abstract public List<Product> findByCategory(String category);
	
	
}
