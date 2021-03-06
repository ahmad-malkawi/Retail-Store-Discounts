package com.Store.Discounts.services;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Store.Discounts.Repository.PersonRepository;
import com.Store.Discounts.model.Employee;
import com.Store.Discounts.model.Person;

import enums.PersonType;

@Service
public class PersonService {
	private final PersonRepository personRepo;

	@Autowired
	public PersonService(PersonRepository personRepo) {
		this.personRepo = personRepo;
	}

	public Person addPerson(Person person) {
		return personRepo.save(person);
	}

	public List<Person> findAllPersons() {
		return personRepo.findAll();
	}

	public Person upDatePerson(Person person) {
		return personRepo.save(person);
	}

	public void deletePerson(Long id) {
		personRepo.deleteById(id);
	}

	public Person findPersonById(Long id) {
		return personRepo.getById(id);
	}

	public Person findPersonByPhone(String phone) {
		return personRepo.getByPhone(phone);
	}

	public Person getOrCreatePersonByPhone(String phone) {
		Person person=null;

			
			person = personRepo.getByPhone(phone);
			
			if(person==null) {
				person = personRepo.save(new Person(phone));								
			} 

		return person;
	}

	public static PersonType getPersonType(Person person) {
		
		if(iSEmployee(person)) {
			return PersonType.employee;
		}else if(!person.getBills().isEmpty()) {
			return PersonType.customer;
		}
		return PersonType.New_customer;
	}

	private static boolean iSEmployee(Person person) {
		Set<Employee> employees = person.getEmployees();
		for(Employee employee:employees) {
			if(employee.getEndDate() == null) {
				return true;
			}
		}
		return false;
	}
}
