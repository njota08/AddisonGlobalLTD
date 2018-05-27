/* ****************************************************************************/
package com.github.njota08.ciklumtest;
/* ****************************************************************************/

/* ****************************************************************************/
import com.github.njota08.ciklumtest.components.MainHeader;
import com.github.njota08.ciklumtest.components.SearchForm;
import com.github.njota08.ciklumtest.components.SearchSection;
import com.github.njota08.ciklumtest.components.Result;
import com.github.njota08.ciklumtest.pages.BookingPage;
import com.github.njota08.ciklumtest.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;
/* ****************************************************************************/

/**
 * @author Nery J. Marin Salas
 */
public class BookingTest extends BaseTest {

    private static final String EURO_SYMBOL = "\u20AC";

    private static final String ENGLISH_LANGUAGE = "English (US)";

    @Test
    public void AddisonGlobalLtdAutomationTest() {
        driver.get(BookingPage.URL);
        BookingPage bookingPage = new BookingPage(driver);
        MainHeader mainHeader = bookingPage.getMainHeaderComponent();
        mainHeader.changeCurrency();
        Assert.assertEquals(mainHeader.getCurrentCurrency(), EURO_SYMBOL);
        mainHeader = bookingPage.getMainHeaderComponent();
        mainHeader.changeLanguage();
        Assert.assertEquals(mainHeader.getCurrentLanguage(), ENGLISH_LANGUAGE);
        SearchForm searchForm = bookingPage.getSearchSectionComponent();
        searchForm.selectDates();
        searchForm.setDestination();
        searchForm.selectNumberOfAdults();
        searchForm.selectNumberAndAgeOfChildren();
        searchForm.performSearch();
        SearchPage searchPage = new SearchPage(driver);
        SearchSection searchSection = searchPage.getSearchSectionComponent();
        searchSection.addTwoRoomsToSearch();
        searchSection.checkImTravelingForWorkOption();
        searchSection.performRefinedSearch();
        Result result = searchPage.getHotelScoreAndPrice();
        Assert.assertNotNull(result, "No matches were found that meet the criteria.");
        System.out.println("\nThe first hotel with a score higher than 8.0 and a price lower than "
                + EURO_SYMBOL + " 200 is " + result.getName() + ". (Score: " + result.getScore() + "/ Price: " +
                EURO_SYMBOL + " " + result.getPrice() + ")\n");
    }
}
