/* ****************************************************************************/
package com.github.njota08.addisongloballtd;
/* ****************************************************************************/

/* ****************************************************************************/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
/* ****************************************************************************/

/**
 * @author Nery J. Marin Salas
 */
public class BaseTest {

    static WebDriver driver;

    @BeforeTest
    public void beforeScenario() {
        if (driver == null)
            driver = new ChromeDriver();
        driver.manage()
                .deleteAllCookies();
        driver.manage()
                .window()
                .maximize();
    }

    @AfterTest
    public void afterScenario() {
        driver.close();
        driver = null;
    }
}
