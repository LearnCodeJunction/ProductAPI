package com.phonebook.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonebook.model.PhoneBook;
import com.phonebook.repository.PhoneBookRepo;
import com.phonebook.service.PhonebookService;

@Service
public class PhoneBookImp implements PhonebookService {
	
	@Autowired
	private PhoneBookRepo phoneBookRepo;

	// Add Contact in Contact Number
	@Override
	public String upsert(PhoneBook phoneBook) {
		long pId = phoneBookRepo.save(phoneBook).getPhoneNumber();
		System.out.println(phoneBook.getPhoneNumber());
		System.out.println(phoneBook);
		return "Successfully Added to Contact Number .  "+pId;
	}
	
	// get All Contact Number
	@Override
	public List<PhoneBook> fetchContact() {
		List<PhoneBook> list=phoneBookRepo.findAll();
		System.out.println(list);
		list.sort((p1,p2)->p1.getPId().compareTo(p2.getPId()));
		return list;
	}
	
   // Find By Id
	@Override
	public PhoneBook getById(Integer pId) {
		Optional<PhoneBook> findById = phoneBookRepo.findById(pId);
		if (findById.isPresent()) {
			return findById.get();
		}else {
		
		return	findById.orElseThrow(()->new RuntimeException("Phone Number Not Found"));
		  //throw new RuntimeException("id not fond");
		}
	}
	

	@Override
	public String updateContact(PhoneBook phoneBook) {
		Optional<PhoneBook> optional = phoneBookRepo.findById(phoneBook.getPId());
		if (optional.isPresent()) {
			phoneBookRepo.save(phoneBook);
			return phoneBook.getPId()+"  Phone Number is Update Success";
		} else {
			return  phoneBook.getPId()+"  Phone Number Not Found ";
		}
		
	}

	@Override
	public List<PhoneBook> findAllContactName(String name) {
			return phoneBookRepo.findBypName(name);
		
	}

	@Override
	public String deleteById(Integer pId) {
		if (phoneBookRepo.existsById(pId)) {
			phoneBookRepo.deleteById(pId);
			return "Phone Number is Deleted Success "+pId;
		} else {
			return "Number is Not Found "+pId;
		}
		
	}
	

	
}
