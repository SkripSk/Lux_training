package com.luxoft.sqa.framework;

import com.luxoft.sqa.model.ContactData;
import com.luxoft.sqa.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void submitAddAddressCreation() {
        click(By.cssSelector("#content > form > input[type=\"submit\"]:nth-child(87)"));
    }

    public void fillAddAddressForm(ContactData newAddressData, boolean creation) {
        type(By.name("firstname"), newAddressData.getFirstName());
        type(By.name("middlename"), newAddressData.getMiddleNameOrInital());
        type(By.name("lastname"), newAddressData.getLastName());
        type(By.name("mobile"), newAddressData.getTelephoneMobile());
        if (isElementPresent(By.name("new_group"))
                && creation) {
            new Select(driver.findElement(By.name("new_group"))).selectByIndex(0);
        }
    }

    public void deletedContacts() {
        click(By.cssSelector("#content > form:nth-child(10) > div:nth-child(8) > input[type=\"button\"]"));
        driver.switchTo().alert().accept();
    }

    public void selectAllAddresses() {
        click(By.id("MassCB"));
    }

    public void updateAddress() {
        click(By.cssSelector("#content > form:nth-child(2) > input[type=\"submit\"]:nth-child(86)"));
    }

    public void clickEditButton() {
        click(By.cssSelector("#maintable > tbody > tr:nth-child(2) > td:nth-child(8) > a > img"));
    }

    public void selectFirstAddress() {
        click(By.name("selected[]"));
    }

    public boolean isThereContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void createContact(ContactData newAddressData, boolean creation) {
        NavigationHelper app = new NavigationHelper(driver);
        app.goToAddAddress();
        fillAddAddressForm(newAddressData, creation);
        submitAddAddressCreation();
        click(By.cssSelector("#content > div > i > a:nth-child(2)"));
    }

    public int getContactsCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.cssSelector("input"));
        for (WebElement element: elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData(id, name, null, null, null, null);
            contacts.add(contact);
        }
        return null;
    }
}
