package com.luxoft.sqa.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

public class Application {

    WebDriver driver;

    SessionHelper sessionHelper;
    ContactHelper contactHelper;
    NovigationHelper novigationHelper;
    String browser;

    public Application(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser == BrowserType.CHROME){
            driver = new ChromeDriver();
        } else if (browser == BrowserType.IE) {
            driver = new InternetExplorerDriver();
        }
//        System.setProperty("webdriver.chrome.driver", "lib/drivers/chromedriver.exe");
//        driver = new ChromeDriver();

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
