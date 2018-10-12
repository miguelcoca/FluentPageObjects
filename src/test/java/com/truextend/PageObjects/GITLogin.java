package com.truextend.PageObjects;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;
import org.testng.Assert;

public class GITLogin extends BasePage {

        private Query username = new Query(By.id("login_field"), driver);
        private Query password = new Query(By.name("password"), driver);
        private Query signIn = new Query(By.xpath("//*[@id=\"login\"]/form/div[3]/input[3]"), driver);
        private HomeGIT home = new HomeGIT();

        public GITLogin() { }

        public com.truextend.PageObjects.GITLogin FillUsername(String usernameValue){
            username.findWebElement().sendKeys(usernameValue);
            return this;
        }

        public com.truextend.PageObjects.GITLogin FillPassword(String passwordValue){
            password.findWebElement().sendKeys(passwordValue);
            return this;
        }

        public com.truextend.PageObjects.HomeGIT HitSignIn() {
            signIn.findWebElement().click();
            return home;
        }

    public com.truextend.PageObjects.GITLogin NavigateTo(String url){
        driver.get(url);
        return this;
    }
    }