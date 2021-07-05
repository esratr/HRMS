package com.hrms.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="companies")
public class Company {
	@Id
	@GeneratedValue
	private int id;
	
	@NotBlank(message="İsim Alanı Boş Geçilemez.")
	@Column(name="company_name")
	private String companyName;
	
	@NotBlank(message="Websitesi Alanı Boş Geçilemez.")
	@Column(name="company_website")
	private String companyWebAddress;

}
