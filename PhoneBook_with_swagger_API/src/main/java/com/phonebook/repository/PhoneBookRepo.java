package com.phonebook.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.phonebook.model.PhoneBook;

public interface PhoneBookRepo extends JpaRepository<PhoneBook,Serializable> {
	
	
//	@Query("select from Product_Stock where Product_Name =:name")
//	public List<Product_Enitiy> findBypName(String name);4
	
	@Query(" FROM PhoneBook  WHERE pName = :name")
	public List<PhoneBook> findBypName(String name);

	
	//public List<Product_Enitiy> findBypTotelCount(String )

}