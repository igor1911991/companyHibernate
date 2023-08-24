package com.example.companyHibernate.service;

import com.example.companyHibernate.dao.ProjectDao;
import com.example.companyHibernate.domain.Employee;
import com.example.companyHibernate.domain.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectDao projectDao;

    @Autowired
    public ProjectServiceImpl(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    @Override
    public Long addProject(Project project) {
        return projectDao.addProject(project);
    }

    @Override
    public List<Project> listProject() {
        return projectDao.listProject();
    }

    @Override
    public void changeProject(Project project) {
        projectDao.changeProject(project);
    }

    @Override
    public void removeProject(Long id) {
        projectDao.removeProject(id);
    }

    @Override
    public List<Employee> listEmployees(String projectName) {
        return projectDao.listEmployees(projectName);
    }
}
