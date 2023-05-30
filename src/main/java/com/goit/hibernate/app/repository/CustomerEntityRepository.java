package com.goit.hibernate.app.repository;

import com.goit.hibernate.app.configuration.hibernate.Datasource;
import com.goit.hibernate.app.entity.CustomerEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.intellij.lang.annotations.Language;

import java.util.List;

public class CustomerEntityRepository {

    private final Datasource datasource;

    public CustomerEntityRepository(Datasource datasource) {
        this.datasource = datasource;
    }

    public List<CustomerEntity> findAll() {
        try (Session session = datasource.openSession()) {
            Query<CustomerEntity> sessionQuery = session.createQuery("select c from CustomerEntity c");
            return sessionQuery.getResultList();
        }
    }
}
