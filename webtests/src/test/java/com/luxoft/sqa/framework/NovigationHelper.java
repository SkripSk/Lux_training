package com.luxoft.sqa.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NovigationHelper extends BaseHelper{

    public NovigationHelper(WebDriver driver) {
        super(driver);
    }

    public void goToAddAddress() {
        click(By.cssSelector("#nav > ul > li:nth-child(2) > a"));
    }

    public void goToHome() {
        driver.findElement(By.cssSelector("#nav > ul > li:nth-child(1) > a")).click();
    }

}
