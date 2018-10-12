package com.truextend.PageObjects;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;
import org.testng.Assert;

public class GitHubHomePage extends BasePage {

    private Query homeTitle = new Query(By.xpath("//h2"), driver);

    public GitHubHomePage() { }

    public void VerifyResultsPageTitleContains(String expected){
        Assert.assertTrue(homeTitle.findWebElement().getText().contains(expected));
    }

}