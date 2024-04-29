package com.example.myapplication.tests;

import com.example.myapplication.base.TestBase;
import com.example.myapplication.objects.AccountData;

import org.junit.Test;

public class CreatePostTest extends TestBase {
    @Test
    public void testCreate() throws InterruptedException {
        app.getNavigationHelper().openHomePage();
        app.getNavigationHelper().setWindowSize();
        AccountData user = new AccountData("obviioussly@gmail.com", "secret88");
        app.getLoginHelper().login(user);
        app.getPostHelper().createPost("HELLO");
        Thread.sleep(10);
    }
}
