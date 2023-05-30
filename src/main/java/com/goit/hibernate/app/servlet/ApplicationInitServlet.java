package com.goit.hibernate.app.servlet;

import com.goit.hibernate.app.configuration.LoggingConfiguration;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.http.HttpServlet;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApplicationInitServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) {
        log.info("Started configuration init");
        LoggingConfiguration.setup();
        log.info("Configuration init finished");
    }
}
