package com.example.jetbrainstest;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class CodeCanvasExtension implements AfterTestExecutionCallback {
    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        if (extensionContext.getExecutionException().isPresent()) CodeCanvasAttachManager.screenshot();
    }
}