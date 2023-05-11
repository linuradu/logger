package com.lt.logger.service.target;

import com.lt.logger.model.Level;
import com.lt.logger.model.LoggingEvent;
import com.lt.logger.service.layout.EchoLayout;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ConsoleTargetLogger implements TargetLogger {

    private static final String CONSOLE = "[Console     ] ";
    @Value("${com.lt.logger.target.console.defaultLevel}")
    private Level consoleLoggerLevel;

    private final EchoLayout echoLayout;

    @Override
    public void log(LoggingEvent event) {
        if (isEventLevelDisapproved(event)) {
            return;
        }

        byte[] byteArray = CONSOLE.concat(echoLayout.doLayout(event)).getBytes();
        System.out.writeBytes(byteArray);
    }

    @Override
    public Level getTagetLoggerLevel() {
        return consoleLoggerLevel;
    }
}
