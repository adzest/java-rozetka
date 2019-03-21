package com.ua.rozetka.isakov.helpers.client.web;

import com.ua.rozetka.isakov.pages.clientWeb.ProductPage;

public class ProductHelper extends ProductPage {

    public boolean isOpened() {
        return isProductOpened();
    }

    public void addToBasket() {
        addProductToBasket();
    }

    public int getBasketQuantity() {
        return getProductsQuantityInBasket();
    }

    public boolean isProductTitleValid(String searchText) {
        return isProductTitleContains(searchText);
    }

    public void selectPropertyByText(String searchText) {
        selectPropertyAtProductBy(searchText);
    }

}
