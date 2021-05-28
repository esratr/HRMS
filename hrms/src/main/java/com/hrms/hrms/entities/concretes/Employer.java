package com.hrms.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@Data
@Entity
@Table(name="employer_users")

public class Employer extends User {
	

			@Id
			@Column(name="company_name")
			private String companyName;
			
			@Column(name="web_address")
			private String webAdress;
			
			@Column(name="phone_number")
			private String phoneNumber;
			
			

}
