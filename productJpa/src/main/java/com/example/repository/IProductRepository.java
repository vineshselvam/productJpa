package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findByBrand(String brand);
	List<Product> getByPriceLessThan(double price);
	List<Product> readByBrandAndCategory(String brand, String category);

	// custom queries
	// for custom queries -> the method name can be anything
	// map it using @Query annotation - add JPQL
	// here Book is not the table name it is class name. so first letter in capital
	@Query("from Product b where b.brand = ?1 ")
	List<Product> findByBrandName(String brand);

	@Query("from Product b where b.price< ?1")
	List<Product> getProductByLesserPrice(double nprice);
	
	@Query(value = "from Product b where b.brand=?1 and b.category=?2")
	List<Product> showByBrandCat(String brand, String category);
	
	// NamedQuery
	// create the create in the model class and use it here
	@Query(name = "showProductNameBrandName")
	List<Product> showByProductNameBrand(String brand,String name);

	// native query uses sql - here pass the book table name
	@Query(value = "select * from Product where name like ?1", nativeQuery = true)
	List<Product> getByProducts(String name);
}
