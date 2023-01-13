package br.com.erudio.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.modal.Person;

@Service
public class PersonMapper {
	public PersonVOV2 convertEntityToVo(Person person) {
		PersonVOV2 vo = new PersonVOV2();
		vo.setId(person.getId());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setBrirthday(new Date());
		vo.setAddress(person.getAddress());
		vo.setGender(person.getGender());
		return vo;
		
	}
	public Person convertVoToEntity(PersonVOV2 person) {
		Person entity = new Person();
		entity.setId(person.getId());
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		//entity.setBrirthday(new Date());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		return entity;
		
	}
	

}
