package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.model.Product;
import com.example.service.IProductService;

@SpringBootApplication
public class ProductJpaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProductJpaApplication.class, args);
	}
	private IProductService productService;
	
	@Autowired
	public void setBookService(IProductService productService) {
		this.productService = productService;
	}
	@Override
	public void run(String... args) throws Exception {
		// create a Product object and call addProduct method of IProductservice
				Product product = new Product("IPhone",1,"Apple","mobile",75000);
				
				Product product1 = new Product("Galaxy s20",2,"samsung","fiction",120000);

				
				Product nproduct = productService.getById(2);

				nproduct.setName("iphone");
				nproduct.setPrice(75000);

				
				productService.getByBrand("R").forEach(System.out::println);
				System.out.println();
				System.out.println("Products by price");
				productService.getByLesserPrice(1000).forEach(System.out::println);
				System.out.println();
				System.out.println("Products By brand cat");
				productService.getByBrandCategory("Apple","Mobile").forEach(System.out::println);
				
				System.out.println();
				System.out.println("Products By brand productname");
				productService.getByBrandProductName("Iphone","leadership").forEach(System.out::println);
				
				System.out.println();
				System.out.println("Product By  Name");
				productService.getProductName ("l").forEach(System.out::println);
	}

}
