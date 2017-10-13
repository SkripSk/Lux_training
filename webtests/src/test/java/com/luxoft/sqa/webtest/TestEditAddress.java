package com.luxoft.sqa.webtest;

import com.luxoft.sqa.model.NewAddressData;
import org.testng.annotations.Test;

public class TestEditAddress extends TestBase {

    @Test
    public void testEditAddress(){
        app.getNovigationHelper().goToHome();
        app.getContactHelper().selectFirstAddress();
        app.getContactHelper().clickEditButton();
        app.getContactHelper().fillAddAddressForm(new NewAddressData("dfsdfsfd","asdfsdfdsf","sdfsdf","","541654654654"));
        app.getContactHelper().updateAddress();
    }
}
