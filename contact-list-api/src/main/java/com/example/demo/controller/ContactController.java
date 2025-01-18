package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ContactDTO;
import com.example.demo.entity.Contact;
import com.example.demo.service.ContactService;

@CrossOrigin
@RequestMapping("/api/contacts")
@RestController
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@GetMapping
	Iterable<Contact> list(){
		return contactService.findAll();
	}
	
	@GetMapping("{id}")
	public Contact get(@PathVariable("id") Integer id) {
		return contactService.findById(id);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Contact create (@Validated @RequestBody ContactDTO contactDTO) {
		return contactService.create(contactDTO);
	}
	
	@PutMapping("{id}")
	public Contact update (@PathVariable("id") Integer id,							
			@Validated @RequestBody ContactDTO contactDTO) {
				
		return contactService.update(id,contactDTO);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}")
	public void delete (@PathVariable("id") Integer id) {
	
		contactService.delete(id);
	}
	
}

