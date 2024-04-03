package com.product.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Product_Enitiy;
import com.product.service.ProductService;

@RestController
public class ProductRestController {
	
	@Autowired
	private ProductService productService;
	
	// add Product
	@PostMapping("/productAdd")
	public ResponseEntity<String> createProduct(@RequestBody Product_Enitiy product_Enitiy){
		System.out.println("Product  "+product_Enitiy);
		String status = productService.upsert(product_Enitiy);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	// get All Product
	
	@GetMapping("/AllProduct")
	public ResponseEntity<?> showProduct(){
		try {
			List<Product_Enitiy> list =productService.fetchProduct();
			return new ResponseEntity<List<Product_Enitiy>> (list,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("So Sorry Server Error ",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	// get find by Id
	@GetMapping("/product/{pId}")
	public ResponseEntity<Product_Enitiy> getProduct(@PathVariable Integer pId){
		Product_Enitiy product_Enitiy = productService.getById(pId);
		return new ResponseEntity<>(product_Enitiy,HttpStatus.OK);
	}
	
	// update 
	@PutMapping("/productUpdate")
	public ResponseEntity<String> updateProduct(@RequestBody Product_Enitiy product_Enitiy){
		try {
			String status = productService.updateProduct(product_Enitiy);
			return new ResponseEntity<String>(status,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	@GetMapping("/findWithName/{name}")
	public ResponseEntity<?> findByName(@PathVariable("name") String name){
		try {
			List<Product_Enitiy> list = productService.findAllProductName(name);
			return new ResponseEntity<List<Product_Enitiy>>(list,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@DeleteMapping("/product/{pId}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer pId){
		String status= productService.deleteById(pId);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}

}
