package com.lt.logger.service.layout;

import com.lt.logger.model.LoggingEvent;

public interface Layout {

    /**
     * Transform an event (of the type LoggingEvent) and return it as a String after
     * appropriate formatting.
     *
     * @param event The event to format
     * @return the event formatted as a String
     */
    String doLayout(LoggingEvent event);
}
