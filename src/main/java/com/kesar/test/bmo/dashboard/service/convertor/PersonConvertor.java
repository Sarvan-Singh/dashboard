package com.kesar.test.bmo.dashboard.service.convertor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.kesar.test.bmo.dashboard.data.domain.Person;
import com.kesar.test.bmo.dashboard.service.model.PersonDto;
/**
 * 
 * @author Kesar.Singh
 *	utility class to convert the entity object to dto object to be passed back to frontend
 */
public final class PersonConvertor {

	private PersonConvertor() {
		//
	}

	public static PersonDto toDto(Person people) {
		PersonDto dto = new PersonDto();
		dto.setPersonId(people.getId());
		dto.setFirstName(people.getFirstName());
		dto.setLastName(people.getLastName());
		return dto;
	}

	public static List<PersonDto> toDtos(List<Person> people) {
		return people.stream() //
				.map(PersonConvertor::toDto) //
				.collect(Collectors.toList()) //
		;
	}

	public static Page<PersonDto> toDtos(Page<Person> people) {
		List<PersonDto> list = people.getContent().stream() //
				.map(PersonConvertor::toDto) //
				.collect(Collectors.toList()) //
		;
		return new PageImpl<>(list, people.getPageable(), people.getTotalElements());
	}

}
