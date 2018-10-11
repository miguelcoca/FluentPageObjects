package com.truextend.PageObjects;

import com.lazerycode.selenium.util.Query;
import com.truextend.Tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.net.MalformedURLException;

public class staticGoogleHomePage{

    static RemoteWebDriver driver;

    private final static staticGoogleHomePage staticInstance = new staticGoogleHomePage();

    private static Query searchBar = new Query(By.name("q"), driver);
    private static Query googleSearch = new Query(By.name("btnK"), driver);
    private static Query imFeelingLucky = new Query(By.name("btnI"), driver);

    private staticGoogleHomePage() {
        try {
            driver = TestBase.getDriver();
        } catch (MalformedURLException ignored) {
            //This will be be thrown when the test starts if it cannot connect to a RemoteWebDriver Instance
        }
    }

    public static staticGoogleHomePage SelectSearchBox(){
        searchBar.findWebElement().click();
        return staticInstance;
    }

    public static staticGoogleHomePage TypeIn(String searchTerm) {
        searchBar.findWebElement().clear();
        searchBar.findWebElement().sendKeys(searchTerm);
        return staticInstance;
    }

    public static staticGoogleHomePage HitEnter() {
        googleSearch.findWebElement().submit();
        return staticInstance;
    }

    public static staticGoogleHomePage NavigateTo(String url){
        driver.get(url);
        return staticInstance;
    }

    public static staticGoogleHomePage VerifyResultsPageTitleContains(String expected){
        Assert.assertTrue(driver.getTitle().contains(expected));
        return staticInstance;
    }

    public void clickGetLucky() {
        imFeelingLucky.findWebElement().click();
    }
}
