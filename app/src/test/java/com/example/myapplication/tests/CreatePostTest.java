package com.example.myapplication.tests;
import static org.junit.Assert.assertEquals;

import com.example.myapplication.base.TestBase;
import com.example.myapplication.objects.AccountData;
import com.example.myapplication.objects.PostData;

import org.junit.Test;

import java.time.LocalTime;

public class CreatePostTest extends TestBase {
    @Test
    public void testCreate() throws InterruptedException {
        app.getNavigationHelper().openHomePage();
        app.getNavigationHelper().setWindowSize();
        AccountData user = new AccountData("obviioussly@gmail.com", "secret88");
        app.getLoginHelper().login(user);

        String time = LocalTime.now().getHour() + ":" + LocalTime.now().getMinute();
        PostData expectedPostData = new PostData(time, "HELLO");
        app.getPostHelper().createPost("HELLO");
        Thread.sleep(10);

        PostData postData = app.getPostHelper().getCreatedPostData();
        assertEquals(expectedPostData, postData);
    }
}
