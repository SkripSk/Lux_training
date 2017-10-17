package com.luxoft.sqa.webtest;

import com.luxoft.sqa.model.NewAddressData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestEditAddress extends TestBase {

    @Test
    public void testEditAddress(){
        app.getNavigationHelper().goToHome();
        int before = app.getContactHelper().getContactsCount();
        if (! app.getContactHelper().isThereContact()){
            app.getContactHelper().createContact(new NewAddressData("Lena", "sdf","sdf",null,"54543213"), true);
        }
        app.getContactHelper().selectFirstAddress();
        app.getContactHelper().clickEditButton();
        app.getContactHelper().fillAddAddressForm(new NewAddressData("dfsdfsfd","asdfsdfdsf","sdfsdf","","541654654654"), false);
        app.getContactHelper().updateAddress();
        int after = app.getContactHelper().getContactsCount();
        Assert.assertEquals(after,before);
    }
}
