package com.hrms.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@Data
@Entity
@Table(name="staff_users")
@PrimaryKeyJoinColumn(name = "user_id")
public class Staff extends User {

			@NotBlank(message = "Personel ismi alanı boş olamaz.")
			@Column(name="name")
			private String name;
			
			@NotBlank(message = "Personel soyismi alanı boş olamaz.")
			@Column(name="surname")
			private String surname;
			
			

}
