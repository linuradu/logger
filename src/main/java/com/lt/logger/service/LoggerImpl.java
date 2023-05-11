package com.lt.logger.service;

import com.lt.logger.model.Level;
import com.lt.logger.model.LoggingEvent;
import com.lt.logger.service.target.TargetLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Set;

import static com.lt.logger.model.Level.DEBUG;
import static com.lt.logger.model.Level.ERROR;
import static com.lt.logger.model.Level.INFO;
import static com.lt.logger.model.Level.WARN;

@RequiredArgsConstructor
@Component
public class LoggerImpl implements Logger {

    @Value("${com.lt.logger.defaultLogLevel}")
    private Level loggingLevel;

    private final Set<TargetLogger> targetLoggers;

    @Override
    public void debug(String msg) {
        filterAndLog(getCallerClassName(), msg, DEBUG);
    }

    @Override
    public void info(String msg) {
        filterAndLog(getCallerClassName(), msg, INFO);
    }

    @Override
    public void warn(String msg) {
        filterAndLog(getCallerClassName(), msg, WARN);
    }

    @Override
    public void error(String msg) {
        filterAndLog(getCallerClassName(), msg, ERROR);
    }

    private void filterAndLog(String className, String msg, Level level) {
        if (level.getIntValue() < loggingLevel.getIntValue()) {
            return;
        }

        var loggingEvent = LoggingEvent.builder()
                .timestamp(System.currentTimeMillis())
                .threadName(Thread.currentThread().getName())
                .className(className)
                .level(level)
                .message(msg)
                .build();

        targetLoggers.forEach(targetLogger -> targetLogger.log(loggingEvent));
    }

    private static String getCallerClassName() {
        return Thread.currentThread().getStackTrace()[3].getClassName();
    }
}
