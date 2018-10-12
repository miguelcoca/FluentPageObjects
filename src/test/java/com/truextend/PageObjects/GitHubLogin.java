package com.truextend.PageObjects;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;
import org.testng.Assert;

public class GitHubLogin extends BasePage {
    private Query loginField = new Query(By.name("login"), driver);
    private Query passwordField = new Query(By.name("password"), driver);
    private Query submitButton = new Query(By.name("commit"), driver);

    public GitHubLogin() { }

    public GitHubLogin SelectLoginField(){
        loginField.findWebElement().click();
        return this;
    }

    public GitHubLogin TypeInLoginField(String searchTerm) {
        loginField.findWebElement().clear();
        loginField.findWebElement().sendKeys(searchTerm);
        return this;
    }

    public GitHubLogin SelectPassField(){
        passwordField.findWebElement().click();
        return this;
    }

    public GitHubLogin TypeInPassField(String searchTerm) {
        passwordField.findWebElement().clear();
        passwordField.findWebElement().sendKeys(searchTerm);
        return this;
    }

    public GitHubHomePage HitEnter() {
        submitButton.findWebElement().submit();
        return new GitHubHomePage();
    }

    public GitHubLogin NavigateTo(String url){
        driver.get(url);
        return this;
    }

}
