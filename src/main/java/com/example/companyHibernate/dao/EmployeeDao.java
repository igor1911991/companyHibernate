package com.example.companyHibernate.dao;

import com.example.companyHibernate.domain.Employee;
import com.example.companyHibernate.domain.Project;

import java.util.List;

public interface EmployeeDao {

    void addEmployee(Employee employee);
    Employee getEmployee(Long id);
    List<Employee> listEmployees();
    void changeEmployee(Employee employee);
    void removeEmployee(Long id);
    List<Project> listProjects(Long employee_id);
}
