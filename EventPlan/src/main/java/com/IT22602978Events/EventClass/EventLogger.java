package com.IT22602978Events.EventClass;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

//Define the EventLogger class
public class EventLogger {
	private static EventLogger instance;
    private static final Logger logger = Logger.getLogger("MyLogger");
    private static FileHandler fileHandler;

 // Private constructor for the EventLogger class
    private EventLogger() {
        System.out.println("instance success");
        try {
        	// Specify the file path for log storage
            fileHandler = new FileHandler("E:/SLIIT/thirdsem/OOP/EventPlan_JavaServlet/EventPlan_JavaServlet/EventPlan/src/main/webapp/DamniduIT22602978/LoggerFile/Eventlog.log");
            logger.addHandler(fileHandler);
            logger.setLevel(Level.INFO);
            fileHandler.setFormatter(new SimpleFormatter());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
 // Method to obtain an instance of the EventLogger class
    public static EventLogger getInstance() {
        if (instance == null) {
            instance = new EventLogger();
        }
        return instance;
    }
 // Method to log information messages
    public  void logInfo(String message) {
        logger.info(message);
    }
    // Method to log warning messages
    public  void logWarning(String message) {
        logger.warning(message);
    }
    
 // Method to log warning messages along with an associated exception
    public  void logExceptionWarning(String message, Exception e) {
        logger.log(Level.WARNING, message, e);
    }


   

}

