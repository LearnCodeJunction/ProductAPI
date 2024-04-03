package com.product.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.product.model.Product_Enitiy;

public interface ProductRepo extends JpaRepository<Product_Enitiy,Serializable> {
	
	
//	@Query("select from Product_Stock where Product_Name =:name")
//	public List<Product_Enitiy> findBypName(String name);4
	
	@Query(" FROM Product_Enitiy  WHERE pName = :name")
	public List<Product_Enitiy> findBypName(String name);

	
	//public List<Product_Enitiy> findBypTotelCount(String )

}