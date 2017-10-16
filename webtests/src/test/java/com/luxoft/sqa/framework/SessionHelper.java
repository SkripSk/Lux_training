package com.luxoft.sqa.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends BaseHelper{

    public SessionHelper(WebDriver driver) {
        super(driver);
    }

    public void login(String userName, String password) {
        type(By.name("user"), userName);
        type(By.name("pass"), password);
        click(By.cssSelector("#LoginForm > input[type=\"submit\"]:nth-child(7)"));
    }

    public  void logout(){
        click(By.cssSelector("#top > form > a"));
    }
}
