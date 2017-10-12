package com.luxoft.sqa.webtest;

import com.luxoft.sqa.model.NewAddressData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "lib/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://localhost:8080/addressbook/edit.php");
        login("admin", "secret");
    }

    protected void submitAddAddressCreation() {
        driver.findElement(By.cssSelector("#content > form > input[type=\"submit\"]:nth-child(87)")).click();
    }

    protected void fillAddAddressForm(NewAddressData newAddressData) {
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(newAddressData.getFirstName());
        driver.findElement(By.name("middlename")).clear();
        driver.findElement(By.name("middlename")).sendKeys(newAddressData.getMiddleNameOrInital());
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(newAddressData.getLastName());
        driver.findElement(By.name("mobile")).clear();
        driver.findElement(By.name("mobile")).sendKeys(newAddressData.getTelephoneMobile());
    }

    protected void goToAddAddress() {
        driver.findElement(By.cssSelector("#nav > ul > li:nth-child(2) > a")).click();
    }

    protected void login(String userName, String password) {
        driver.findElement(By.name("user")).clear();
        driver.findElement(By.name("user")).sendKeys(userName);
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.cssSelector("#LoginForm > input[type=\"submit\"]:nth-child(7)")).click();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    protected void deletedAllAddresses() {
        driver.findElement(By.cssSelector("#content > form:nth-child(10) > div:nth-child(8) > input[type=\"button\"]")).click();
        driver.switchTo().alert().accept();
    }

    protected void selectAllAddresses() {
        driver.findElement(By.id("MassCB")).click();
    }

    protected void goToHome() {
        driver.findElement(By.cssSelector("#nav > ul > li:nth-child(1) > a")).click();
    }

    protected void updateAddress() {
        driver.findElement(By.cssSelector("#content > form:nth-child(2) > input[type=\"submit\"]:nth-child(86)")).click();
    }

    protected void clickEditButton() {
        driver.findElement(By.cssSelector("#maintable > tbody > tr:nth-child(2) > td:nth-child(8) > a > img")).click();
    }

    protected void selectFirstAddress() {
        driver.findElement(By.name("selected[]")).click();
    }
}
