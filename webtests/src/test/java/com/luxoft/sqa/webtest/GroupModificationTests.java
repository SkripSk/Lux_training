package com.luxoft.sqa.webtest;

import com.luxoft.sqa.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        app.getNavigationHelper().goToGroupPage();
        if(! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData()
                    .setName("test1")
                    .setFooter("test2")
                    .setHeader("test3"));
        }
    }

    @Test
    public void testGroupModification() {
        Set<GroupData> before = app.getGroupHelper().getGroupAll();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .setId(modifiedGroup.getId())
                .setName("test1")
                .setFooter("test2")
                .setHeader("test3");
        app.getGroupHelper().modifyGroup(group);
        Set<GroupData> after = app.getGroupHelper().getGroupAll();
        before.remove(modifiedGroup);
        before.add(group);
        Assert.assertEquals(before , after);
    }

}
