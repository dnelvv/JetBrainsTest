package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.pages.CodeCanvasPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.example.jetbrainstest.tests.BaseTest.getDriver;

public class CodeCanvasTest {
    private WebDriver driver;
    private CodeCanvasPage canvasPage;

    @BeforeEach
    public void setUp() {
        driver = getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.jetbrains.com/codecanvas/");
        canvasPage = new CodeCanvasPage(driver);
        canvasPage.acceptCookie();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Переход на страницу блога с ожиданием URL")
    public void openBlogAndCheckUrl() {
        canvasPage.clickOnBlog();
        String expectedUrl = "https://blog.jetbrains.com/codecanvas/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl,
                "URL после перехода в блог не совпадает с ожидаемым");
    }

    @Test
    @DisplayName("Переход на страницу новостей с ожиданием URL")
    public void openNewsAndCheckUrl() {
        canvasPage.clickOnNews();
        String expectedUrl = "https://www.jetbrains.com/codecanvas/category/news/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl,
                "URL после перехода в раздел новостей не совпадает с ожидаемым");
    }
}