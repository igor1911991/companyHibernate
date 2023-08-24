package com.example.companyHibernate.dao;

import com.example.companyHibernate.domain.Employee;
import com.example.companyHibernate.domain.Role;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {


    @Override
    public Long addRole(Role role) {

        try(Session session = ConnectionBuilder.getSession()) {

            session.getTransaction().begin();
            session.save(role);
            session.getTransaction().commit();
        }
        return null;
    }

    @Override
    public List<Role> listRole() {

        List<Role> roles;
        try(Session session = ConnectionBuilder.getSession()) {

            String query = "FROM Role";
            session.getTransaction().begin();
            roles = session.createQuery(query, Role.class).getResultList();
            session.getTransaction().commit();
        }
        return roles;
    }

    @Override
    public void changeRole(Role role) {

        try(Session session = ConnectionBuilder.getSession()) {

            session.getTransaction().begin();
            session.merge(role);
            session.getTransaction().commit();
        }
    }

    @Override
    public void removeRole(Long id) {

        try(Session session = ConnectionBuilder.getSession()) {

            session.getTransaction().begin();
            Role role = session.get(Role.class, id);
            if (role == null) {
                session.getTransaction().begin();
            } else {
                session.remove(role);
                session.getTransaction().commit();
            }
        }
    }

    @Override
    public List<Employee> listEmployee(String roleName) {

        List<Employee> employees;
        try(Session session = ConnectionBuilder.getSession()) {

            String query = "select e from Employee e join e.role r where r.name = :roleName";
            session.getTransaction().begin();
            employees = session.createQuery(query, Employee.class).setParameter("roleName", roleName).getResultList();
            session.getTransaction().commit();
        }
        return employees;
    }
}
