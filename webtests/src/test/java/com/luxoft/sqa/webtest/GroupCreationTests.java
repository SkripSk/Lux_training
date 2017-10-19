package com.luxoft.sqa.webtest;

import com.luxoft.sqa.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Set;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().goToGroupPage();
        Set<GroupData> before = app.getGroupHelper().getGroupAll();
        GroupData group = new GroupData()
                .setName("test1")
                .setFooter("test2")
                .setHeader("test3");
        app.getGroupHelper().createGroup(group);
        Set<GroupData> after = app.getGroupHelper().getGroupAll();
        group.setId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        before.add(group);
        Assert.assertEquals(before , after);
    }
}