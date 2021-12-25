package com.Store.Discounts.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Store.Discounts.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

	Person getByPhone(String phone);

}
