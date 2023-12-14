package com.jco.extra;

import com.jco.projectmanagement.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    //Although this class has the correct annotations it wil not be used by Spring as the main application does not know how to use it. Using this section to understand field injection, constructor injection, and setter injection

    //Field injecttion
    @Autowired
    EmployeeRepository employeeRepository;

    //Constructor Injection
//    public EmployeeService(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }

    //Setter Injection
//    @Autowired
//    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }


}
