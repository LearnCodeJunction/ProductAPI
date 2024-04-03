package com.product.service;

import java.util.List;

import com.product.model.Product_Enitiy;

public interface ProductService {
	// save 
	public String upsert(Product_Enitiy  product_Enitiy);
	// get
	public List<Product_Enitiy> fetchProduct();
	
	// find by Id
	public Product_Enitiy getById(Integer pId);
	
	// update
	public String updateProduct(Product_Enitiy product_Enitiy);
	
	// find by Name
	public List<Product_Enitiy> findAllProductName(String name);
	
	
	public String deleteById(Integer pId);

}
