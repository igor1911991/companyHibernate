package com.example.companyHibernate.dao;

import com.example.companyHibernate.domain.Employee;
import com.example.companyHibernate.domain.Project;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public void addEmployee(Employee employee) {

        try(Session session = ConnectionBuilder.getSession()) {

            session.getTransaction().begin();
            session.save(employee);
            session.getTransaction().commit();

        }

    }

    @Override
    public Employee getEmployee(Long id) {
        Employee employee;

        try(Session session = ConnectionBuilder.getSession()) {

            session.getTransaction().begin();
            employee = session.get(Employee.class, id);
            session.getTransaction().commit();
        }
        return employee;
    }

    @Override
    public List<Employee> listEmployees() {

        List<Employee> employees;
        try(Session session = ConnectionBuilder.getSession()) {

            String query = "FROM Employee";
            session.getTransaction().begin();
            employees = session.createQuery(query, Employee.class).getResultList();
            session.getTransaction().commit();
        }

        return employees;
    }

    @Override
    public void changeEmployee(Employee employee) {

        try(Session session = ConnectionBuilder.getSession()) {

            session.getTransaction().begin();
            session.merge(employee);
            session.getTransaction().commit();
        }

    }

    @Override
    public void removeEmployee(Long id) {

        try(Session session = ConnectionBuilder.getSession()) {

            session.getTransaction().begin();
            Employee employee = session.get(Employee.class, id);
            if (employee == null) {
                session.getTransaction().begin();
            } else {
                session.remove(employee);
                session.getTransaction().commit();
            }
        }
    }

    @Override
    public List<Project> listProjects(Long employee_id) {

        List<Project> projects;
        try(Session session = ConnectionBuilder.getSession()) {

            String query = "select p from Project p join p.employees e where e.id = :employeeId";

            session.getTransaction().begin();
            projects = session.createQuery(query, Project.class).setParameter("employeeId", employee_id).getResultList();
            session.getTransaction().commit();
        }
        return projects;
    }
}
