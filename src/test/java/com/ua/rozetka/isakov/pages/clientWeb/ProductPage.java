package com.ua.rozetka.isakov.pages.clientWeb;

import com.ua.rozetka.isakov.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class ProductPage extends BasePage {
    @FindBy(xpath = "//*/div[@class='detail-title-code pos-fix clearfix']")
    private WebElement productPageTitle;
    @FindBy(xpath = "//*/div[@class='detail-available']")
    private WebElement details;
    @FindBy(xpath = "//*/span[@class='hub-i-count']")
    private WebElement basketCount;
    @FindBy(xpath = "//*/li[contains(@class,'pp-variants-l')]")
    private List<WebElement> colorVariants;
    @FindBy(xpath = "//*/button[@name='topurchases']")
    private WebElement addToBasketButton;

    protected void addProductToBasket() {
        click(addToBasketButton);
    }

    protected int getProductsQuantityInBasket() {
        return Integer.parseInt(basketCount.getText());
    }

    protected boolean isProductOpened() {
        return productPageTitle.isDisplayed();
    }

    protected boolean isProductTitleContains(String searchText) {
        return productPageTitle.getText().toLowerCase().contains(searchText.toLowerCase());
    }

    protected void selectPropertyAtProductBy(String searchText) {
        WebElement element = null;
        try {
            element = colorVariants.stream().filter(o -> o.getAttribute("outerHTML").toLowerCase().contains(searchText.toLowerCase())).collect(Collectors.toList()).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            log.info("WebElement:" + element + " >> attribute:searchText=" + searchText);
        }
        element.click();
    }
}
