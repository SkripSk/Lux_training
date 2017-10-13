package com.luxoft.sqa.webtest;

import com.luxoft.sqa.framework.Application;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    public Application app = new Application();

    @BeforeMethod
    public void setup(){
        app.init();
    }

    @AfterMethod
    public void tearDown(){
        app.stop();
    }
}
