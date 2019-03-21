package com.ua.rozetka.isakov.pages.clientWeb;

import com.ua.rozetka.isakov.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class CategoriesPage extends BasePage {
    @FindBy(name = "nav-m-main")
    private WebElement categoriesPageTitle;
    @FindBy(xpath = "//*/div[@class='g-i-tile g-i-tile-catalog']")
    private List<WebElement> products;
    @FindBy(xpath = "//*/div[@class='g-i-tile-i-title clearfix']")
    private List<WebElement> productTitles;

    protected boolean isCategoriesOpened() {
        return categoriesPageTitle.isDisplayed();
    }

    protected void selectProductAtCategoriesBy(String searchText) {
        WebElement element = null;
        try {
            element = productTitles.stream().filter(o -> o.getText().toLowerCase().contains(searchText.toLowerCase())).collect(Collectors.toList()).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            log.info("WebElement:" + element + " >> attribute:searchText=" + searchText);
        }
        click(element);
    }
}
