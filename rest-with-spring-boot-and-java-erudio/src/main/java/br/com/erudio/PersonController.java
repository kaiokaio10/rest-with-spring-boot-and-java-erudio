package br.com.erudio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.modal.Person;
import br.com.erudio.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService service;
	
	
	
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> FindAll() {
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Person FindById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person Create(@RequestBody Person person) {
		return service.create(person);
	}
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person Update(@RequestBody Person person) {
		return service.update(person);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> Delete(@PathVariable(value = "id") Long id) {
		 service.delete(id);
		 return ResponseEntity.noContent().build();
	}

	
	
}
