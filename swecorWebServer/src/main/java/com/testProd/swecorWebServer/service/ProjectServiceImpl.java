package com.testProd.swecorWebServer.service;

import com.testProd.swecorWebServer.dao.ProjectDAO;
import com.testProd.swecorWebServer.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectDAO projectDAO;

    @Override
    @Transactional
    public List<Project> getAllProjects() {
        return projectDAO.getAllProjects();
    }
}
