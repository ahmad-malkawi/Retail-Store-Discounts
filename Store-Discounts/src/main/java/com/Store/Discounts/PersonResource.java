package com.Store.Discounts;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Store.Discounts.model.Person;
import com.Store.Discounts.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonResource {
	private final PersonService personService;

	public PersonResource(PersonService personService) {
		this.personService = personService;
	}

	@GetMapping("All")
	public ResponseEntity<List<Person>> getPersons() {

		List<Person> persons = personService.findAllPersons();
		return new ResponseEntity<>(persons, HttpStatus.OK);

	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable("id") Long id) {

		Person person = personService.findPersonById(id);
		return new ResponseEntity<>(person, HttpStatus.OK);

	}

	@GetMapping("/findByPhone/{phone}")
	public ResponseEntity<Person> getPersonByPhone(@PathVariable("phone") String phone) {

		Person person = personService.findPersonByPhone(phone);
		return new ResponseEntity<>(person, HttpStatus.OK);

	}

	@PostMapping("/add")
	public ResponseEntity<Person> addPerson(@RequestBody Person person) {

		Person newPerson = personService.addPerson(person);
		return new ResponseEntity<>(newPerson, HttpStatus.CREATED);

	}

	@PutMapping("/update")
	public ResponseEntity<Person> updatePerson(@RequestBody Person person) {

		Person newPerson = personService.upDatePerson(person);
		return new ResponseEntity<>(newPerson, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Person> deletePersonById(@PathVariable("id") Long id) {

		personService.deletePerson(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}
}
