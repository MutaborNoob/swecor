package com.testProd.swecorWebServer.dao;

import com.testProd.swecorWebServer.model.Project;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ProjectDAOImpl implements ProjectDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Project> getAllProjects() {

        Session session = entityManager.unwrap(Session.class);

        List<Project> allProjects = session
                .createQuery("from Project", Project.class)
                .getResultList();

        return allProjects;
    }
}
