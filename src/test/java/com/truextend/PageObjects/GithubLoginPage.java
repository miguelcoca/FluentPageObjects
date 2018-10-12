package com.truextend.PageObjects;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;

public class GithubLoginPage extends BasePage{

    private Query loginUsername = new Query(By.id("login_field"), driver);
    private Query loginPassword = new Query(By.id("password"), driver);
    private Query loginButton = new Query(By.name("commit"), driver);


    public GithubLoginPage(){}

    public GithubLoginPage NavigateTo(String url){
        driver.get(url);
        return this;
    }

    public GithubLoginPage EnterCredentials(String userName, String password){
        loginUsername.findWebElement().clear();
        loginUsername.findWebElement().sendKeys(userName);
        loginPassword.findWebElement().clear();
        loginPassword.findWebElement().sendKeys(password);

        return this;
    }

    public GithubHomePage HitSubmit(){
        loginButton.findWebElement().click();
        return new GithubHomePage();
    }
}
