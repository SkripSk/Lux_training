package com.luxoft.sqa.webtest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactAllDeletionTests extends TestBase{

    @Test(enabled = false)
    public void testDeleteAllAddresses() {
        app.getNavigationHelper().goToHome();
        app.getContactHelper().selectAllAddresses();
        app.getContactHelper().deletedContacts();
        int after = app.getContactHelper().getContactsCount();
        Assert.assertEquals(after,0);
    }
}
