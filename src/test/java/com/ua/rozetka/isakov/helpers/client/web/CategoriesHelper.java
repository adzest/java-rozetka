package com.ua.rozetka.isakov.helpers.client.web;

import com.ua.rozetka.isakov.pages.clientWeb.CategoriesPage;

public class CategoriesHelper extends CategoriesPage {

    public boolean isOpened() {
        return isCategoriesOpened();
    }

    public void selectProductByText(String searchText){
        selectProductAtCategoriesBy(searchText);
    }



}
