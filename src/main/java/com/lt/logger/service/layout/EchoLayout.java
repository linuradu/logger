package com.lt.logger.service.layout;

import com.lt.logger.model.LoggingEvent;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.StringJoiner;

import static java.lang.String.format;

@Component
public class EchoLayout implements Layout {

    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
            .withZone(ZoneId.systemDefault());

    @Override
    public String doLayout(LoggingEvent event) {
        final StringJoiner joiner = new StringJoiner(" ");
        joiner.add(timeFormatter.format(Instant.ofEpochMilli(event.getTimestamp())));
        joiner.add(format("[%s]", event.getThreadName()));
        joiner.add(event.getLevel().getName());
        joiner.add(event.getClassName());
        joiner.add(event.getMessage());
        joiner.add(System.lineSeparator());

        return joiner.toString();
    }
}
