package com.luxoft.sqa.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NovigationHelper {
    private WebDriver driver;

    public NovigationHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void goToAddAddress() {
        driver.findElement(By.cssSelector("#nav > ul > li:nth-child(2) > a")).click();
    }

    public void goToHome() {
        driver.findElement(By.cssSelector("#nav > ul > li:nth-child(1) > a")).click();
    }

}
