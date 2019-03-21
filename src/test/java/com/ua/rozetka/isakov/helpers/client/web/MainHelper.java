package com.ua.rozetka.isakov.helpers.client.web;

import com.ua.rozetka.isakov.pages.clientWeb.MainPage;

public class MainHelper extends MainPage {

    public boolean isDisplayedSearchPopUp() {
        return isSuggestionListDisplayed();
    }

    public void goTo() {
        goToMainPage();
    }

    public void selectFromSearchPopUp(String text) {
        selectFromSearchPopUpByText(text);
    }

    public void typeSearch(String text) {
        typeSearchAtPage(text);
    }

}
