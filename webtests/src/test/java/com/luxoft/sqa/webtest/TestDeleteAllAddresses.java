package com.luxoft.sqa.webtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestDeleteAllAddresses {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "lib/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://localhost:8080/addressbook/edit.php");
        login("admin", "secret");
    }

    @Test
    public void testAddNewAddress() {

        goToHome();
        selectAllAddresses();
        deletedAllAddresses();
    }

    public void deletedAllAddresses() {
        driver.findElement(By.cssSelector("#content > form:nth-child(10) > div:nth-child(8) > input[type=\"button\"]")).click();
        driver.switchTo().alert().accept();
    }

    private void selectAllAddresses() {
        driver.findElement(By.id("MassCB")).click();
    }

    private void goToHome() {
        driver.findElement(By.cssSelector("#nav > ul > li:nth-child(1) > a")).click();
    }

    private void login(String userName, String password) {
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
}
