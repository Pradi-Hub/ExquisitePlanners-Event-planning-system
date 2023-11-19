package com.IT22603418.IT22603418_javaclasses;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class IT22603418_ReserveLogger {
    private static IT22603418_ReserveLogger instance;
    private static final Logger logger = Logger.getLogger("MyLogger");
    private static FileHandler fileHandler;

    // Private constructor to prevent external instantiation
    private IT22603418_ReserveLogger() {
        System.out.println("instance success");
        try {
            fileHandler = new FileHandler("E:/SLIIT/thirdsem/OOP/EventPlan_JavaServlet/EventPlan_JavaServlet/EventPlan/src/main/webapp/IT22603418/IT22603418_logger/Eventlog.log");
            logger.addHandler(fileHandler);
            logger.setLevel(Level.INFO);
            fileHandler.setFormatter(new SimpleFormatter());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Static method to get the single instance of ReserveLogger
    public static IT22603418_ReserveLogger getInstance() {
        if (instance == null) {
            instance = new IT22603418_ReserveLogger();
        }
        return instance;
    }

    public void logInfo(String message) {
        logger.info(message);
    }

    public void logWarning(String message) {
        logger.warning(message);
    }

    public void logExceptionWarning(String message, Exception e) {
        logger.log(Level.WARNING, message, e);
    }
}


