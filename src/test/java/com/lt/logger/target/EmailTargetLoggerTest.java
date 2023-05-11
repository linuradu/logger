package com.lt.logger.target;

import com.lt.logger.model.Level;
import com.lt.logger.model.LoggingEvent;
import com.lt.logger.service.layout.EchoLayout;
import com.lt.logger.service.target.EmailTargetLogger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static com.lt.logger.model.Level.INFO;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmailTargetLoggerTest {

    private static final String FORMATTED_EVENT = "Formatted event";

    @Mock
    private EchoLayout echoLayout;

    @InjectMocks
    private EmailTargetLogger onTest;

    @BeforeEach
    public void setUp() {
        ReflectionTestUtils.setField(onTest, "emailLoggerLevel", INFO);
    }

    @Test
    void log_minimumLevelInfo_logInfo() {
        var event = LoggingEvent.builder()
                .timestamp(System.currentTimeMillis())
                .threadName("main")
                .level(Level.INFO)
                .className(this.getClass().getName())
                .message("Testing log with minimum log level")
                .build();
        when(echoLayout.doLayout(event)).thenReturn(FORMATTED_EVENT);

        onTest.log(event);

        verify(echoLayout).doLayout(event);
    }

    @Test
    void log_minimumLevelInfo_shouldNotLogDebug() {
        var event = LoggingEvent.builder()
                .timestamp(System.currentTimeMillis())
                .threadName("main")
                .level(Level.DEBUG)
                .className(this.getClass().getName())
                .message("Testing log with minimum log level")
                .build();

        onTest.log(event);

        verify(echoLayout, never()).doLayout(event);
    }
}
