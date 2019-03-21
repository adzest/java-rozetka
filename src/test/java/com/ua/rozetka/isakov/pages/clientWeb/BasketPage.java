package com.ua.rozetka.isakov.pages.clientWeb;

import com.ua.rozetka.isakov.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends BasePage {
    @FindBy(id = "popup-checkout")
    private WebElement checkoutButton;

    protected boolean isDisplayedCheckoutButton(){
        return checkoutButton.getText()!=null;
    }
}
