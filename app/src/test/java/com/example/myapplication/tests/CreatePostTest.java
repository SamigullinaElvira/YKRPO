package com.example.myapplication.tests;
import static org.junit.Assert.assertEquals;

import com.example.myapplication.base.TestBase;
import com.example.myapplication.objects.AccountData;
import com.example.myapplication.objects.PostData;
import org.junit.Test;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class CreatePostTest extends TestBase {
    @Test
    public void testCreate() throws InterruptedException {
        app.getNavigationHelper().openHomePage();
        app.getNavigationHelper().setWindowSize();
        AccountData user = new AccountData("obviioussly@gmail.com", "secret88");
        app.getLoginHelper().login(user);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
        String currentTime = LocalTime.now().format(formatter);
        String postText = "HELLO";
        PostData expectedPostData = new PostData(currentTime, postText);
        Thread.sleep(100);
        app.getPostHelper().createPost(postText);
        Thread.sleep(100);

        PostData actualPostData = app.getPostHelper().getCreatedPostData();
        assertEquals(expectedPostData, actualPostData);
        app.getLoginHelper().logout();
    }
}