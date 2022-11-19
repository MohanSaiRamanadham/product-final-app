package com.training.pms.galaxe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.pms.galaxe.dao.ProductDAO;
import com.training.pms.galaxe.model.Product;
import com.training.pms.galaxe.service.ProductService;

@RestController
@RequestMapping("product")
//@CrossOrigin(origins="http://localhost:3000")
public class ProductController {
    
	@Autowired
	ProductService productService;
	
	
	@PostMapping()
	public ResponseEntity<String> saveProduct(@RequestBody Product product) {
		ResponseEntity<String> responseEntity;
		int pId=product.getProductId();
       if(productService.isProductExist(pId)) {
   		responseEntity=new  ResponseEntity<String>("product with id :"+pId+"already exist",HttpStatus.CONFLICT);

       }else {
    	  String message= productService.saveProduct(product);
    	  responseEntity=new ResponseEntity<String>(message,HttpStatus.OK);
       }
		return responseEntity;
	}
	
	@PutMapping()
	public String updateProduct(@RequestBody Product product) {
		return "product is Updated "+product;
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> products=productService.getProduct();
		ResponseEntity<List<Product>> responseEntity;
		if(products.isEmpty()) {
			responseEntity=new ResponseEntity<List<Product>>(products,HttpStatus.NO_CONTENT);
		}else {
			responseEntity=new ResponseEntity<List<Product>>(products,HttpStatus.OK);

		}
		return responseEntity;
	}
	
	//Search by productId
	@GetMapping("{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable("productId")Integer Id) {
		ResponseEntity<Product> responseEntity;
		Product message=new Product();
		if(productService.isProductExist(Id)) {
			message=productService.getProduct(Id);
			responseEntity=new ResponseEntity<Product>(message,HttpStatus.OK);
		}else {
			responseEntity=new ResponseEntity<Product>(message,HttpStatus.CONFLICT);
		}
		
    	return 	responseEntity;
    }
	
	//Search by productName
	//Here we are searching based on name so we will get a list of products
	
		@GetMapping("searchByProductName/{productName}")
	    public ResponseEntity<List<Product>> getProductByName(@PathVariable("productName")String productName) {
			ResponseEntity<List<Product>> responseEntity;
			List<Product> products=productService.searchProduct(productName);
			if(products.isEmpty()) {
				responseEntity=new ResponseEntity<List<Product>>(products,HttpStatus.NO_CONTENT);
			}else {
				responseEntity=new ResponseEntity<List<Product>>(products,HttpStatus.OK);

			}
			return responseEntity;
	    }
	
	@DeleteMapping("{productId}")
	public String deleteProduct(@PathVariable("productId")Integer Id) {
		return "Deleting a single product with id :"+Id;
	}
	@GetMapping("searchByRange/{min}/{max}")
	public ResponseEntity<List<Product>> getProductByRange(@PathVariable("min")Integer min,@PathVariable("max")Integer max){
		ResponseEntity<List<Product>> responseEntity;
        List<Product> products=productService.searchProduct(min,max);
        if(products.isEmpty()) {
			responseEntity=new ResponseEntity<List<Product>>(products,HttpStatus.NO_CONTENT);
		}else {
			responseEntity=new ResponseEntity<List<Product>>(products,HttpStatus.OK);

		}
		return responseEntity;
	}
	
	
}
