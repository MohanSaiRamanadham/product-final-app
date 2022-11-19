package com.training.pms.galaxe.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.training.pms.galaxe.model.Product;

public interface ProductDAO  extends CrudRepository<Product, Integer>{
	
	//here we can only declare methods we can not define methods
	//Spring JPA will define the below methods so,those are not a dummy methods.
    //here below methods (findBy is a jpa Keyword and remaining pat is the variables we are declared in pojo class of Product).
	//check Query creation in SpringJpa
	
	public List<Product> findByProductName(String productName);
	public List<Product> findByPrice(int price);
	public List<Product> findByPriceBetween(int minPrice,int maxPrice);
	
	public List<Product> findByQtyInHandGreaterThan(int quantityInHand);  //this Query is equals to -->select * from product where qtyinHand>90.
 
	//we can create our own Query also as follows.Here we no need to follow the naming convention as above methods.
	@Query("from Product")//select * from Product
	
	
	public List<Product> findAllProducts();
}


//yet to know in this program
//1.@Service
//2.About CrudRepository.
//3.Optional
//4.findAll type of CRUD Repository
//5.isPresent
