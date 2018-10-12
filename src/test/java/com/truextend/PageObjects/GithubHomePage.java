package com.truextend.PageObjects;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;
import org.testng.Assert;

public class GithubHomePage extends BasePage{


    private Query repositoriesTitle = new Query(By.className(".Box-title"), driver);

    public GithubHomePage(){}

    public GithubHomePage VerifyWelcomeMessage(String expected){
        Assert.assertTrue(repositoriesTitle.findWebElement().getText().contains(expected));
        return new GithubHomePage();
    }


}
