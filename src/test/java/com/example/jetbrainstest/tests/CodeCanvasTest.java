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
       /*не удаляю, т.к страница канваса нестабильно отображает куки, если тесты не будут проходить,
        нужно раскоментить эту строчку
        canvasPage.acceptCookie(); */
    }

    @AfterEach
    public void tearDownEach() {
        super.tearDown();
    }

    private void waitAndAssertUrl(String expectedUrl, String errorMessage) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(expectedUrl));
        Assertions.assertEquals(expectedUrl, getDriver().getCurrentUrl(), errorMessage);
    }

    @Test
    @DisplayName("Переход на страницу новостей с ожиданием URL")
    public void openNewsAndCheckUrl() {
        canvasPage.clickOnBlog();
        canvasPage.clickOnNews();
        waitAndAssertUrl("https://blog.jetbrains.com/codecanvas/category/news/",
                "Некорректная ссылка после перехода на новости");
    }

    @Test
    @DisplayName("Переход на страницу Request Demo")
    public void openRequestDemoPageAndCheckUrl() {
        canvasPage.clickOnRequestDemo();
        waitAndAssertUrl("https://www.jetbrains.com/codecanvas/get-in-touch/",
                "Некорректная ссылка после клика на 'Request demo'");
    }

    @Test
    @DisplayName("Переход в личный кабинет")
    public void openLoginPageAndCheckUrl() {
        canvasPage.clickOnProfileButton();
        waitAndAssertUrl("https://account.jetbrains.com/login",
                "Не произошел переход на страницу логина");
    }

    @Test
    @DisplayName("Переход в корзину и проверка URL")
    public void openCartAndCheckUrl() {
        canvasPage.clickOnCart();
        waitAndAssertUrl("https://www.jetbrains.com/store/?section=commercial&billing=yearly",
                "Некорректный URL после перехода в корзину");
    }

    @Test
    @DisplayName("Переход в Store → For Individual Use и проверка URL")
    public void openIndividualToolsFromStoreMenu() {
        canvasPage.openStoreSubmenu();
        canvasPage.clickForIndividualUse();
        waitAndAssertUrl("https://www.jetbrains.com/store/?section=personal&billing=yearly",
                "Некорректная ссылка после перехода в Store > For Individual Use");
    }

    @Test
    @DisplayName("Переход по ссылке Privacy Notice и проверка URL")
    public void openPrivacyNoticeAndCheckUrl() {
        canvasPage.clickOnPrivacyNotice();
        waitAndAssertUrl("https://www.jetbrains.com/legal/docs/privacy/privacy/",
                "Некорректный URL после перехода по ссылке 'Privacy Notice'");
    }

    @Test
    @DisplayName("Переход по ссылке 'Terms of Use' и проверка URL")
    public void openTermsOfUseAndCheckUrl() {
        canvasPage.clickOnTermsOfUse();
        waitAndAssertUrl("https://www.jetbrains.com/legal/docs/company/useterms/",
                "Некорректная ссылка после перехода по 'Terms of Use'");
    }

    @Test
    @DisplayName("Переход в Developer Tools -> IntelliJ IDEA и проверка открытия страницы")
    public void openIntelliJIdeaFromDeveloperTools() {
        canvasPage.clickOnIntelliJIDEA();
        waitAndAssertUrl("https://www.jetbrains.com/idea/",
                "Ожидалась страница IntelliJ IDEA, но URL не совпал.");
    }

    @Test
    @DisplayName("Переход в Developer Tools -> PhpStorm и проверка открытия страницы")
    public void openPhpStormFromDeveloperTools() {
        canvasPage.clickOnPhpStorm();
        waitAndAssertUrl("https://www.jetbrains.com/phpstorm/",
                "Ожидалась страница PhpStorm, но URL не совпал.");
    }

    @Test
    @DisplayName("Переход в Developer Tools -> Rider")
    public void openRiderFromDeveloperTools() {
        canvasPage.clickOnRider();
        waitAndAssertUrl("https://www.jetbrains.com/rider/",
                "Ожидалась страница Rider, но URL не совпал");
    }

    @Test
    @DisplayName("Переход в Developer Tools -> RubyMine")
    public void openRubyMineFromDeveloperTools() {
        canvasPage.clickOnRubyMine();
        waitAndAssertUrl("https://www.jetbrains.com/ruby/",
                "Ожидалась страница RubyMine, но URL не совпал");
    }

    @Test
    @DisplayName("Переход в Developer Tools -> RustRover")
    public void openRustRoverFromDeveloperTools() {
        canvasPage.clickOnRustRover();
        waitAndAssertUrl("https://www.jetbrains.com/rust/",
                "Ожидалась страница RustRover, но URL не совпал");
    }

    @Test
    @DisplayName("Переход в Developer Tools -> WebStorm")
    public void openWebStormFromDeveloperTools() {
        canvasPage.clickOnWebStorm();
        waitAndAssertUrl("https://www.jetbrains.com/webstorm/",
                "Ожидалась страница WebStorm, но URL не совпал");
    }

    @Test
    @DisplayName("Переход на вкладку Pricing и проверка URL")
    public void openPricingPageAndCheckUrl() {
        canvasPage.clickOnPricing();
        waitAndAssertUrl("https://www.jetbrains.com/codecanvas/buy/?billing=yearly",
                "Некорректный URL после перехода на вкладку Pricing");
    }

    @Test
    @DisplayName("Переход на вкладку Documentation и проверка URL")
    public void openDocumentationPageAndCheckUrl() {
        canvasPage.clickOnDocumentation();
        waitAndAssertUrl("https://www.jetbrains.com/help/codecanvas/introduction.html",
                "Некорректный URL после перехода на вкладку Documentation");
    }
    
    @Test
    @DisplayName("Переход в Genuine Tools и проверка URL")
    public void openGenuineToolsUrl() {
        canvasPage.clickOnGenuineTools();
        waitAndAssertUrl("https://www.jetbrains.com/genuine-tools/",
                "Некорректный URL после перехода в корзину");
    }

    @Test
    @DisplayName("Переход в Legal и проверка URL")
    public void openLegalUrl() {
        canvasPage.clickOnLegalButton();
        waitAndAssertUrl("https://www.jetbrains.com/legal/#licensing",
                "Некорректный URL после перехода в корзину");
    }

    @Test
    @DisplayName("Переход в Attributions и проверка URL")
    public void openAttributionsUrl() {
        canvasPage.clickOnAttributionsButton();
        waitAndAssertUrl("https://www.jetbrains.com/legal/attributions/",
                "Некорректный URL после перехода в корзину");
    }

    @Test
    @DisplayName("Переход в Privacy & Security и проверка URL")
    public void openOnPrivacyAndSecurityUrl() {
        canvasPage.clickOnPrivacyAndSecurityButton();
        waitAndAssertUrl("https://www.jetbrains.com/privacy-security/",
                "Некорректный URL после перехода в корзину");
    }

    @Test
    @DisplayName("Переход в Academic Licensing в футере страницы и проверка URL")
    public void openMerchandiseStoreButtonUrl() {
        canvasPage.clickOnAcademicLicensingButton();
        waitAndAssertUrl("https://www.jetbrains.com/academy/student-pack/",
                "Некорректный URL после перехода в корзину");
    }
}