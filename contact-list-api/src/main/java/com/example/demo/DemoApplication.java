package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Contact;
import com.example.demo.repository.ContactRepository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(ContactRepository contactRepository) {		
		return args ->  {
						
				List<Contact> contacts = Arrays.asList(
						new Contact("carlos","carlos@gamil.com",LocalDateTime.now()),
						new Contact("pedro","pedro@gamil.com",LocalDateTime.now()),
						new Contact("juan","juan@gamil.com",LocalDateTime.now()),
						new Contact("cesar","cesar@gamil.com",LocalDateTime.now())
				);				
				contactRepository.saveAll(contacts);
		};
		
	}	
	
}
