package com.goit.hibernate.app.configuration.hibernate;

import com.goit.hibernate.app.configuration.Environment;
import jakarta.persistence.Entity;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.reflections.Reflections;

import java.util.Optional;

import static com.goit.hibernate.app.util.Constants.BASE_PACKAGE;

public class HibernateConfiguration {

    public static Configuration setup(Environment environment) {
        Configuration configuration = new Configuration();
        String driverProperty = environment.getProperty(AvailableSettings.DRIVER);
        String urlProperty = environment.getProperty(AvailableSettings.URL);
        String showSqlProperty = environment.getProperty(AvailableSettings.SHOW_SQL);
        String dialectProperty = environment.getProperty(AvailableSettings.DIALECT);
        Optional<String> userProperty = environment.getPropertyOptional(AvailableSettings.USER);
        Optional<String> passwordProperty = environment.getPropertyOptional(AvailableSettings.PASS);

        configuration.setProperty(AvailableSettings.DRIVER, driverProperty);
        configuration.setProperty(AvailableSettings.URL, urlProperty);
        configuration.setProperty(AvailableSettings.SHOW_SQL, showSqlProperty);
        configuration.setProperty(AvailableSettings.DIALECT, dialectProperty);
        userProperty.ifPresent(userName -> configuration.setProperty(AvailableSettings.USER, userName));
        passwordProperty.ifPresent(password -> configuration.setProperty(AvailableSettings.PASS, password));


        Reflections reflections = new Reflections(environment.getProperty(BASE_PACKAGE));
        reflections.getTypesAnnotatedWith(Entity.class).forEach(configuration::addAnnotatedClass);
        return configuration;
    }
}
