package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ContactDTO {

	//@NotNull(message = "El nombre es obligatorio")
	@NotBlank(message = "El nombre es obligatorio")
	private String name;
	
	//@NotNull(message = "El email es obligatorio")
	@Email(message = "El email es invalido")
	@NotBlank(message = "El email es obligatorio")
	private String email;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
}
