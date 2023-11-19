package logUtill;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ReserveLogger {
    private static ReserveLogger instance;
    private static final Logger logger = Logger.getLogger("MyLogger");
    private static FileHandler fileHandler;

    // Private constructor to prevent external instantiation
    private ReserveLogger() {
        System.out.println("instance success");
        try {
            fileHandler = new FileHandler("C:/Users/User/git/EventPlan_JavaServlet/EventPlan/src/main/webapp/logger/planlogger.log");
            logger.addHandler(fileHandler);
            logger.setLevel(Level.INFO);
            fileHandler.setFormatter(new SimpleFormatter());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Static method to get the single instance of ReserveLogger
    public static ReserveLogger getInstance() {
        if (instance == null) {
            instance = new ReserveLogger();
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
