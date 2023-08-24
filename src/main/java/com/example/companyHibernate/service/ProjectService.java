package com.example.companyHibernate.service;

import com.example.companyHibernate.domain.Employee;
import com.example.companyHibernate.domain.Project;

import java.util.List;

public interface ProjectService {

    Long addProject(Project project);
    List<Project> listProject();
    void changeProject(Project project);
    void removeProject(Long id);
    List<Employee> listEmployees(String projectName);
}
