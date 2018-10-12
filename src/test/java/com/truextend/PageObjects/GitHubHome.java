package com.truextend.PageObjects;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;
import org.testng.Assert;

public class GitHubHome extends BasePage {
    //private Query LookforRepo = new Query(By.name("login"),driver);

    public GitHubHome VerifyRepositoryTitleContains(String expected){
        Assert.assertTrue(driver.getTitle().contains(expected));
        return this;
    }
}
