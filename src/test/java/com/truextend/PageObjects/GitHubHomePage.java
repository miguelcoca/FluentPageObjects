package com.truextend.PageObjects;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;
import org.testng.Assert;

public class GitHubHomePage extends BasePage {
    private Query bannerText = new Query(By.className("shelf-title"), driver);

    public GitHubHomePage() { }

    public GitHubHomePage VerifyTextInBanner(String expectedText){
        Assert.assertTrue(bannerText.findWebElement().getText().contains(expectedText));
        return this;
    }
}
