package com.luxoft.sqa.webtest;

import org.testng.annotations.Test;

public class TestDeleteContact extends TestBase {

    @Test
    public void testDeleteContact(){
        app.getNavigationHelper().goToHome();
        app.getContactHelper().selectFirstAddress();
        app.getContactHelper().deletedContacts();
    }
}
