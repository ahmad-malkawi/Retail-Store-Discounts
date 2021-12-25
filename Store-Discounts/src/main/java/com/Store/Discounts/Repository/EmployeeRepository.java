package com.Store.Discounts.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Store.Discounts.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
