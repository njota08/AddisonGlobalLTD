package com.github.njota08.ciklumtest.components;

import com.github.njota08.ciklumtest.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class SearchSection {

    private final WebElement webElement;
    private final WebDriver driver;

    public SearchSection(WebElement webElement, WebDriver driver) {
        this.webElement = webElement;
        this.driver = driver;
    }

    private static final By ROOMS_QTY_DROPDOWN = By.id("no_rooms");

    private static final By TRAVELING_FOR_WORK_CHECKBOX = By.xpath("//input[@type='checkbox']");

    private static final By SEARCH_BUTTON = By.xpath("//button[@type='submit']//span[contains(text(),'Search')]");

    public void addTwoRoomsToSearch() {
        WebElement roomsQty = Utils.waitFor(driver, ExpectedConditions.presenceOfNestedElementLocatedBy(webElement, ROOMS_QTY_DROPDOWN));
        Select select = new Select(roomsQty);
        select.selectByVisibleText("2 rooms");
    }

    public void checkImTravelingForWorkOption() {
        if (!Utils.waitFor(driver, ExpectedConditions.presenceOfNestedElementLocatedBy(webElement, TRAVELING_FOR_WORK_CHECKBOX))
                .isSelected()) {
            driver.findElement(TRAVELING_FOR_WORK_CHECKBOX)
                    .click();
        }
    }

    public void performRefinedSearch() {
        Utils.waitFor(driver, ExpectedConditions.presenceOfNestedElementLocatedBy(webElement, SEARCH_BUTTON))
                .click();
    }

}
