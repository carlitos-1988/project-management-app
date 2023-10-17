package com.jco.projectmanagement.controllers;

import com.jco.projectmanagement.dao.EmployeeRepository;
import com.jco.projectmanagement.dao.ProjectRepository;
import com.jco.projectmanagement.enteties.Employee;
import com.jco.projectmanagement.enteties.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String displayHome(Model m){
        List<Project> projects =  projectRepository.findAll();
        List<Employee> employeeList = employeeRepository.findAll();

        m.addAttribute("projectsList", projects);
        m.addAttribute("employeeList", employeeList);

        return "home.html";
    }
//minor change
}
