package com.hrms.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="job_adverties")

public class JobAdvert {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="min_salary")
	private int minSalary;
	
	@Column(name="job_definition")
	private String jobDefinition;
	
	@Column(name="number_of_open_definition")
	private int numberOfOpenPosition;

	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name="release_date")
	private LocalDate releaseDate;
	
	@Column(name="expiration_date")
	private LocalDate expirationDate;
	
	@ManyToOne()
    @JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne()
    @JoinColumn(name = "user_id")
    private Employer employer;

    @ManyToOne()
    @JoinColumn(name = "id")
    private JobPosition jobPosition;

	
	
}
