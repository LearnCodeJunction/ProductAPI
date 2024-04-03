package com.phonebook.service;

import java.util.List;

import com.phonebook.model.PhoneBook;

public interface PhonebookService {
	// save 
	public String upsert(PhoneBook phoneBook);
	// get
	public List<PhoneBook> fetchContact();
	
	// find by Id
	public PhoneBook getById(Integer pId);
	
	// update
	public String updateContact(PhoneBook phoneBook);
	
	// find by Name
	public List<PhoneBook> findAllContactName(String name);
	
	
	public String deleteById(Integer pId);

}
