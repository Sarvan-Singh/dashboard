package com.kesar.test.bmo.dashboard.web;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kesar.test.bmo.dashboard.service.PersonService;
import com.kesar.test.bmo.dashboard.service.model.PersonDto;
/**
 * 
 * @author Kesar.Singh
 *	Entry point for REST calls
 *	Calls service API to retrieve paged list of persons as well search persons with first/last name
 */
@RestController
@RequestMapping(value = "/person", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PersonController {

	private static final Logger LOGGER = LogManager.getLogger();

	@Autowired
	private PersonService personService;

	@GetMapping("/list")
	public ResponseEntity<PagedResources<Resource<PersonDto>>> list( //
			@PageableDefault Pageable page //
			, PagedResourcesAssembler<PersonDto> assembler //
	) {
		LOGGER.debug("List people. Page: {}", page);
		return new ResponseEntity<>(assembler.toResource(personService.list(page)), HttpStatus.OK);
	}

	@GetMapping("/search")
	public ResponseEntity<PagedResources<Resource<PersonDto>>> search(@RequestParam(value = "query", required = false) String query //
			, @PageableDefault Pageable page //
			, PagedResourcesAssembler<PersonDto> assembler //
	) {
		LOGGER.debug("List people. Query: {}, Page: {}", query, page);
		if (StringUtils.isBlank(query)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(assembler.toResource(personService.search(query, page)), HttpStatus.OK);
	}

}
