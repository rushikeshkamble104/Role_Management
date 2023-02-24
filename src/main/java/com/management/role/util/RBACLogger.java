package com.management.role.util;

import jakarta.inject.Singleton;
import net.logstash.logback.argument.StructuredArguments;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This class is a logger for showing custom logs
 */
@Singleton
public class RBACLogger {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(RBACLogger.class);

    /**
     * This method is used for showing the logs
     */
    public void logs(String className, String methodName, String message) {
        Map<String, String> loggerMap = createLogEntries(className, methodName);
        logger.info(message, StructuredArguments.entries(loggerMap));
    }

    /**
     * This method is used for returning the log map in logs method
     */
    private Map<String, String> createLogEntries(String className, String methodName){
        final Map<String, String> logMap = new LinkedHashMap<>();
        logMap.put("className", className);
        logMap.put("methodName", methodName);
        return logMap;
    }
}
