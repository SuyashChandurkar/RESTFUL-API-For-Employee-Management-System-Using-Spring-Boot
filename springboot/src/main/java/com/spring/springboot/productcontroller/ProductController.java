package com.spring.springboot.productcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springboot.pojo.Product;
import com.spring.springboot.pojo.User;
import com.spring.springboot.productservice.ProductService;
import com.spring.springboot.productservice.UserServices;
import com.spring.springboot.response.ResponseStructure;

@RestController
public class ProductController {
    @Autowired
	private ProductService productService;
    
    
    @Autowired
    private UserServices services;
	
	@PostMapping("/add_product")
	public ResponseStructure<Product> addProduct(@RequestParam(name="userid")long userId, @RequestBody Product product) {
		Object findUserById = services.findUserById(userId);
		ResponseStructure<Product> responseStructure=new ResponseStructure<>();
		
		
		if (findUserById != null && findUserById.equals("seller")) {
			Product addedProduct = productService.addProduct(product);
			 System.out.println(addedProduct);
			 responseStructure.setMessage("PRODUCT ADDED");
			 responseStructure.setHttpStatus(HttpStatus.CREATED);
			 responseStructure.setHttpcode(HttpStatus.CREATED.value());
			 responseStructure.setData(addedProduct);
			 return responseStructure;
		}else {
			responseStructure.setMessage("INVALID USER");
			responseStructure.setHttpcode(HttpStatus.UNAUTHORIZED.value());
			responseStructure.setHttpStatus(HttpStatus.UNAUTHORIZED);
		}
		
		 return responseStructure;
	}
	
	
	@GetMapping("/get_product") 
	public Object findProductById(@RequestParam long id) {
		return productService.findProductById(id);
		
	}
	
	
	@GetMapping("/find_all_products")
	public Object findAllProducts() {
	return	productService.findAllProduct();
	}
	
	
	@GetMapping("/findbycategory/{category}")
	public ResponseStructure<List<Product>> findByCategory(@PathVariable String category) {
	List<Product> product = productService.findByCategory(category);
	ResponseStructure<List<Product>> responseStructure=new ResponseStructure<>();
	
	if (product!=null) {
		responseStructure.setMessage("DATA FOUND");
		responseStructure.setHttpStatus(HttpStatus.FOUND);
		responseStructure.setHttpcode(HttpStatus.FOUND.value());
		responseStructure.setData(product);
	
	}else {
		responseStructure.setMessage("DATA FOUND");
		responseStructure.setHttpStatus(HttpStatus.NOT_FOUND);
		responseStructure.setHttpcode(HttpStatus.NOT_FOUND.value());
	}
	
	return responseStructure;
	}
	
	@PostMapping("/updateproduct")
	public Product updateProduct(@RequestBody Product product ) {
		 return productService.addProduct(product);
	}
	
	
	@DeleteMapping("/deletebyid")
	public Object deleteById(@RequestParam(name="id") long id) {
		return productService.deleteById(id);
	}
	
	
	
}
