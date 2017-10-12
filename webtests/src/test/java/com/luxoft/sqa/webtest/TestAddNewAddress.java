package com.luxoft.sqa.webtest;

import com.luxoft.sqa.model.NewAddressData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAddNewAddress {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "lib/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://localhost:8080/addressbook/edit.php");
    }

    @Test
    public void testAddNewAddress(){

        login("admin", "secret");

        goToAddAddress();
        fillAddAddressForm(new NewAddressData("Lena", "Lera", "Skrip", "","+7(961)9592975"));
        submitAddAddressCreation();

    }

    private void submitAddAddressCreation() {
        driver.findElement(By.cssSelector("#content > form > input[type=\"submit\"]:nth-child(87)")).click();
    }

    private void fillAddAddressForm(NewAddressData newAddressData) {
        driver.findElement(By.cssSelector("#content > form > input[type=\"text\"]:nth-child(6)")).clear();
        driver.findElement(By.cssSelector("#content > form > input[type=\"text\"]:nth-child(6)")).sendKeys(newAddressData.getFirstName());
        driver.findElement(By.cssSelector("#content > form > input[type=\"text\"]:nth-child(9)")).clear();
        driver.findElement(By.cssSelector("#content > form > input[type=\"text\"]:nth-child(9)")).sendKeys(newAddressData.getMiddleNameOrInital());
        driver.findElement(By.cssSelector("#content > form > input[type=\"text\"]:nth-child(13)")).clear();
        driver.findElement(By.cssSelector("#content > form > input[type=\"text\"]:nth-child(13)")).sendKeys(newAddressData.getLastName());
        driver.findElement(By.cssSelector("#content > form > input[type=\"text\"]:nth-child(37)")).clear();
        driver.findElement(By.cssSelector("#content > form > input[type=\"text\"]:nth-child(37)")).sendKeys(newAddressData.getTelephoneMobile());
    }

    private void goToAddAddress() {
        driver.findElement(By.cssSelector("#nav > ul > li:nth-child(2) > a")).click();
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
