package com.ua.rozetka.isakov.pages.clientWeb;

import com.ua.rozetka.isakov.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class MainPage extends BasePage {
    @FindBy(xpath = "//h2[contains(text(),'Rozetka.ua')]")
    private WebElement pageTitle;
    @FindBy(name = "search")
    private WebElement boxSearch;
	@FindBy(xpath ="//*/ul[@class='suggest-list']")
	private WebElement searchSuggestionList;
    @FindBy(xpath ="//*/li[@class='suggest__item']")
    private List<WebElement> searchSuggestionItems;

    protected void goToMainPage() {
        getPage(null);
    }

    protected void selectFromSearchPopUpByText(String text) {
        WebElement element = null;
        try {
            element.isDisplayed();
            element = searchSuggestionItems.stream().filter(o -> o.getText().equals(text)).collect(Collectors.toList()).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            log.info("WebElement:"+ element + " >> attribute:text=" + text);
        }
        element.click();
    }

    protected void typeSearchAtPage(String name) {
        type(boxSearch, name);
    }

    protected boolean isSuggestionListDisplayed(){
        boolean isDisplayed = false;
        try {
            if (searchSuggestionList.isDisplayed()) {
                isDisplayed = searchSuggestionItems.get(searchSuggestionItems.size()-1).isDisplayed();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return isDisplayed;
        }
    }
}
