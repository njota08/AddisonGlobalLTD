package com.github.njota08.ciklumtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected static WebDriver driver;

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
