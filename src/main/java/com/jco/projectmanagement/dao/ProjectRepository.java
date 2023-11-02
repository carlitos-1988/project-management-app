package com.jco.projectmanagement.dao;

import com.jco.projectmanagement.dto.ChartDataStatus;
import com.jco.projectmanagement.enteties.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project,Long> {


    //overriding to get rid of the default iterable return type
    @Override
    public List<Project> findAll();

    @Query(nativeQuery = true, value = "SELECT stage as label, count(*) as countOfStatus " +
            "from project " +
            "group by stage")
    public List<ChartDataStatus> getProjectStatus();
}
