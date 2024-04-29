package com.example.myapplication.helpers;

import com.example.myapplication.AppManager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HelperBase {
    protected AppManager manager;
    protected WebDriver driver;
    protected JavascriptExecutor js;

    public HelperBase(AppManager manager) {
        this.manager = manager;
        this.driver = manager.getDriver();
        this.js = manager.getJs();
    }
}
