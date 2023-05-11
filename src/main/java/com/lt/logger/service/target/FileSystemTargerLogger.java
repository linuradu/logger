package com.lt.logger.service.target;

import com.lt.logger.model.Level;
import com.lt.logger.model.LoggingEvent;
import com.lt.logger.service.layout.EchoLayout;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FileSystemTargerLogger implements TargetLogger {

    private static final String FILES_SYSTEM = "[Files-system] ";
    @Value("${com.lt.logger.target.file-system.defaultLevel}")
    private Level fileSystemLoggerLevel;

    private final EchoLayout echoLayout;

    @Override
    public void log(LoggingEvent event) {
        if (isEventLevelDisapproved(event)) {
            return;
        }

        byte[] byteArray = FILES_SYSTEM.concat(echoLayout.doLayout(event)).getBytes();
        System.out.writeBytes(byteArray);
    }

    @Override
    public Level getTagetLoggerLevel() {
        return fileSystemLoggerLevel;
    }
}