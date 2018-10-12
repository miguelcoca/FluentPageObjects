package com.truextend.PageObjects;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;
import org.testng.Assert;

public class GoogleHomePage extends BasePage {

    private Query searchBar = new Query(By.name("q"), driver);
    private Query googleSearch = new Query(By.name("btnK"), driver);
    private Query imFeelingLucky = new Query(By.name("btnI"), driver);

    public GoogleHomePage() { }

    public GoogleHomePage SelectSearchBox(){
        searchBar.findWebElement().click();
        return this;
    }

    public GoogleHomePage TypeIn(String searchTerm) {
        searchBar.findWebElement().clear();
        searchBar.findWebElement().sendKeys(searchTerm);
        return this;
    }

    public GoogleHomePage HitEnter() {
        googleSearch.findWebElement().submit();
        return this;
    }

    public GoogleHomePage NavigateTo(String url){
        driver.get(url);
        return this;
    }

    public GoogleHomePage VerifyResultsPageTitleContains(String expected){
        Assert.assertTrue(driver.getTitle().contains(expected));

        return this;
    }

    public void clickGetLucky() {
        imFeelingLucky.findWebElement().click();
    }

}