package com.ua.rozetka.isakov.common.null_web_element;

import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;

public class NullWebElement implements WebElement {

    private final String nullWebElement = "NullWebElement";
    private static NullWebElement instance;

    private NullWebElement(){}

    public static NullWebElement NULL() {
        return instance == null
                ? instance = new NullWebElement()
                : instance;
    }

    @Override
    public void click() {

    }

    @Override
    public void submit() {

    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {

    }

    @Override
    public void clear() {

    }

    @Override
    public String getTagName() {
        return nullWebElement;
    }

    @Override
    public String getAttribute(String name) {
        return nullWebElement;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getText() {
        return nullWebElement;
    }

    @Override
    public <T extends WebElement> List<T> findElements(By by) {
        return new ArrayList<>();
    }

    @Override
    public <T extends WebElement> T findElement(By by) {
        return (T) this;
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public Point getLocation() {
        return new Point(0,0);
    }

    @Override
    public Dimension getSize() {
        return new Dimension(0,0);
    }

    @Override
    public Rectangle getRect() {
        return new Rectangle(new Point(0,0),new Dimension(0,0));
    }

    @Override
    public String getCssValue(String propertyName) {
        return nullWebElement;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }
}