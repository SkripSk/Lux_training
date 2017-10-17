package com.luxoft.sqa.webtest;

import com.luxoft.sqa.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().goToGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().createGroup(new GroupData("test1" , "test2" , "test3"));
        List<GroupData> after = app.getGroupHelper().getGroupList();
        app.getSessionHelper().logout();
        Assert.assertEquals(after.size() , before.size() + 1);
    }
}