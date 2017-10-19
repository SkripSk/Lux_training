package com.luxoft.sqa.webtest;

import com.luxoft.sqa.model.ContactData;
import com.luxoft.sqa.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactCreateTests extends TestBase{

    @Test(enabled = false)
    public void NewContactTests(){
        app.getNavigationHelper().goToHome();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().goToAddAddress();
        ContactData contact = new ContactData("Lena", "Lera", "Skrip", "","+7(961)9592975");
        app.getContactHelper().fillAddAddressForm(contact,true);
        app.getContactHelper().submitAddAddressCreation();
        List<ContactData> after = app.getContactHelper().getContactList();
        Comparator<? super ContactData> byId = (Comparator<ContactData>) (o1, o2) -> Integer.compare(o1.getId(),o2.getId());
        before.add(contact);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before , after);
    }
}
