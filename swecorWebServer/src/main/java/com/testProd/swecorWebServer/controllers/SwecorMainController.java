package com.testProd.swecorWebServer.controllers;

import com.testProd.swecorWebServer.dao.ProjectDAO;
import com.testProd.swecorWebServer.model.Project;
import com.testProd.swecorWebServer.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/swecor")
public class SwecorMainController {

    @Autowired
    private ProjectService ProjectService;

    @GetMapping("/projects")
    public List<Project> showAllProjects(){

        List<Project> allProjects = ProjectService.getAllProjects();

        return allProjects;
    }

}
