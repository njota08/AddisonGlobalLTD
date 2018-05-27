package com.github.njota08.ciklumtest.components;

import com.github.njota08.ciklumtest.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainHeader {

    private final WebElement webElement;
    private final WebDriver driver;

    public MainHeader(WebElement webElement, WebDriver driver) {
        this.webElement = webElement;
        this.driver = driver;
    }

    private static final By CURRENCY_BUTTON = By.xpath("//li[@data-id='currency_selector']/a");

    private static final By CURRENCY_EUR = By.xpath("(//a[@data-currency='EUR'])[1]");

    private static final String LANGUAGE_BUTTON_STRING = "//li[@data-id='language_selector']/a";

    private static final By LANGUAGE_BUTTON = By.xpath(LANGUAGE_BUTTON_STRING);

    private static final By LANGUAGE_US = By.xpath("(//a[@hreflang='en-us'])[1]");

    private static final By FLAG = By.xpath(LANGUAGE_BUTTON_STRING + "/img");

    public void changeCurrency() {
        Utils.waitFor(driver, ExpectedConditions.presenceOfNestedElementLocatedBy(webElement, CURRENCY_BUTTON))
                .click();
        Utils.waitFor(driver, ExpectedConditions.presenceOfElementLocated(CURRENCY_EUR)).click();
    }

    public String getCurrentCurrency() {
        return Utils.waitFor(driver, ExpectedConditions.presenceOfElementLocated(CURRENCY_BUTTON))
                .getText();
    }

    public void changeLanguage() {
        Utils.waitFor(driver, ExpectedConditions.presenceOfNestedElementLocatedBy(webElement, LANGUAGE_BUTTON))
                .click();
        Utils.waitFor(driver, ExpectedConditions.presenceOfElementLocated(LANGUAGE_US))
                .click();
    }

    public String getCurrentLanguage() {
        return Utils.waitFor(driver, ExpectedConditions.presenceOfElementLocated(FLAG))
                .getAttribute("alt");
    }
}