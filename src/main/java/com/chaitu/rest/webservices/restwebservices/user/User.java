package com.chaitu.rest.webservices.restwebservices.user;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {
	private Integer id;
	@Size(min=2,message="Name should have atleast 2 characters")
	private String name;
	@Past(message="Birth date should be past")
	private LocalDate Birthdate;
	public User(int id, String name, LocalDate birthdate) {
		super();
		this.id = id;
		this.name = name;
		Birthdate = birthdate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthdate() {
		return Birthdate;
	}
	public void setBirthdate(LocalDate birthdate) {
		Birthdate = birthdate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", Birthdate=" + Birthdate + "]";
	}
	
	
	

}
