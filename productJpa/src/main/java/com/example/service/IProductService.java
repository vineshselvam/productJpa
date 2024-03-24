package com.example.service;

import java.util.List;

import com.example.exception.IdNotFoundException;
import com.example.exception.ProductNotFoundException;
import com.example.model.Product;

public interface IProductService {
	// admin 
		void addProduct(Product product);  // create
		void updateProduct(Product product); //update
		void deleteProduct(int bookId); //delete
		Product getById(int productId) throws IdNotFoundException; // retrieve
		
		// User
		List<Product> getAll(); // retrieve
		List<Product> getByBrand(String brand) throws ProductNotFoundException;
		List<Product> getByLesserPrice(double price) throws ProductNotFoundException;
		List<Product> getByBrandCategory(String brand,String category) throws ProductNotFoundException;
		
		// namedquery
		List<Product> getByBrandProductName(String brand, String name);
		
		// native query
		List<Product> getProductName(String name);
}
