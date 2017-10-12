package com.luxoft.sqa.webtest;

import com.luxoft.sqa.model.NewAddressData;
import org.testng.annotations.Test;

public class TestEditAddress extends TestBase {

    @Test
    public void testEditAddress(){
        goToHome();
        selectFirstAddress();
        clickEditButton();
        fillAddAddressForm(new NewAddressData("dfsdfsfd","asdfsdfdsf","sdfsdf","","541654654654"));
        updateAddress();
    }
}
