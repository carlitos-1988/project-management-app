package com.jco.projectmanagement.controllers;

import com.jco.projectmanagement.dao.ProjectRepository;
import com.jco.projectmanagement.enteties.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("projects")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/new")
    public String displayProjectForm(Model m){
        Project aProject = new Project();
        m.addAttribute("project", aProject );
        return "projects/new-project.html";
    }

    @GetMapping("/show")
    public String displayEmployees(Model m){
        List<Project> projectList = projectRepository.findAll();
        m.addAttribute("projectList", projectList);
        return "projects/list-projects.html";
    }

    @PostMapping("/save")
    public String createProject(Model m, Project project){
        //will handle saving to the database
        projectRepository.save(project);
        return "redirect:/projects/new";
    }
}
