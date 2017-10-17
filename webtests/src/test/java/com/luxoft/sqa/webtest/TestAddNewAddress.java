package com.luxoft.sqa.webtest;

import com.luxoft.sqa.model.NewAddressData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAddNewAddress extends TestBase{

    @Test
    public void testAddNewAddress(){
        app.getNavigationHelper().goToHome();
        int before = app.getContactHelper().getContactsCount();
        app.getNavigationHelper().goToAddAddress();
        app.getContactHelper().fillAddAddressForm(new NewAddressData("Lena", "Lera", "Skrip", "","+7(961)9592975"),true);
        app.getContactHelper().submitAddAddressCreation();
        int after = app.getContactHelper().getContactsCount();
        Assert.assertEquals(after,before + 1);
        app.getSessionHelper().logout();
    }
}
