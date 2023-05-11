package com.lt.logger;

import com.lt.logger.service.LoggerImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoggerDemoTest {

    @Autowired
    private LoggerImpl logger;

    /**
     * The log level configurations are stored to application.properties
     *
     * The minimum log level is DEBUG, and now is logging for all levels, but in case will be changed
     * to something else (as WARN) the logged messages will decrease.
     *
     * For evey log target in the application.properties is defined the minimum level, and based on the defined minimum level
     * is executing the log or not. Once adjusted you can see again that the logs are more/less logged.
     */
    @Test
    public void demo() {
        logger.debug("Test - 1");
        logger.info("Test - 2");
        logger.warn("Test - 3");
        logger.error("Test - 4");
    }
}
