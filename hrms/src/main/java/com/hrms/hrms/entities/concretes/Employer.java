package com.hrms.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "employer_users")
@PrimaryKeyJoinColumn(name = "user_id")
public class Employer extends User {

	@NotBlank(message = "Şirket İsmi Alanı Boş Geçilemez.")
	@Column(name = "company_name")
	private String companyName;
	
	@NotBlank(message = "Web Sitesi Alanı Boş Geçilemez.")
	@Column(name = "web_address")
	private String webAdress;

	@NotBlank(message = "Telefon Numarası Alanı Boş Olamaz.")
	@Size(min=11,max=11, message="11 Haneli Telefon Girilmeli.")
	@Column(name = "phone_number")
	private String phoneNumber;
	
    @OneToMany(mappedBy = "employer")
    private List<JobAdvert> jobAdvert;

}
