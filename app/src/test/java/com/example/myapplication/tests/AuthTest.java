package com.example.myapplication.tests;

import com.example.myapplication.base.TestBase;
import com.example.myapplication.objects.AccountData;

import org.junit.Test;


public class AuthTest extends TestBase {
    @Test
    public void testAuth() {
        app.getNavigationHelper().openHomePage();
        app.getNavigationHelper().setWindowSize();
        AccountData user = new AccountData("obviioussly@gmail.com", "secret88");
        app.getLoginHelper().login(user);
        System.out.println("1");
    }
}
