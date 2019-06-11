package com.kesar.test.bmo.dashboard.service.model;

import java.util.Objects;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * 
 * @author Kesar.Singh
 *	DTO Object to map data as per frontend requirements (JSON in our case)
 *
 */
@JsonInclude(Include.ALWAYS)
public class PersonDto extends ResourceSupport {
	@JsonProperty("personId")
	private Long personId;
	
	@JsonProperty("firstName")
	private String firstName;
	
	@JsonProperty("lastName")
	private String lastName;

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(personId);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof PersonDto)) {
			return false;
		}
		PersonDto other = (PersonDto) obj;
		return Objects.equals(personId, other.personId);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PeopleDto [personId=").append(personId).append(", firstName=").append(firstName).append(", lastName=").append(lastName).append("]");
		return builder.toString();
	}

}
