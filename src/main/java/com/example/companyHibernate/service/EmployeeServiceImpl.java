package com.example.companyHibernate.service;

import com.example.companyHibernate.dao.EmployeeDao;
import com.example.companyHibernate.domain.Employee;
import com.example.companyHibernate.domain.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    @Override
    public Employee getEmployee(Long id) {
        return employeeDao.getEmployee(id);
    }

    @Override
    public List<Employee> listEmployees() {
        return employeeDao.listEmployees();
    }

    @Override
    public void changeEmployee(Employee employee) {
        employeeDao.changeEmployee(employee);
    }

    @Override
    public void removeEmployee(Long id) {
        employeeDao.removeEmployee(id);
    }

    @Override
    public List<Project> listProjects(Long employee_id) {
        return employeeDao.listProjects(employee_id);
    }
}
