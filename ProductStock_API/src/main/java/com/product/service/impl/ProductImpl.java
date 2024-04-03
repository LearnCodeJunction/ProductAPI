package com.product.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.model.Product_Enitiy;
import com.product.repository.ProductRepo;
import com.product.service.ProductService;

@Service
public class ProductImpl implements ProductService {
	
	@Autowired
	private ProductRepo productRepo;

	// Add Product
	@Override
	public String upsert(Product_Enitiy product_Enitiy) {
		System.out.println(product_Enitiy);
	int pId=	productRepo.save(product_Enitiy).getPId();
		return "Successfully Added to Stock  "+pId;
	}

	// get All Product
	@Override
	public List<Product_Enitiy> fetchProduct() {
		List<Product_Enitiy> list=productRepo.findAll();
		list.sort((p1,p2)->p1.getPId().compareTo(p2.getPId()));
		return list;
	}

	// find by Id
	@Override
	public Product_Enitiy getById(Integer pId) {
		Optional<Product_Enitiy> findById = productRepo.findById(pId);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public String updateProduct(Product_Enitiy product_Enitiy) {
		Optional<Product_Enitiy> optional = productRepo.findById(product_Enitiy.getPId());
		if (optional.isPresent()) {
			productRepo.save(product_Enitiy);
			return product_Enitiy.getPId()+"Product Update Successfully ";
		} else {
			return product_Enitiy.getPId()+"  Not Found Product Id ..";
		}
		
	}
/*
	@Override
	public List<Product_Enitiy> showfindByName(String name) {
		return  productRepo.findByName(name);
	}
*/

	@Override
	public List<Product_Enitiy> findAllProductName(String name) {
		
		return productRepo.findBypName(name);
	}

	@Override
	public String deleteById(Integer pId) {
		if (productRepo.existsById(pId)) {
			productRepo.deleteById(pId);
			return "Delete Success  " +pId;
		} else {
			return "No Recode Found   " +pId
;		}
		
	}
}
