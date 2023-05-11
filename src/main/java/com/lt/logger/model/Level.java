package com.lt.logger.model;

import lombok.Getter;

@Getter
public enum Level {
    DEBUG("DEBUG", 1000),
    INFO("INFO", 2000),
    WARN("WARN", 3000),
    ERROR("ERROR", 4000);

    Level(String name, int intValue) {
        this.name = name;
        this.intValue = intValue;
    }

    final String name;
    final int intValue;
}
