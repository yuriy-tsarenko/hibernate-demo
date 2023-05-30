package com.goit.hibernate.app.repository;

import com.goit.hibernate.app.configuration.hibernate.Datasource;
import com.goit.hibernate.app.entity.CustomerEntity;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

@Slf4j
public class CustomerEntityRepository {

    private final Datasource datasource;

    public CustomerEntityRepository(Datasource datasource) {
        this.datasource = datasource;
    }

    public List<CustomerEntity> findAll() {
        try (Session session = datasource.openSession()) {
            Query<CustomerEntity> sessionQuery = session.createQuery("select c from CustomerEntity c", CustomerEntity.class);
            log.info("QUERY:{}", sessionQuery);
            return sessionQuery.getResultList();
        } catch (Exception e) {
            log.error("findAll", e);
            throw new RuntimeException(e);
        }
    }
}
