package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.exception.IdNotFoundException;
import com.example.exception.ProductNotFoundException;
import com.example.model.Product;
import com.example.repository.IProductRepository;

public class ProductServiceIml implements IProductService{
	
	@Autowired
	private IProductRepository ProductRepository;

	@Override
	public void addProduct(Product product) {
		ProductRepository.save(product);
		
	}

	@Override
	public void updateProduct(Product product) {
		ProductRepository.save(product);
		
	}

	@Override
	public void deleteProduct(int bookId) {
		ProductRepository.deleteById(bookId);
		
	}

	@Override
	public Product getById(int productId) throws IdNotFoundException {
		return ProductRepository.findById(productId)
	             .orElseThrow(()-> new IdNotFoundException("invalid id"));
	}

	@Override
	public List<Product> getAll() {
		return ProductRepository.findAll();
	}

	@Override
	public List<Product> getByBrand(String brand) throws ProductNotFoundException {
		
		return ProductRepository.findByBrand(brand);
	}

	@Override
	public List<Product> getByLesserPrice(double price) throws ProductNotFoundException {
		
		return ProductRepository.getProductByLesserPrice(price);
	}

	@Override
	public List<Product> getByBrandCategory(String brand, String category) throws ProductNotFoundException {
		
		return ProductRepository.showByBrandCat(brand, category);
	}

	@Override
	public List<Product> getByBrandProductName(String brand, String name) {
		
		return ProductRepository.showByProductNameBrand(brand, name);
	}

	@Override
	public List<Product> getProductName(String name) {
		
		return ProductRepository.getByProducts(name);
	}

}
