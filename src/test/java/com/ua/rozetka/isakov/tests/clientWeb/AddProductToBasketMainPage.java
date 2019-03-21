package com.ua.rozetka.isakov.tests.clientWeb;

import com.ua.rozetka.isakov.common.ColorsTypes;
import com.ua.rozetka.isakov.tests.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AddProductToBasketMainPage extends BaseTest {

    @Test(
            groups = {
                    "regression"
                    , "ui"
            }
//            , invocationCount = 3
    )
    public void test_givenProduct_whenSearchingForAtMainPage_thenCouldBeAddedToBasket() {
        String text = "iphone";
        String label = "iphone se";
        String searchText = "rose";
        String color = ColorsTypes.SPACE_GRAY.getColor();
        app.WebClient().main().goTo();
        app.WebClient().main().typeSearch(text);
//        assertTrue(app.WebClient().main().isDisplayedSearchPopUp());
        app.WebClient().main().selectFromSearchPopUp(label);
        assertTrue(app.WebClient().categories().isOpened());
        app.WebClient().categories().selectProductByText(searchText);
        assertTrue(app.WebClient().product().isOpened());
        assertTrue(app.WebClient().product().isProductTitleValid(searchText));
        app.WebClient().product().selectPropertyByText(color);
        assertTrue(app.WebClient().product().isProductTitleValid(ColorsTypes.SPACE_GRAY.name().replace("_", " ")));
        app.WebClient().product().addToBasket();
        assertTrue(app.WebClient().basket().isPageDisplayed());
    }
}
