package com.github.njota08.ciklumtest.components;

import com.github.njota08.ciklumtest.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Result {

    private final WebElement webElement;
    private final WebDriver driver;

    public Result(WebElement webElement, WebDriver driver) {
        this.webElement = webElement;
        this.driver = driver;
    }

    private static final Pattern PRICE_PATTERN = Pattern.compile("^.* (?<price>\\d+)$");

    private static final By HOTEL_SCORE = By.cssSelector(".review-score-badge");

    private static final By HOTEL_PRICE = By.cssSelector(".totalPrice");

    private static final By HOTEL_NAME = By.cssSelector(".sr-hotel__name");

    public String getName() {
        return Utils.waitFor(driver, ExpectedConditions.presenceOfNestedElementLocatedBy(webElement, HOTEL_NAME)).getText();
    }

    public double getScore() {
        try {
            String score = Utils.waitFor(driver, ExpectedConditions.presenceOfNestedElementLocatedBy(webElement, HOTEL_SCORE)).getText();
            return Double.parseDouble(score);
        } catch (TimeoutException ignore) {
            return -1.0;
        }
    }

    public int getPrice() {
        try {
            String price = Utils.waitFor(driver, ExpectedConditions.presenceOfNestedElementLocatedBy(webElement, HOTEL_PRICE)).getText();
            Matcher matcher = PRICE_PATTERN.matcher(price);

            if (matcher.find())
                return Integer.parseInt(matcher.group("price"));
        } catch (TimeoutException ignore) {
        }
        return -1;
    }
}

