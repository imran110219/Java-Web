package com.sadman.springbootcrud.service;

import com.sadman.springbootcrud.exception.RecordNotFoundException;
import com.sadman.springbootcrud.model.Employee;
import com.sadman.springbootcrud.model.Image;
import com.sadman.springbootcrud.repository.EmployeeRepository;
import com.sadman.springbootcrud.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    @Autowired
    ImageRepository imageRepository;

    public List<Employee> getAllEmployees()
    {
        List<Employee> result = (List<Employee>) repository.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Employee>();
        }
    }

    public Employee getEmployeeById(Long id) throws RecordNotFoundException
    {
        Optional<Employee> employee = repository.findById(id);

        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

    public Employee createOrUpdateEmployee(Employee entity)
    {
        if(entity.getId() == null)
        {
            entity = repository.save(entity);

            return entity;
        }
        else
        {
            Optional<Employee> employee = repository.findById(entity.getId());

            if(employee.isPresent())
            {
                Employee newEntity = employee.get();
                newEntity.setEmail(entity.getEmail());
                newEntity.setFirstName(entity.getFirstName());
                newEntity.setLastName(entity.getLastName());

                newEntity = repository.save(newEntity);

                return newEntity;
            } else {
                entity = repository.save(entity);

                return entity;
            }
        }
    }

    public void deleteEmployeeById(Long id) throws RecordNotFoundException
    {
        Optional<Employee> employee = repository.findById(id);

        if(employee.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

    public int saveImage(Image image) {
        try {
            imageRepository.save(image);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}
