package com.kesar.test.bmo.dashboard.data.repository;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.kesar.test.bmo.dashboard.data.domain.Person;
/**
 * 
 * @author Kesar.Singh
 *	Implementation of repository interface 
 *
 * 	We DON'T need the SAMPLE_DATA list of string arrays if we have proper DataSource connected to a JDBC/ORM(Hibernate) template
 *
 */
@Component
public class PersonRepositoryImpl implements PersonRepository {

	private static final List<String[]> SAMPLE_DATA = Arrays.asList( //
			new String[] { "Arthur", "Brumfield" }, //
			new String[] { "Karlyn", "Derry" }, //
			new String[] { "Renaldo", "Maldonado" }, //
			new String[] { "Enriqueta", "Donlon" }, //
			new String[] { "Kira", "Niver" }, //
			new String[] { "Elvie", "Jelley" }, //
			new String[] { "Ione", "Mathes" }, //
			new String[] { "Jeanetta", "Ellwood" }, //
			new String[] { "Rikki", "Labrecque" }, //
			new String[] { "Florentina", "Mehl" }, //
			new String[] { "Kristan", "Crutchfield" }, //
			new String[] { "Jacelyn", "Knox" }, //
			new String[] { "Mariela", "Bunger" }, //
			new String[] { "Yuonne", "Thill" }, //
			new String[] { "Ivelisse", "Gohr" }, //
			new String[] { "Oleta", "Mellon" }, //
			new String[] { "Catharine", "Provo" }, //
			new String[] { "Ramona", "Harriger" }, //
			new String[] { "Mika", "Elsner" }, //
			new String[] { "Edgardo", "Stmartin" }, //
			new String[] { "Floretta", "Deming" }, //
			new String[] { "Heather", "Goh" }, //
			new String[] { "Klara", "Loach" }, //
			new String[] { "Larita", "Rosenberg" }, //
			new String[] { "Elias", "Northern" }, //
			new String[] { "Liana", "Reda" }, //
			new String[] { "Hester", "Gilcrease" }, //
			new String[] { "Brooke", "Addy" }, //
			new String[] { "Zoe", "Laury" }, //
			new String[] { "Nohemi", "Herrman" }, //
			new String[] { "Damaris", "Fansler" }, //
			new String[] { "Melani", "Menjivar" }, //
			new String[] { "Davis", "Ramey" }, //
			new String[] { "Theresia", "Ortman" }, //
			new String[] { "Titus", "Steigerwald" }, //
			new String[] { "Audra", "Borgia" }, //
			new String[] { "Stuart", "Bennette" }, //
			new String[] { "Ulrike", "Nesbitt" }, //
			new String[] { "Gia", "Askins" }, //
			new String[] { "Nena", "Savala" }, //
			new String[] { "Corrin", "Faircloth" }, //
			new String[] { "Yee", "Schrum" }, //
			new String[] { "Agatha", "League" }, //
			new String[] { "Chassidy", "Mcgrath" }, //
			new String[] { "Della", "Such" }, //
			new String[] { "Jerrold", "Hosier" }, //
			new String[] { "Jackson", "Claxton" }, //
			new String[] { "Donovan", "Dubreuil" }, //
			new String[] { "Georgina", "Mera" }, //
			new String[] { "Lyle", "Hamid" }, //
			new String[] { "Shira", "Lindgren" }, //
			new String[] { "Lucia", "Brockwell" }, //
			new String[] { "Kiley", "Behne" }, //
			new String[] { "Dia", "Lyford" }, //
			new String[] { "Carylon", "Clarke" }, //
			new String[] { "Tenesha", "Wick" }, //
			new String[] { "Rutha", "Faucher" }, //
			new String[] { "Brooks", "Breland" }, //
			new String[] { "Adolfo", "Larimore" }, //
			new String[] { "Clifford", "Facemire" }, //
			new String[] { "Phyllis", "Certain" }, //
			new String[] { "Chun", "Shaffer" }, //
			new String[] { "Justa", "Sosa" }, //
			new String[] { "Bebe", "Chavarin" }, //
			new String[] { "Bailey", "Favero" }, //
			new String[] { "Kathern", "Porco" }, //
			new String[] { "Raymon", "Josephs" }, //
			new String[] { "Tammie", "Cutshall" }, //
			new String[] { "Velva", "Bramer" }, //
			new String[] { "Juli", "Smithson" }, //
			new String[] { "Meridith", "Calvert" }, //
			new String[] { "Karena", "Barile" }, //
			new String[] { "Adelle", "Burgin" }, //
			new String[] { "Freida", "Riche" }, //
			new String[] { "Shay", "Peper" }, //
			new String[] { "Sharron", "Kube" }, //
			new String[] { "Mara", "Mcguinness" }, //
			new String[] { "Dalton", "Milbourn" }, //
			new String[] { "Marissa", "Gran" }, //
			new String[] { "Donte", "Zellmer" }, //
			new String[] { "Tarah", "Shields" }, //
			new String[] { "Chantell", "Rippy" }, //
			new String[] { "Karan", "Whitehurst" }, //
			new String[] { "Kerrie", "Broaden" }, //
			new String[] { "Pete", "Weiss" }, //
			new String[] { "Aundrea", "Edward" }, //
			new String[] { "Loraine", "Montesinos" }, //
			new String[] { "Thomas", "Gothard" }, //
			new String[] { "Cordell", "Galaviz" }, //
			new String[] { "Esther", "Karner" }, //
			new String[] { "Brinda", "Blagg" }, //
			new String[] { "Dannie", "Hirth" }, //
			new String[] { "Francesca", "Cranfill" }, //
			new String[] { "Jessika", "Godsey" }, //
			new String[] { "Maisha", "Li" }, //
			new String[] { "Julia", "Delcid" }, //
			new String[] { "Euna", "Orem" }, //
			new String[] { "Kennith", "Jimison" }, //
			new String[] { "Alix", "Allard" }, //
			new String[] { "Eun", "Demartino" } //
	);
	static {
		SAMPLE_DATA.sort((data1, data2) -> {
			int i = data1[0].compareTo(data2[0]);
			return i == 0 ? data1[1].compareTo(data2[1]) : i;
		});
	}

	@Override
	public Page<Person> findAll(Pageable page) {
		int from = Math.min(SAMPLE_DATA.size(), Math.max(0, (int) page.getOffset()));
		int to = Math.min(SAMPLE_DATA.size(), Math.max(0, from + page.getPageSize()));
		return convert(SAMPLE_DATA.subList(from, to), page);
	}

	@Override
	public Page<Person> findByFirstNameOrLastNameIgnoreCase(String name, Pageable page) {
		final String query = name.toLowerCase(Locale.ENGLISH);
		List<String[]> filtered = SAMPLE_DATA.stream() //
				.filter(data -> {
					String firstName = data[0].toLowerCase(Locale.ENGLISH);
					String lastName = data[1].toLowerCase(Locale.ENGLISH);
					return firstName.contains(query) || lastName.contains(query);
				}) //
				.collect(Collectors.toList()) //
		;
		return convert(filtered, page);
	}

	private Page<Person> convert(List<String[]> personData, Pageable page) {
		List<Person> peopleList = personData.stream() //
				.map(data -> {
					Person people = new Person();
					people.setFirstName(data[0]);
					people.setLastName(data[1]);
					return people;
				}) //
				.collect(Collectors.toList()) //
		;
		return new PageImpl<>(peopleList, page, SAMPLE_DATA.size());
	}

}
