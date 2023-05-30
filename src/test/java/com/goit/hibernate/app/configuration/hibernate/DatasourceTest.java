package com.goit.hibernate.app.configuration.hibernate;

import com.goit.hibernate.app.configuration.Environment;
import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DatasourceTest {

    @Test
    void openSession() {
        //Given
        Datasource datasource = new Datasource(Environment.load());

        //When
        Session session = datasource.openSession();

        //Then
        Assertions.assertTrue(session.isOpen());

        session.close();
    }
}