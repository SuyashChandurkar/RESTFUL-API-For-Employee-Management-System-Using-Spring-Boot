package com.spring.springboot.productservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springboot.pojo.Product;
import com.spring.springboot.productrepository.ProductRepository;


@Service
public class ProductService {

	@Autowired
private ProductRepository productRepository;
	public Product addProduct(Product product) {
		return  productRepository.save(product);
		
	}
	public Object findProductById(long id) {
		Optional<Product> productbyid = productRepository.findById(id);
		System.out.println(productbyid);
		if (productbyid.isPresent()) {
			return productbyid.get();
		}else {
			return "NO Product Found Based On Id";
		}
	}
	public Object findAllProduct() {
		List<Product> Products = productRepository.findAll();
		
		if (Products.size()>0) {
			return Products;
		}else {
			return "No Products Found";
		}
		
	}
	public List<Product> findByCategory(String category) {
		List<Product> products = productRepository.findByCategory(category);
		
		if (products.size()>0) {
			
			System.out.println("productservices findByCategory() if block get executed");
			return products;
		}else {
			System.out.println("productservices findByCategory() else block get executed");
			return null;
		}
	}
	public Object deleteById(long id) {
		Optional<Product> optional = productRepository.findById(id);
		if (optional.isPresent()) {
			Product product = optional.get();
			productRepository.delete(product);
			return product;
		}else {
			return "NO PRODUCT FOUND BY GIVEN ID";
		}
	}
	
	
	

}
