/* ****************************************************************************/
package com.github.njota08.ciklumtest.utils;
/* ****************************************************************************/

/* ****************************************************************************/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
/* ****************************************************************************/

/**
 * @author Nery J. Marin Salas
 */
public class Utils {

    private Utils() {
    }

    public static <T> T waitFor(WebDriver driver, ExpectedCondition<T> expectedCondition) {
        return new WebDriverWait(driver, 1_0L).until(expectedCondition);
    }
}
