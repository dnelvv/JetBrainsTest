package com.example.jetbrainstest.pages;

import com.example.jetbrainstest.CodeCanvasLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class CodeCanvasPage {
    private WebDriver driver;
    private CodeCanvasLogger LOG;

    @FindBy(xpath = "//button[contains(@class, 'ch2-allow-all-btn') " +
            "and contains(text(), 'Accept All')]")
    public WebElement acceptAllCookies;

    @FindBy(xpath = "//a[contains(@class, 'menu-second__link') " +
            "and @href='https://blog.jetbrains.com/codecanvas/']")
    public WebElement blogButton;

    @FindBy(xpath = "//a[@href='/codecanvas/category/news/' " +
            "and normalize-space(text())='News']")
    public WebElement newsButton;

    @FindBy(xpath = "//span[text()='Request demo']/ancestor::a |" +
            " //span[text()='Request demo']/ancestor::button")
    public WebElement requestDemoButton;

    @FindBy(xpath = "//a[@data-test='site-header-profile-action']")
    public WebElement profileButton;

    @FindBy(xpath = "//a[@data-test='site-header-cart-action']")
    public WebElement cartButton;

    @FindBy(xpath = "//button[@data-test='main-menu-item-action' and text()='Store']")
    public WebElement storeMenuButton;

    @FindBy(xpath = "//span[text()='For Individual Use' and " +
            "contains(@class, 'mainSubmenuItem__title')]/ancestor::a")
    public WebElement forIndividualUseLink;

    @FindBy(xpath = "//a[@href='/legal/docs/privacy/privacy/' and text()='Privacy Notice']")
    public WebElement privacyNoticeLink;

    @FindBy(xpath = "//a[@href='/legal/docs/company/useterms/' and text()='Terms of Use']")
    public WebElement termsOfUseLink;

    @FindBy(xpath = "//button[@aria-label='Developer Tools: Open submenu']")
    public WebElement developerToolsButton;

    @FindBy(xpath = "//span[normalize-space()='IntelliJ IDEA']")
    public WebElement intellijIdeaItem;

    @FindBy(xpath = "//span[normalize-space()='PhpStorm']")
    public WebElement phpStormItem;

    @FindBy(xpath = "//span[text()='Rider']")
    private WebElement riderMenuItem;

    @FindBy(xpath = "//span[text()='RubyMine']")
    private WebElement rubyMineItem;

    @FindBy(xpath = "//span[text()='RustRover']")
    private WebElement rustRoverItem;

    @FindBy(xpath = "//span[contains(@class, '_mainSubmenuItem__title') and text()='WebStorm']")
    private WebElement webStormItem;

    @FindBy(xpath = "//a[contains(@class, 'menu-item') and text()='Pricing']")
    private WebElement pricingButton;

    @FindBy(xpath = "//a[contains(@class, 'menu-item') and text()='Documentation']")
    private WebElement documentationButton;

    @FindBy(xpath = "//a[text()='Genuine Tools']")
    private WebElement genuineToolsButton;

    @FindBy(xpath = "//a[@href='/legal/' and text()='Legal']\n")
    private WebElement legalButton;

    @FindBy(xpath = "//a[@href='/legal/attributions/' and text()='Attributions']")
    private WebElement attributionsButton;

    @FindBy(xpath = "//a[@href='/privacy-security/' and text()='Privacy & Security']")
    private WebElement privacyAndSecurity;

    @FindBy(xpath = "//a[text()='Academic Licensing']")
    private WebElement academicLicensingButton;

    public CodeCanvasPage(WebDriver driver) {
        this.driver = driver;
        this.LOG = new CodeCanvasLogger(LoggerFactory.getLogger(CodeCanvasPage.class));
        PageFactory.initElements(driver, this);
    }

    public void acceptCookie() {
        LOG.info("Ожидаем пока кнопка 'Accept All' станет доступной для клика.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(acceptAllCookies));
        LOG.info("Нажимаем на кнопку 'Accept All'.");
        acceptAllCookies.click();
    }

    public void clickOnBlog() {
        LOG.infoWithScreenshot("Нажимаем на кнопку 'Blog'.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(blogButton));
        blogButton.click();
    }

    public void clickOnNews() {
        LOG.infoWithScreenshot("Нажимаем на кнопку 'News'.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(newsButton));
        newsButton.click();
    }

    public void clickOnRequestDemo() {
        LOG.infoWithScreenshot("Нажимаем на кнопку 'Request demo'.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(requestDemoButton));
        requestDemoButton.click();
    }

    public void clickOnProfileButton() {
        LOG.infoWithScreenshot("Нажимаем на кнопку входа в личный кабинет.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(profileButton));
        profileButton.click();
    }

    public void clickOnCart() {
        LOG.infoWithScreenshot("Нажимаем на кнопку корзины.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        cartButton.click();
    }

    public void openStoreSubmenu() {
        LOG.infoWithScreenshot("Нажимаем на кнопку 'Store' в главном меню.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(storeMenuButton));
        storeMenuButton.click();
    }

    public void clickForIndividualUse() {
        LOG.infoWithScreenshot("Нажимаем на пункт 'For Individual Use' в подменю Store.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(forIndividualUseLink));
        forIndividualUseLink.click();
    }

    public void clickOnPrivacyNotice() {
        LOG.infoWithScreenshot("Нажимаем на ссылку 'Privacy Notice'.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(privacyNoticeLink));
        privacyNoticeLink.click();
    }

    public void clickOnTermsOfUse() {
        LOG.infoWithScreenshot("Нажимаем на ссылку 'Terms of Use'.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(termsOfUseLink));
        termsOfUseLink.click();
    }

    public void clickOnIntelliJIDEA() {
        LOG.infoWithScreenshot("Кликаем на 'Developer Tools'.");
        developerToolsButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(intellijIdeaItem));
        LOG.infoWithScreenshot("Кликаем на пункт 'IntelliJ IDEA'.");
        intellijIdeaItem.click();
    }

    public void clickOnPhpStorm() {
        LOG.infoWithScreenshot("Кликаем на 'Developer Tools'.");
        developerToolsButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(phpStormItem));
        LOG.infoWithScreenshot("Кликаем на пункт 'PhpStorm'.");
        phpStormItem.click();
    }

    public void clickOnRider() {
        LOG.infoWithScreenshot("Кликаем на Developer Tools");
        developerToolsButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(riderMenuItem));
        LOG.infoWithScreenshot("Клик на Rider");
        riderMenuItem.click();
    }

    public void clickOnRubyMine() {
        LOG.infoWithScreenshot("Кликаем на Developer Tools");
        developerToolsButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(rubyMineItem));
        LOG.infoWithScreenshot("Клик на RubyMine");
        rubyMineItem.click();
    }

    public void clickOnRustRover() {
        LOG.infoWithScreenshot("Кликаем на Developer Tools");
        developerToolsButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(rustRoverItem));
        LOG.infoWithScreenshot("Клик на RustRover");
        rustRoverItem.click();
    }

    public void clickOnWebStorm() {
        LOG.infoWithScreenshot("Кликаем на Developer Tools");
        developerToolsButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(webStormItem));
        LOG.infoWithScreenshot("Клик на WebStorm");
        webStormItem.click();
    }

    public void clickOnPricing() {
        LOG.infoWithScreenshot("Кликаем на вкладку Pricing");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(pricingButton)).click();
    }

    public void clickOnDocumentation() {
        LOG.infoWithScreenshot("Кликаем на вкладку Documentation");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(documentationButton)).click();
    }

    public void clickOnGenuineTools() {
        LOG.infoWithScreenshot("Кликаем на Genuine Tools");
        genuineToolsButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(genuineToolsButton));
    }

    public void clickOnLegalButton() {
        LOG.infoWithScreenshot("Кликаем на Legal");
        legalButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(legalButton));
    }

    public void clickOnAttributionsButton() {
        LOG.infoWithScreenshot("Кликаем на Attributions");
        attributionsButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(attributionsButton));
    }

    public void clickOnPrivacyAndSecurityButton() {
        LOG.infoWithScreenshot("Кликаем на Privacy & Security");
        privacyAndSecurity.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(privacyAndSecurity));
    }

    public void clickOnAcademicLicensingButton() {
        LOG.infoWithScreenshot("Кликаем на Academic Licensing Button в футере страницы");
        academicLicensingButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(academicLicensingButton));
    }
}