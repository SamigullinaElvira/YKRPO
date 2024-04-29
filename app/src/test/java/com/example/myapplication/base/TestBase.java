package com.example.myapplication.base;

import com.example.myapplication.AppManager;

import org.junit.After;
import org.junit.Before;
public class TestBase {
    protected static AppManager app;
    @Before
    public void setUp() {
        app = new AppManager();
    }

    @After
    public void tearDown() {
        app.stop();
    }
}
