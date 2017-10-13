package com.luxoft.sqa.framework;

import com.luxoft.sqa.model.NewAddressData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper {
    private WebDriver driver;

    public ContactHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void submitAddAddressCreation() {
        driver.findElement(By.cssSelector("#content > form > input[type=\"submit\"]:nth-child(87)")).click();
    }

    public void fillAddAddressForm(NewAddressData newAddressData) {
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(newAddressData.getFirstName());
        driver.findElement(By.name("middlename")).clear();
        driver.findElement(By.name("middlename")).sendKeys(newAddressData.getMiddleNameOrInital());
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(newAddressData.getLastName());
        driver.findElement(By.name("mobile")).clear();
        driver.findElement(By.name("mobile")).sendKeys(newAddressData.getTelephoneMobile());
    }

    public void deletedAllAddresses() {
        driver.findElement(By.cssSelector("#content > form:nth-child(10) > div:nth-child(8) > input[type=\"button\"]")).click();
        driver.switchTo().alert().accept();
    }

    public void selectAllAddresses() {
        driver.findElement(By.id("MassCB")).click();
    }

    public void updateAddress() {
        driver.findElement(By.cssSelector("#content > form:nth-child(2) > input[type=\"submit\"]:nth-child(86)")).click();
    }

    public void clickEditButton() {
        driver.findElement(By.cssSelector("#maintable > tbody > tr:nth-child(2) > td:nth-child(8) > a > img")).click();
    }

    public void selectFirstAddress() {
        driver.findElement(By.name("selected[]")).click();
    }
}
