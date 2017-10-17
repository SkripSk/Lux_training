package com.luxoft.sqa.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class Application {

    WebDriver driver;

    SessionHelper sessionHelper;
    ContactHelper contactHelper;
    GroupHelper groupHelper;
    NavigationHelper novigationHelper;
    String browser;

    public Application(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser.equals(BrowserType.CHROME)) {
            driver = new ChromeDriver();
        } else if (browser.equals(BrowserType.IE)) {
            driver = new InternetExplorerDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        groupHelper = new GroupHelper(driver);
        contactHelper = new ContactHelper(driver);
        sessionHelper = new SessionHelper(driver);
        novigationHelper = new NavigationHelper(driver);

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

    public NavigationHelper getNavigationHelper(){
        return novigationHelper;
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }
}
