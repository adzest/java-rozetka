package com.ua.rozetka.isakov.helpers.client;

import com.ua.rozetka.isakov.pages.clientWeb.BasketPage;

public class BasketHelper extends BasketPage {

    public boolean isPageDisplayed(){
        return isDisplayedCheckoutButton();
    }
}
