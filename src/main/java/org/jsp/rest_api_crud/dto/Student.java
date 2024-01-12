package org.jsp.rest_api_crud.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	String email;
	@Column (unique = true)
	Long phno;
	String address;
	LocalDate dob;
	int age;
	int eng;
	int maths;
	int science;
	double percentage;
	String result;
}
