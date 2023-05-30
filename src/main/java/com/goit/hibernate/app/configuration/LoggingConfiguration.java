package com.goit.hibernate.app.configuration;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import static com.goit.hibernate.app.util.Constants.LOG_ENCODING;
import static com.goit.hibernate.app.util.Constants.LOG_FILE;
import static com.goit.hibernate.app.util.Constants.LOG_LEVEL;
import static com.goit.hibernate.app.util.Constants.LOG_PATTERN;

public class LoggingConfiguration {

    public static void setup() {
        setup(Environment.load());
    }

    public static void setup(Environment environment) {
        try {
            // creates pattern layout
            PatternLayout layout = new PatternLayout();
            layout.setConversionPattern(environment.getProperty(LOG_PATTERN));

            // creates console appender
            ConsoleAppender consoleAppender = new ConsoleAppender();
            consoleAppender.setLayout(layout);
            consoleAppender.setEncoding(environment.getProperty(LOG_ENCODING));
            consoleAppender.activateOptions();

            // creates file appender
            DailyRollingFileAppender rollingFileAppender = new DailyRollingFileAppender();
            rollingFileAppender.setEncoding(environment.getProperty(LOG_ENCODING));
            rollingFileAppender.setFile(environment.getProperty(LOG_FILE));
            rollingFileAppender.setLayout(layout);
            rollingFileAppender.setDatePattern("'.'yyyy-MM-dd");
            rollingFileAppender.activateOptions();

            // configures the root logger
            Logger rootLogger = Logger.getRootLogger();
            rootLogger.setLevel(Level.toLevel(environment.getProperty(LOG_LEVEL)));
            rootLogger.removeAllAppenders();
            rootLogger.addAppender(consoleAppender);
            rootLogger.addAppender(rollingFileAppender);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
