package com.jco.projectmanagement.controllers;

import com.jco.projectmanagement.dao.EmployeeRepository;
import com.jco.projectmanagement.enteties.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/new")
    public String displayEmployeeForm (Model m){
        Employee employee = new Employee();
        m.addAttribute("employee", employee);
        return "new-employee.html";
    }

    @PostMapping("/save")
    public String createEmployee(Model m, Employee employee){
        employeeRepository.save(employee);
        return "redirect:/employees/new";
    }
}
