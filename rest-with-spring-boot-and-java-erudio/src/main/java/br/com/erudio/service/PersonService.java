package br.com.erudio.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.modal.Person;
import br.com.erudio.repositories.PersonRepository;

@Service
public class PersonService {

	private Logger logger = Logger.getLogger(PersonService.class.getName());
	@Autowired
	private PersonRepository repository;
	
	public List<Person>  findAll() {
		logger.info("Finding all people!");
		
		return repository.findAll() ;
	}	
		
	

	public Person findById(long id) {

		logger.info("Finding one person!");
		
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
	}
	
	public Person create(Person person) {

		logger.info("Create one person!");
		return repository.save(person);
	}	
	public Person update(Person person) {
		Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		logger.info("Update one person!");
		return repository.save(person);
	}	

	public void delete(Long id) {
		
		logger.info("Deleting one person!");
		Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		repository.delete(entity);
	}	
	
	

}
