package com.luxoft.sqa.webtest;

import org.testng.annotations.Test;

public class TestDeleteAllAddresses extends TestBase{

    @Test
    public void testDeleteAllAddresses() {
        goToHome();
        selectAllAddresses();
        deletedAllAddresses();
    }
}
