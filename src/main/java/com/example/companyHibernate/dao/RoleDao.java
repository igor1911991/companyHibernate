package com.example.companyHibernate.dao;

import com.example.companyHibernate.domain.Employee;
import com.example.companyHibernate.domain.Role;

import java.util.List;

public interface RoleDao {

    Long addRole(Role role);
    List<Role> listRole();
    void changeRole(Role role);
    void removeRole(Long id);
    List<Employee> listEmployee(String roleName);
}
