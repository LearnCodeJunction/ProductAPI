package com.phonebook.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Phone_Book")
@Entity
public class PhoneBook {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
    
	
	@Column(name = "Contact_id",length = 15)
	private Integer pId;
	
	@Column(name = "Contact_Name",length = 30)
	private String pName;
	
	@Column(name = "Contact_Type",length = 15)
	private String pType;
	
	@Column(name = "Contact_Number",length = 13)
	private Long phoneNumber;
	
	@Column(name = "Contact_Email",length = 20)
	private String contactEmail;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "CREARE_DATE",updatable = false)
	private Date createdate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "Update_Date",insertable = false)
	private Date updatedate;

}
