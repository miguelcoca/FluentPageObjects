package com.truextend.PageObjects;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;
import org.testng.Assert;

public class GitHubMainHome extends BasePage {
    private Query repositoryHeaderDisplayed = new Query(By.xpath("//div[@id='dashboard']/div[contains(@class, 'dashboard-sidebar')]/descendant::h3[contains(text(),'Repositories')]"), driver);

    public GitHubMainHome(){}

    public void isRepositoryHeaderDisplayed(){
        Assert.assertTrue(repositoryHeaderDisplayed.findWebElement().isDisplayed(), "Repository is not displayed.");
    }

}
