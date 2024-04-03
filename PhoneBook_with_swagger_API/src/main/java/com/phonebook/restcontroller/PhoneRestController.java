package com.phonebook.restcontroller;

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

import com.phonebook.model.PhoneBook;
import com.phonebook.service.PhonebookService;

@RestController
public class PhoneRestController {
	
	@Autowired
	private PhonebookService phonebookService;
	
	// add Product
	@PostMapping("/AddContact")
	public ResponseEntity<String> createProduct(@RequestBody PhoneBook phoneBook){
		System.out.println("Product  "+phoneBook);
		String status = phonebookService.upsert(phoneBook);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	
	// get All Contact Number
	@GetMapping("/AllContact")
	public ResponseEntity<?> showContact(){
		try {
			List<PhoneBook> list = phonebookService.fetchContact();
			return new ResponseEntity<List<PhoneBook>>(list,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return  new ResponseEntity<String>("So Sorry Server Error ",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	// find By Id
	@GetMapping("/phone/{pId}")
	public ResponseEntity<PhoneBook> getPhonenumber(@PathVariable Integer pId){
		PhoneBook phoneBook = phonebookService.getById(pId);
		return new ResponseEntity<>(phoneBook,HttpStatus.OK);
	}
	
	@PutMapping("/updatePhoneNumber")
	public ResponseEntity<String> update(@RequestBody PhoneBook phoneBook){
		try {
			String status =  phonebookService.updateContact(phoneBook);
			return new ResponseEntity<String>(status,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findWithName/{name}")
	public ResponseEntity<?> findByName(@PathVariable ("name") String name){
		try {
			List<PhoneBook> list = phonebookService.findAllContactName(name);
			return new ResponseEntity<List<PhoneBook>>(list,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/phone/{pId}")
	public ResponseEntity<String> deletePhone(@PathVariable Integer pId){
		String status = phonebookService.deleteById(pId);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
	
	/*
	@DeleteMapping("/product/{pId}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer pId){
		String status= productService.deleteById(pId);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
	*/

}
