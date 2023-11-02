package com.jco.projectmanagement.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jco.projectmanagement.dao.EmployeeRepository;
import com.jco.projectmanagement.dao.ProjectRepository;
import com.jco.projectmanagement.dto.ChartDataStatus;
import com.jco.projectmanagement.dto.EmployeeProject;
import com.jco.projectmanagement.enteties.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String displayHome(Model m) throws JsonProcessingException {
        //all queries for database and DTO custom query
        List<Project> projects =  projectRepository.findAll();
        List<EmployeeProject> employeesProjectCount = employeeRepository.employeeProjects();
        List<ChartDataStatus> projectData= projectRepository.getProjectStatus();

        //Modifying projectData variable so that it can be used by JS
        Map<String, Objects> map = new HashMap<>();
        //Convert project Data object into a json structure
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectData);


        m.addAttribute("projectStatusCnt", jsonString);
        m.addAttribute("projectsList", projects);
        m.addAttribute("employeeList", employeesProjectCount);

        return "main/home.html";
    }

}
