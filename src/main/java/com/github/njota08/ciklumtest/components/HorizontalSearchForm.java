package com.github.njota08.ciklumtest.components;

import com.github.njota08.ciklumtest.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class HorizontalSearchForm implements SearchForm {

    private final WebDriver driver;

    public HorizontalSearchForm(WebDriver driver) {
        this.driver = driver;
    }

    private static final By SEARCH_SECTION = By.xpath("//div[@class='xp__fieldset accommodation']");

    private static final By COUNTRY_INPUT = By.id("ss");

    private static final By CHECK_IN_DATE_PICKER = By.xpath("//div[@data-mode='checkin']");

    private static final By LAST_DAY_CURRENT_MONTH = By.xpath("((//table[@class='c2-month-table'])[1]//span[@class='c2-day-inner'])[last()]");

    private static final By TRAVELERS_GROUP_SECTION = By.xpath("//div[@class='xp__input-group xp__guests']");

    private static final By ADULTS_GROUP_DROPDOWN = By.id("group_adults");

    private static final By CHILDREN_GROUP_DROPDOWN = By.id("group_children");

    private static final By CHILDREN_AGE_DROPDOWN = By.xpath("//select[@name='age']");

    private static final By SEARCH_BUTTON = By.xpath("//span[contains(text(),'Search')]");

    @Override
    public void setDestination() {
        Utils.waitFor(driver, ExpectedConditions.presenceOfNestedElementLocatedBy(SEARCH_SECTION, COUNTRY_INPUT))
                .sendKeys("M\u00E1laga, Andaluc\u00EDa, Spain");
    }

    @Override
    public void selectDates() {
        Utils.waitFor(driver, ExpectedConditions.presenceOfNestedElementLocatedBy(SEARCH_SECTION, CHECK_IN_DATE_PICKER))
                .click();
        Utils.waitFor(driver, ExpectedConditions.presenceOfNestedElementLocatedBy(SEARCH_SECTION, LAST_DAY_CURRENT_MONTH))
                .click();
    }

    @Override
    public void selectNumberOfAdults() {
        Utils.waitFor(driver, ExpectedConditions.presenceOfNestedElementLocatedBy(SEARCH_SECTION, TRAVELERS_GROUP_SECTION))
                .click();
        WebElement adultsGroup = Utils.waitFor(driver, ExpectedConditions.presenceOfElementLocated(ADULTS_GROUP_DROPDOWN));
        Select selectAdults = new Select(adultsGroup);
        selectAdults.selectByVisibleText("1");
    }

    @Override
    public void selectNumberAndAgeOfChildren() {
        WebElement childrenGroup = Utils.waitFor(driver, ExpectedConditions.presenceOfElementLocated(CHILDREN_GROUP_DROPDOWN));
        Select selectChildren = new Select(childrenGroup);
        selectChildren.selectByVisibleText("1");
        WebElement childrenAge = Utils.waitFor(driver, ExpectedConditions.presenceOfElementLocated(CHILDREN_AGE_DROPDOWN));
        Select selectChildrenAge = new Select(childrenAge);
        selectChildrenAge.selectByVisibleText("5 years old");
    }

    @Override
    public void performSearch() {
        Utils.waitFor(driver, ExpectedConditions.presenceOfNestedElementLocatedBy(SEARCH_SECTION, SEARCH_BUTTON))
                .click();
    }
}
