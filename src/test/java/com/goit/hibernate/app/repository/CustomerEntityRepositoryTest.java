package com.goit.hibernate.app.repository;

import com.goit.hibernate.app.configuration.Environment;
import com.goit.hibernate.app.configuration.LoggingConfiguration;
import com.goit.hibernate.app.configuration.hibernate.Datasource;
import com.goit.hibernate.app.entity.CustomerEntity;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class CustomerEntityRepositoryTest {

    @Test
    void findAll() throws IOException, SQLException {
        //Given
        final int expectedSize = 3;
        Environment environment = Environment.load();
        LoggingConfiguration.setup(environment);
        Datasource datasource = new Datasource(environment);
        CustomerEntityRepository repository = new CustomerEntityRepository(datasource);

        //When
        List<CustomerEntity> all = repository.findAll();

        //Then
        assertFalse(all.isEmpty());
        assertEquals(expectedSize, all.size());
    }
}