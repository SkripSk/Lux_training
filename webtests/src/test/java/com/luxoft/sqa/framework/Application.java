package com.luxoft.sqa.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Application {

    WebDriver driver;

    SessionHelper sessionHelper;
    ContactHelper contactHelper;
    NovigationHelper novigationHelper;

    public void init() {
        System.setProperty("webdriver.chrome.driver", "lib/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        contactHelper = new ContactHelper(driver);
        sessionHelper = new SessionHelper(driver);
        novigationHelper = new NovigationHelper(driver);

        driver.manage().window().maximize();
        driver.get("http://localhost:8080/addressbook/edit.php");
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        driver.quit();
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

    public NovigationHelper getNovigationHelper(){
        return novigationHelper;
    }
}
