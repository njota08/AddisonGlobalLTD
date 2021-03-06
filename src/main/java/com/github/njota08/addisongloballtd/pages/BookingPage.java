/* ****************************************************************************/
package com.github.njota08.addisongloballtd.pages;
/* ****************************************************************************/

/* ****************************************************************************/
import com.github.njota08.addisongloballtd.components.HorizontalSearchForm;
import com.github.njota08.addisongloballtd.components.MainHeader;
import com.github.njota08.addisongloballtd.components.SearchForm;
import com.github.njota08.addisongloballtd.components.VerticalSearchForm;
import com.github.njota08.addisongloballtd.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
/* ****************************************************************************/

/**
 * @author Nery J. Marin Salas
 */
public class BookingPage {

    public static final String URL = "https://www.booking.com";

    private final WebDriver driver;

    private static final By MAIN_HEADER = By.xpath("//div[@id='top']/div[@class='header-wrapper']");

    private static final By HORIZONTAL_SEARCH_SECTION = By.xpath("//div[@class='xpi__searchbox']/div");

    public BookingPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainHeader getMainHeaderComponent() {
        WebElement webElement = Utils.waitFor(driver, ExpectedConditions.presenceOfElementLocated(MAIN_HEADER));
        return new MainHeader(webElement, driver);
    }

    public SearchForm getSearchSectionComponent() {
        if (!driver.findElements(HORIZONTAL_SEARCH_SECTION).isEmpty()) {
            return new HorizontalSearchForm(driver);
        } else {
            return new VerticalSearchForm(driver);
        }
    }
}
