package com.luxoft.sqa.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class NovigationHelper extends BaseHelper{

    public NovigationHelper(WebDriver driver) {
        super(driver);
    }

    public void goToAddAddress() {
        if (isElementPresent(By.cssSelector("#content > h1"))){
            return;
        }
        click(By.cssSelector("#nav > ul > li:nth-child(2) > a"));
    }

    public void goToHome() {
        if (isElementPresent(By.id("maintable"))){
            return;
        }
        click(By.cssSelector("#nav > ul > li:nth-child(1) > a"));
    }

}
