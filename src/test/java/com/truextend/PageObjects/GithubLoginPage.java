package com.truextend.PageObjects;

import com.lazerycode.selenium.util.Query;
import org.junit.Assert;
import org.openqa.selenium.By;

public class GithubLoginPage extends BasePage {

    private Query searchName = new Query(By.name("login"), driver);
    private Query searchPassword = new Query(By.name("password"), driver);
    private Query gitSubmit = new Query(By.name("commit"), driver);
    private Query gitSubtitle =
      new Query(By.xpath("//*[@id=\"js-pjax-container\"]/div[1]/div/div/h2"), driver);

    public GithubLoginPage(){

    }

    public GithubLoginPage FillName(String name) {
        searchName.findWebElement().clear();
        searchName.findWebElement().sendKeys(name);
        return this;
    }

    public GithubLoginPage FillPassword(String password) {
        searchPassword .findWebElement().clear();
        searchPassword .findWebElement().sendKeys(password);
        return this;
    }

    public GithubLoginPage HitEnter() {
        gitSubmit.findWebElement().submit();
        return this;
    }

    public GithubLoginPage NavigateTo(String url){
        driver.get(url);
        return this;
    }

    public GithubLoginPage VerifyResultsPageSubTitleContains(String expected){
        Assert.assertTrue(gitSubtitle.findWebElement().getText().equals("Learn Git and GitHub without any code!"));
        return this;
    }
}
