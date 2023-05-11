package com.lt.logger.model;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class LoggingEvent {
    Long timestamp;
    String threadName;
    Level level;
    String className;
    String message;
}
