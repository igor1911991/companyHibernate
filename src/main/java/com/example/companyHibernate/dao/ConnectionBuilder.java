package com.example.companyHibernate.dao;

import java.util.Properties;

import com.example.companyHibernate.domain.Employee;
import com.example.companyHibernate.domain.Project;
import com.example.companyHibernate.domain.Role;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

@Component
public class ConnectionBuilder {

    public static SessionFactory buildSessionFactory() {
        try {

            Properties properties = new Properties();
            properties.put(Environment.DRIVER, "org.postgresql.Driver");
            properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/Company");
            properties.put(Environment.USER, "postgres");
            properties.put(Environment.PASS, "postgres");
            properties.put(Environment.FORMAT_SQL, "true");
            properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
            properties.put(Environment.SHOW_SQL, "true");
            properties.put(Environment.FORMAT_SQL, "true");
            properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
//            properties.put(Environment.HBM2DDL_AUTO, "update");
            properties.put(Environment.POOL_SIZE, "5");

            return new Configuration()
                    .setProperties(properties)
                    .addAnnotatedClass(Employee.class)
                    .addAnnotatedClass(Role.class)
                    .addAnnotatedClass(Project.class)
                    .buildSessionFactory();

        } catch (Throwable ex) {
            System.err.println("build SeesionFactory failed :" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() {
        SessionFactory sessionFactory = ConnectionBuilder.buildSessionFactory();
        Session session = sessionFactory.openSession();
        return session;
    }
}
