package com.example.companyHibernate.dao;

import com.example.companyHibernate.domain.Employee;
import com.example.companyHibernate.domain.Project;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDaoImpl implements ProjectDao {


    @Override
    public Long addProject(Project project) {

        try(Session session = ConnectionBuilder.getSession()) {

            session.getTransaction().begin();
            session.save(project);
            session.getTransaction().commit();
        }
        return null;
    }

    @Override
    public List<Project> listProject() {

        List<Project> projects;
        try(Session session = ConnectionBuilder.getSession()) {

            String query = "FROM Project";
            session.getTransaction().begin();
            projects = session.createQuery(query, Project.class).getResultList();
            session.getTransaction().commit();
        }
        return projects;
    }

    @Override
    public void changeProject(Project project) {

        try(Session session = ConnectionBuilder.getSession()) {

            session.getTransaction().begin();
            session.merge(project);
            session.getTransaction().commit();
        }
    }

    @Override
    public void removeProject(Long id) {

        try(Session session = ConnectionBuilder.getSession()) {

            session.getTransaction().begin();
            Project project = session.get(Project.class, id);
            if (project == null) {
                session.getTransaction().begin();
            } else {
                session.remove(project);
                session.getTransaction().commit();
            }
        }
    }

    @Override
    public List<Employee> listEmployees(String projectName) {

        List<Employee> employees;
        try(Session session = ConnectionBuilder.getSession()) {

            String query = "select e from Employee e join e.projects p where p.name = :projectName";
            session.getTransaction().begin();
            employees = session.createQuery(query, Employee.class).setParameter("projectName", projectName).getResultList();
            session.getTransaction().commit();
        }
        return employees;
    }
}
