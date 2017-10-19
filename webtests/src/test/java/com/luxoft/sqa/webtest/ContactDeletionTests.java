package com.luxoft.sqa.webtest;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test(enabled = false)
    public void testDeleteContact(){
        app.getNavigationHelper().goToHome();
        app.getContactHelper().selectFirstAddress();
        app.getContactHelper().deletedContacts();
    }
}
