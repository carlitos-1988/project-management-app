package com.jco.projectmanagement.dao;

import com.jco.projectmanagement.enteties.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {


    @Override
    public List<Employee> findAll();
}
