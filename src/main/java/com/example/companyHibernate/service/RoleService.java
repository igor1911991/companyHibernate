package com.example.companyHibernate.service;

import com.example.companyHibernate.domain.Employee;
import com.example.companyHibernate.domain.Role;

import java.util.List;

public interface RoleService {

    Long addRole(Role role);
    List<Role> listRole();
    void changeRole(Role role);
    void removeRole(Long id);
    List<Employee> listEmployee(String roleName);
}
