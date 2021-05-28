package com.hrms.hrms.entities.concretes;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(name="job_positions")


public class JobPosition {
	

	@Id
	@GeneratedValue
	
	@Column(name="id")
	private int id;
	
	@NotBlank(message="İsim Alanı Boş olamaz")
	@Column(name="position")
	private String position;
	


}
