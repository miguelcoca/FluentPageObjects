package com.truextend.PageObjects;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;
import org.testng.Assert;

public class GitHubHomePage extends BasePage{

    private Query text = new Query(By.className("shelf-title"), driver);

    public GitHubHomePage(){}

    public GitHubHomePage VerifyResultsPageBodyContains(String expected){
        Assert.assertTrue(text.findWebElement().getText().contains(expected));
        return this;
    }
}
