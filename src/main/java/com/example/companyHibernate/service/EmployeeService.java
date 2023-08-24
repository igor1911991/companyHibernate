package com.example.companyHibernate.service;

import com.example.companyHibernate.domain.Employee;
import com.example.companyHibernate.domain.Project;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);
    Employee getEmployee(Long id);
    List<Employee> listEmployees();
    void changeEmployee(Employee employee);
    void removeEmployee(Long id);
    List<Project> listProjects(Long employee_id);

}
