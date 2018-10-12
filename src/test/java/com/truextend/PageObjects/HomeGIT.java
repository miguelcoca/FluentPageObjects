package com.truextend.PageObjects;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HomeGIT extends BasePage {
    private Query twoFactor=  new Query(By.xpath("//*[@id='login']/div[3]/h1"), driver);

    public HomeGIT(){}

    public HomeGIT VerifyResultsPageTitleContains(){
        Assert.assertTrue(twoFactor.findWebElement().isDisplayed());
        return this;
    }

}
