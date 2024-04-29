package com.example.myapplication.base;

import com.example.myapplication.AppManager;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestBase {
    protected static AppManager app;
    @Before
    public void setUp() {
        app = AppManager.getInstance();
    }
}
