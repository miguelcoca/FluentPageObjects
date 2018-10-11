package com.truextend.Tests;

import com.truextend.Listeners.ScreenshotListener;
import com.truextend.PageObjects.GoogleHomePage;
import com.truextend.PageObjects.staticGoogleHomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListener.class)
public class FluentSearchTests extends TestBase {

    GoogleHomePage searchEngine;

    @BeforeClass
    public void setup(){
        searchEngine = new GoogleHomePage();
    }

    @Test
    public void fluentGoogleCheeseSearch() throws Exception{

        searchEngine.NavigateTo("http://www.google.com")
                .SelectSearchBox()
                .TypeIn("Cheese!")
                .HitEnter()
                .VerifyResultsPageTitleContains("Cheese");
        }

    @Test
    public void staticFluentGoogleCheeseSearch(){
        staticGoogleHomePage.NavigateTo("http://www.google.com")
                .SelectSearchBox()
                .TypeIn("Cheese!")
                .HitEnter()
                .VerifyResultsPageTitleContains("Cheese");
    }
}
