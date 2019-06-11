package com.kesar.test.bmo.dashboard;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kesar.test.bmo.dashboard.service.PersonService;
import com.kesar.test.bmo.dashboard.service.model.PersonDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DashboardApplicationTests {
	@Autowired
	PersonService personService;
	
	@Test
	public void testSearch() {
		Page<PersonDto> p = personService.search("Jacelyn", PageRequest.of(0,10));
		Assert.assertEquals("Jacelyn", p.getContent().get(0).getFirstName());
	}
	
	@Test
	public void testList() {
		Page<PersonDto> p = personService.list(PageRequest.of(0,10));
		Assert.assertEquals(10, p.getContent().size());
	}
}
