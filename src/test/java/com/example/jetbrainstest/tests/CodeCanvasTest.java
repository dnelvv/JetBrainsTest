package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.CodeCanvasExtension;
import com.example.jetbrainstest.pages.CodeCanvasPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@ExtendWith(CodeCanvasExtension.class)
public class CodeCanvasTest extends BaseTest {
    private CodeCanvasPage canvasPage;

    @BeforeEach
    public void setUpEach() {
        getDriver().get("https://www.jetbrains.com/codecanvas/");
        canvasPage = new CodeCanvasPage(getDriver());
        canvasPage.acceptCookie();
    }

    @AfterEach
    public void tearDownEach() {
        super.tearDown();
    }

    @Test
    @DisplayName("Переход на страницу блога с ожиданием URL")
    public void openBlogAndCheckUrl() {
        canvasPage.clickOnBlog();
        String expectedUrl = "https://blog.jetbrains.com/codecanvas/";
        new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(expectedUrl));
        Assertions.assertEquals(expectedUrl, getDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Переход на страницу новостей с ожиданием URL")
    public void openNewsAndCheckUrl() {
        canvasPage.clickOnBlog();
        canvasPage.clickOnNews();
        String expectedUrl = "https://blog.jetbrains.com/codecanvas/category/news/";
        new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(expectedUrl));
        Assertions.assertEquals(expectedUrl, getDriver().getCurrentUrl());
    }
}