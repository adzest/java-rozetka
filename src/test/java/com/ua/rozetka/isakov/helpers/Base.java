package com.ua.rozetka.isakov.helpers;

import com.ua.rozetka.isakov.driver_factory.DriverFactory;
import com.ua.rozetka.isakov.pages.BasePage;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Base extends BasePage {

    public void startApp() {
        driver = DriverFactory.getDriver();
    }

    public void stopApp() {
        if (driver != null) {
            driver.quit();
        }
    }

    public RemoteWebDriver getDriver() {
        return driver;
    }
}
