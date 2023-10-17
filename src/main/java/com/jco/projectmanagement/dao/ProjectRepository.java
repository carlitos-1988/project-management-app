package com.jco.projectmanagement.dao;

import com.jco.projectmanagement.enteties.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project,Long> {


    //overriding to get rid of the default iterable return type
    @Override
    public List<Project> findAll();
}
