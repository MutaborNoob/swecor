package com.testProd.swecorWebServer.dao;

import com.testProd.swecorWebServer.model.Project;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectDAO {
    @Query("SELECT p FROM Projects p JOIN FETCH p.devices")
    public List<Project> getAllProjects();
}
