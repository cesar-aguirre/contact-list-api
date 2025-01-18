package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Contact;

@RestController
public interface ContactRepository extends CrudRepository<Contact, Integer>{
	
}
