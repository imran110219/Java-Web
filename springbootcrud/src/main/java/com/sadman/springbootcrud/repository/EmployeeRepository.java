package com.sadman.springbootcrud.repository;

import org.springframework.data.repository.CrudRepository;
import com.sadman.springbootcrud.model.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
