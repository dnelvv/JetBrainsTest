package com.example.jetbrainstest.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class CodeCanvasPage {
    private WebDriver driver;
    private static final Logger LOG = LoggerFactory.getLogger(CodeCanvasPage.class);

    @FindBy(xpath = "//button[contains(@class, 'ch2-allow-all-btn') " +
            "and contains(text(), 'Accept All')]")
    public WebElement acceptAllCookies;

    @FindBy(xpath = "//a[contains(@class, 'menu-second__link') " +
            "and @href='https://blog.jetbrains.com/codecanvas/']")
    public WebElement blogButton;

    @FindBy(xpath = "//a[@href='/codecanvas/category/news/' " +
            "and normalize-space(text())='News']")
    public WebElement newsButton;

    public CodeCanvasPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void acceptCookie() {
        LOG.info("Ожидаем пока кнопка 'Accept All' станет доступной для клика.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(acceptAllCookies));
        LOG.info("Нажимаем на кнопку 'Accept All'.");
        acceptAllCookies.click();
    }

    @Step("Переход на страницу блога")
    public void clickOnBlog() {
        LOG.info("Нажимаем на кнопку 'Blog'.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(blogButton));
        blogButton.click();
    }

    @Step("Переход на страницу новостей")
    public void clickOnNews() {
        LOG.info("Нажимаем на кнопку 'News'.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(newsButton));
        newsButton.click();
    }
}