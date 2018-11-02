package com.da2win.springbootlesson16.log4j;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Log4j Test
 */
public class Log4jTest {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Log4jTest.class.getName());

        logger.setLevel(Level.WARN);

        logger.info("Hello, World");
    }
}

