package com.lt.logger.service;

public interface Logger {

    /**
     * Log a message at the DEBUG level
     *
     * @param msg the message string to be logged
     */
    void debug(String msg);

    /**
     * Log a message at the INFO level
     *
     * @param msg the message string to be logged
     */
    void info(String msg);

    /**
     * Log a message at the WARN level
     *
     * @param msg the message string to be logged
     */
    void warn(String msg);

    /**
     * Log a message to ERROR level
     *
     * @param msg the message string to be logged
     */
    void error(String msg);
}
