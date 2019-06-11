package com.kesar.test.bmo.dashboard.data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kesar.test.bmo.dashboard.data.domain.Person;
/**
 * 
 * @author Kesar.Singh
 *	Interface to allow the service retrieve data from a repository (simple strings list in this case, but can be easily 
 *	converted to use a DOA/ORM framework like JDBC/Hibernate Template.
 */
public interface PersonRepository {

	Page<Person> findAll(Pageable page);

	Page<Person> findByFirstNameOrLastNameIgnoreCase(String name, Pageable page);

}
