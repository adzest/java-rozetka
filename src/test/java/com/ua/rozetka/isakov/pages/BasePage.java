package com.ua.rozetka.isakov.pages;

import com.ua.rozetka.isakov.common.null_web_element.NullWebElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

import static com.ua.rozetka.isakov.common.Constants.getProperties;

public class BasePage {

    private static final String STR_URL_PATTERN = "https://%s%s";
    protected static RemoteWebDriver driver;
    private static Actions actions;
    protected Logger log = Logger.getLogger(this.getClass().getSimpleName());
    @FindBy(xpath = "//*/span[@class='exponea-close-cross']")
    private WebElement popupCross;

    public BasePage() {
        String platform = System.getProperty("platform", "nonUI");
        if (driver != null) {
            if (platform.equals("web")) {
                PageFactory.initElements(driver, this);
            } else if (platform.equals("mob")) {
                log.info("Mobile test are not supported now.");
            }
        }
    }

    private static Actions actions() {
        return actions == null
                ? actions = new Actions(driver)
                : actions;
    }

    protected void getPage(String urlPostfix) {
        String url;
        if (urlPostfix != null) {
            url = String.format(STR_URL_PATTERN, getProperties().getProperty("baseUrl"), urlPostfix);
        } else
            url = String.format(STR_URL_PATTERN, getProperties().getProperty("baseUrl"), "");
        driver.get(url);
    }

    protected void type(WebElement element, String text) {
        element.click();
        if (text != null) {
            element.clear();
            element.sendKeys(text);
        }
    }

    protected void attach(WebElement element, File file) {
        if (file != null) {
            element.sendKeys(file.getAbsolutePath());
        }
    }

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    protected WebElement findElement(By by) {
        try {
            return driver.findElement(by);
        } catch (NoSuchElementException e) {
            return NullWebElement.NULL();
        }
    }

    protected void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            popupCross.click();
        } finally {
            log.info("[Framework] [Talks] - Popup, I hate u and I close u!");
        }
        element.click();
    }

    private void click(By target) {
        actions().click(driver.findElement(target)).build().perform();
    }

    protected void selectItem(WebElement element, String item) {
        element.click();
        click(By.xpath(String.format("//div[contains(text(), '%s')]", item)));
    }
}