package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@EnableAspectJAutoProxy(proxyTargetClass = false)  //to enable @Aspect we should use this.
public class ProductAppFinal1Application {

	public static void main(String[] args) {
		SpringApplication.run(ProductAppFinal1Application.class, args);
		System.out.println("welcome mohan");
	}

}

//Controller --will calls-->Services --will calls-->DAO