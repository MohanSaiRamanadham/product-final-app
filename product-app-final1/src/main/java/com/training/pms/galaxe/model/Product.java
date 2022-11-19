//lombok -->is used to reduce boiler plate code.
//this is not related to Spring.this is a third party service.

package com.training.pms.galaxe.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "freshproducts")
@Data
public class Product {
	@Id
	private int productId;
	private String productName;
	private int qtyInHand;
	private int price;

}

//AOP- Aspect Oriented Programming.===for security check.
//used for cross cutting concerns:-
//1.Logging
//2.security
//3.transactions
//-----*-----

//Pointcut:-where to apply Aspects
//pointcut expressions:-
//  *Product
//  *.com.service

//there are 4 types of Aspects
//1.@Before--called before the method.
//2.@After-- called after the method.
//3.@Around-- called before and after the method.
//@Throws-- this is for exception.


