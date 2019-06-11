package com.kesar.test.bmo.dashboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kesar.test.bmo.dashboard.data.repository.PersonRepository;
import com.kesar.test.bmo.dashboard.service.convertor.PersonConvertor;
import com.kesar.test.bmo.dashboard.service.model.PersonDto;
/**
 * 
 * @author Kesar.Singh
 *	Person service class to decouple the controller from repository and/or business layer
 */
@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public Page<PersonDto> list(Pageable page) {
		return PersonConvertor.toDtos(personRepository.findAll(page));
	}

	public Page<PersonDto> search(String query, Pageable page) {
		return PersonConvertor.toDtos(personRepository.findByFirstNameOrLastNameIgnoreCase(query, page));
	}

}
