package br.com.erudio.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.mapper.DozerMapper;
import br.com.erudio.mapper.custom.PersonMapper;
import br.com.erudio.modal.Person;
import br.com.erudio.repositories.PersonRepository;

@Service
public class PersonService {

	private Logger logger = Logger.getLogger(PersonService.class.getName());
	@Autowired
	private PersonRepository repository;
	
	@Autowired
	PersonMapper mapper;
	
	public List<PersonVO>  findAll() {
		logger.info("Finding all people!");
		
		return DozerMapper.parseObject(repository.findAll(), PersonVO.class)  ;
	}	
		
	

	public PersonVO findById(long id) {

		logger.info("Finding one person!");
		
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		return DozerMapper.parseObject(entity, PersonVO.class);
	}
	
	public PersonVO create(PersonVO person) {

		logger.info("Create one PersonVO!");
		
		var entity = DozerMapper.parseObject(person, Person.class);
		var entityVO = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		return entityVO;
	}	
	public PersonVOV2 createV2(PersonVOV2 person) {
		
		logger.info("Create one PersonVO with V2!");
		var entity = mapper.convertVoToEntity(person);
		var entityVO = mapper.convertEntityToVo(repository.save(entity));
		return entityVO;
	}	
	public PersonVO update(PersonVO person) {
		var entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		var entityVO = DozerMapper.parseObject(repository.save(entity), PersonVO.class);

		logger.info("Update one PersonVO!");
		return entityVO;
	}	

	public void delete(Long id) {
		
		logger.info("Deleting one PersonVO!");
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		repository.delete(entity);
	}	
	
	

}
