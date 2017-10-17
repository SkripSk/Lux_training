package com.luxoft.sqa.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends BaseHelper{

    public NavigationHelper(WebDriver driver) {
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

    public void goToGroupPage() {
        if (isElementPresent(By.tagName("h1"))
                && driver.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new"))){
            return;
        }
        click(By.linkText("groups"));
    }
}
