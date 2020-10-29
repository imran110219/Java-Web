package com.sadman.springbootmssql.repository;

import com.sadman.springbootmssql.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sadman
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
