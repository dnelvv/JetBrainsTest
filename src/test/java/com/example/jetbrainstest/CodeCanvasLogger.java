package com.example.jetbrainstest;

import io.qameta.allure.Step;
import org.slf4j.Logger;

public class CodeCanvasLogger {
    private Logger logger;

    public CodeCanvasLogger(Logger logger) {
        this.logger = logger;
    }

    @Step("{logtext}")
    public void info(String logtext) {
        logger.info(logtext);
    }
}