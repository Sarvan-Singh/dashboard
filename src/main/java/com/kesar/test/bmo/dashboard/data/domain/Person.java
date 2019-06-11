package com.kesar.test.bmo.dashboard.data.domain;

import java.util.Objects;
/**
 * 
 * @author Kesar.Singh
 *	An Entity class to persist data to a data source
 */
// @Entity
// @Table(name = "PEOPLE")
public class Person {

//	@Id
//	@Column
	private Long id;

//	@Column(name = "FIRST_NAME")
	private String firstName;

//	@Column(name = "LAST_NAME")
	private String lastName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Person)) {
			return false;
		}
		Person other = (Person) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("People [id=").append(id).append(", firstName=").append(firstName).append(", lastName=").append(lastName).append("]");
		return builder.toString();
	}

}
