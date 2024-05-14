package com.example.myapplication.tests;
import static org.junit.Assert.assertEquals;

import com.example.myapplication.DataRetriever;
import com.example.myapplication.base.TestBase;
import com.example.myapplication.objects.AccountData;
import com.example.myapplication.objects.PostData;

import org.junit.Test;

import java.time.LocalTime;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;

public class CreatePostTest extends TestBase {
    @ParameterizedTest
    @ValueSource(strings = {"/storage/test.xml"})
    public void test(String fileName) throws IOException, InterruptedException {
        app.getNavigationHelper().openHomePage();
        app.getNavigationHelper().setWindowSize();
        AccountData user = new AccountData("obviioussly@gmail.com", "secret88");
        app.getLoginHelper().login(user);

        PostData[] postDataArray = (PostData[]) DataRetriever.retrieveData(fileName, PostData[].class);

        for (PostData expectedPostData : postDataArray) {
            app.getPostHelper().createPost(expectedPostData.getText());
            Thread.sleep(10);

            PostData postData = app.getPostHelper().getCreatedPostData();
            assertEquals(expectedPostData, postData);
        }

        app.getLoginHelper().logout();
    }
}

