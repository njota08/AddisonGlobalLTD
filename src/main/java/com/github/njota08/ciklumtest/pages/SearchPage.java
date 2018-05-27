/* ****************************************************************************/
package com.github.njota08.ciklumtest.pages;
/* ****************************************************************************/

/* ****************************************************************************/
import com.github.njota08.ciklumtest.components.SearchSection;
import com.github.njota08.ciklumtest.components.Result;
import com.github.njota08.ciklumtest.utils.Utils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
/* ****************************************************************************/

/**
 * @author Nery J. Marin Salas
 */
public class SearchPage {

    private final WebDriver driver;

    private static final By SEARCH_SECTION = By.id("frm");

    private static final double TARGET_SCORE = 8.0;

    private static final int TARGET_PRICE = 200;

    private static final By RESULTS = By.xpath("//*[@id='hotellist_inner']/div[not(contains(@class, 'soldout_property')) and contains(@class, 'sr_item')]");

    private static final By NEXT_PAGE = By.linkText("Next page");

    private static final By LOADING_OVERLAY = By.className("sr-usp-overlay");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public SearchSection getSearchSectionComponent() {
        WebElement webElement = Utils.waitFor(driver, ExpectedConditions.presenceOfElementLocated(SEARCH_SECTION));
        return new SearchSection(webElement, driver);
    }

    public Result getHotelScoreAndPrice() {
        while (true) {
            List<WebElement> results = driver.findElements(RESULTS);

            for (WebElement webElement : results) {
                Result result = new Result(webElement, driver);

                if (result.getScore() > TARGET_SCORE && result.getPrice() >= 0 && result.getPrice() < TARGET_PRICE) {
                    return result;
                }
            }

            try {
                // The try-catch block is needed since there's a odd glitch when scrolling down the page, causing Selenium to throw an unknown error //
                try {
                    Utils.waitFor(driver, ExpectedConditions.elementToBeClickable(NEXT_PAGE)).click();
                } catch (WebDriverException ignore) {
                    Utils.waitFor(driver, ExpectedConditions.elementToBeClickable(NEXT_PAGE)).click();
                }
            } catch (TimeoutException ignore) {
                break;
            }

            Utils.waitFor(driver, ExpectedConditions.invisibilityOfElementLocated(LOADING_OVERLAY));
        }

        return null;
    }
}