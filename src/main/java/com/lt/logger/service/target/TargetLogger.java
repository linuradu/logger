package com.lt.logger.service.target;

import com.lt.logger.model.Level;
import com.lt.logger.model.LoggingEvent;

public interface TargetLogger {

    /**
     * Log the message to a specific target
     * @param event the logging event with all details
     */
    void log(LoggingEvent event);

    /**
     * Returning if a given level is disapproved for the target logger implementation
     * @param event the logging used to get the level
     * @return if the logging event level is disapproved
     */
    default boolean isEventLevelDisapproved(LoggingEvent event) {
        return event.getLevel().getIntValue() < getTagetLoggerLevel().getIntValue();
    }

    /**
     * Target logger minimum level approved
     * @return the target logger minimum level approved
     */
    Level getTagetLoggerLevel();
}
