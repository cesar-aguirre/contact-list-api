package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ContactDTO;
import com.example.demo.entity.Contact;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ContactRepository;


@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;

	public Iterable<Contact> findAll() {
		return contactRepository.findAll();
	}

	public Contact findById(Integer id) {
		/*return contactRepository
				.findById(id)
				.orElse(null);*/
		
		return contactRepository
				.findById(id)
				.orElseThrow( () -> new ResourceNotFoundException() );
	}

	public Contact create(ContactDTO contactDTO) {
		Contact  contact = new Contact();
		contact.setName(contactDTO.getName());
		contact.setEmail(contactDTO.getEmail());		
		contact.setCreatedAt(LocalDateTime.now());
		return contactRepository.save(contact);
	}

	public Contact update(Integer id, ContactDTO contactDTO) {
		Contact contactFromDb = findById(id);
		contactFromDb.setName(contactDTO.getName());
		contactFromDb.setEmail(contactDTO.getEmail());
		return contactRepository.save(contactFromDb);
	}

	public void delete(Integer id) {
		Contact contactFromDb = findById(id);
		contactRepository.delete(contactFromDb);
	}

}
