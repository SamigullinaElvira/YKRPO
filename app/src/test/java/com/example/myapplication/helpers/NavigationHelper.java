package com.example.myapplication.helpers;

import com.example.myapplication.AppManager;

import org.openqa.selenium.Dimension;

public class NavigationHelper extends HelperBase {
    private String baseURL;
    public NavigationHelper(AppManager manager, String baseURL) {
        super(manager);
        this.baseURL = baseURL;
    }

    public void setWindowSize() {
        driver.manage().window().setSize(new Dimension(1200, 812));
    }
    public void openHomePage() {
        driver.get(baseURL);
    }
}
