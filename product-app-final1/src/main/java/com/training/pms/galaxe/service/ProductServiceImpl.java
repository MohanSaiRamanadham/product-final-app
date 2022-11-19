
package com.training.pms.galaxe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.pms.galaxe.aop.LoggingAspects;
import com.training.pms.galaxe.dao.ProductDAO;
import com.training.pms.galaxe.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDAO productDAO;

	//Constructor
	public ProductServiceImpl() {
		// TODO Auto-generated constructor stub
	}

    //	@Autowired
    //	LoggingAspects l;
	//i don't want to use Autowire also to call doLogging() method
    //how to do is go to Logging class and use pointCut Concept like @Before.
	
	//1
	@Override
	public String saveProduct(Product product) {
		//security check--10 lines code
		//logging keep record of who saved product and what is the product and everything.--5lines of code
		//transaction--topic related to Sql.
		
		System.out.println("Save Product called");
//		l.doLogging();
		
		if (product.getPrice() < 0 | product.getQtyInHand() < 0) {
			return "Product price and Quantity should not be negative";
		} else {
			productDAO.save(product);
			return "Product saved sucessfully";
		}

	}

	//2
	@Override
	public String updateProduct(Product product) {
		System.out.println("update Product called");

		if (product.getPrice() < 0 | product.getQtyInHand() < 0) {
			return "Product price and Quantity should not be negative,not updated";
		}else {
		productDAO.save(product);
		return "Product Updated Sucessfully";
	}
	}

	//3
	@Override
	public String deleteProduct(int productId) {
		System.out.println("delete Product called");

		productDAO.deleteById(productId);
		return "Product deleted Sucessfully";
	}

	//4
	@Override
	public Product getProduct(int productId) {
		System.out.println("get Product called");

		Optional<Product> product = productDAO.findById(productId);
		return product.get();
	}
	
	//5

	@Override
	public List<Product> getProduct() {
		System.out.println("get Product called");

		return (List<Product>)productDAO.findAll();
	}
	
	//6
	@Override
	public boolean isProductExist(int productId) {
		  Optional<Product> product=productDAO.findById(productId);
		return product.isPresent();
	}

	//7
	@Override
	public List<Product> searchProduct(String productName) {

		return productDAO.findByProductName(productName);
	}
	

	//8
	@Override
	public List<Product> searchProduct(int min, int max) {
		// TODO Auto-generated method stub
		return productDAO.findByPriceBetween(min, max);
	}
 
	//9
	@Override
	public List<Product> checkStockStatus(int minStock) {
		return productDAO.findByQtyInHandGreaterThan(minStock);
	}

	//10
	@Override
	public List<Product> searchProduct(String productName, int price, int qoh) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
