package com.example.jetbrainstest;

import io.qameta.allure.Step;
import org.slf4j.Logger;

public class CodeCanvasLogger {
    private final Logger logger;

    public CodeCanvasLogger(Logger logger) {
        this.logger = logger;
    }

    @Step("{logText}")
    public void info(String logText) {
        logger.info(logText);
    }

    @Step("{logText}")
    public void infoWithScreenshot(String logText) {
        logger.info(logText);
        CodeCanvasAttachManager.screenshot();
    }
}