package com.product.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Product_Stock")
@Entity
public class Product_Enitiy {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
    
	
	@Column(name = "Product_ID",length = 15)
	private Integer pId;
	
	@Column(name = "Product_Name",length = 30)
	private String pName;
	
	@Column(name = "Product_Type",length = 15)
	private String pType;
	
	@Column(name = "Product_Proce")
	private Integer pPrice;
	
	@Column(name = "Totel_Count",length = 10)
	private Integer pTotelCount;
	
	@Column(name = "Product_Brand",length = 10)
	private String pCompanyName;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "CREARE_DATE",updatable = false)
	private Date createdate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "Update_Date",insertable = false)
	private Date updatedate;

}
