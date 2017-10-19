package com.luxoft.sqa.webtest;

import com.luxoft.sqa.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;


public class GroupDeletionTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() {
        app.getNavigationHelper().goToGroupPage();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData()
                    .setName("test1")
                    .setFooter("test2")
                    .setHeader("test3"));
        }
    }

        @Test
    public void testGroupDeletion() {
        Set<GroupData> before = app.getGroupHelper().getGroupAll();
        GroupData deletedGroupe = before.iterator().next();
        app.getGroupHelper().delete(deletedGroupe);
        Set<GroupData> after = app.getGroupHelper().getGroupAll();
        before.remove(deletedGroupe);
        Assert.assertEquals(after , before);
    }

}