package com.luxoft.sqa.webtest;

import com.luxoft.sqa.model.NewAddressData;
import org.testng.annotations.Test;

public class TestAddNewAddress extends TestBase{

    @Test
    public void testAddNewAddress(){
        goToAddAddress();
        fillAddAddressForm(new NewAddressData("Lena", "Lera", "Skrip", "","+7(961)9592975"));
        submitAddAddressCreation();
    }
}
