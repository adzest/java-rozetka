package com.ua.rozetka.isakov.helpers.client;

import com.ua.rozetka.isakov.helpers.client.web.CategoriesHelper;
import com.ua.rozetka.isakov.helpers.client.web.MainHelper;
import com.ua.rozetka.isakov.helpers.client.web.ProductHelper;

public class WebClient {

    private BasketHelper basketWidget;
    private MainHelper mainPage;
    private CategoriesHelper categoriesPage;
    private ProductHelper productPage;

    public BasketHelper basket() {
        return basketWidget == null ? basketWidget = new BasketHelper() : basketWidget;
    }

    public MainHelper main() {
        return mainPage == null ? mainPage = new MainHelper() : mainPage;
    }

    public CategoriesHelper categories() {
        return categoriesPage == null ? categoriesPage = new CategoriesHelper() : categoriesPage;
    }

    public ProductHelper product() {
        return productPage == null ? productPage = new ProductHelper() : productPage;
    }
}
