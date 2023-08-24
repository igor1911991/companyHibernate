package com.example.companyHibernate.service;

import com.example.companyHibernate.dao.RoleDao;
import com.example.companyHibernate.domain.Employee;
import com.example.companyHibernate.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Long addRole(Role role) {
        return roleDao.addRole(role);
    }

    @Override
    public List<Role> listRole() {
        return roleDao.listRole();
    }

    @Override
    public void changeRole(Role role) {
        roleDao.changeRole(role);
    }

    @Override
    public void removeRole(Long id) {
        roleDao.removeRole(id);
    }

    @Override
    public List<Employee> listEmployee(String roleName) {
        return roleDao.listEmployee(roleName);
    }
}
