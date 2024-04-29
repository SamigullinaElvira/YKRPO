package com.example.myapplication;

import com.example.myapplication.helpers.LoginHelper;
import com.example.myapplication.helpers.NavigationHelper;
import com.example.myapplication.helpers.PostHelper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class AppManager {
    private String baseURL;
    protected WebDriver driver;
    protected JavascriptExecutor js;
    private static ThreadLocal<AppManager> app = new ThreadLocal<>();
    private NavigationHelper navigation;
    private LoginHelper auth;
    private PostHelper post;

    private AppManager() {
        baseURL = "https://web.mindlog.app/";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        post = new PostHelper(this);
        auth = new LoginHelper(this);
        navigation = new NavigationHelper(this, baseURL);
    }

    public static AppManager getInstance() {
        if (app.get() == null) {
            AppManager newInstance = new AppManager();
            newInstance.getNavigationHelper().openHomePage();
            app.set(newInstance);
        }
        return app.get();
    }

    public WebDriver getDriver() {
        return driver;
    }
    public JavascriptExecutor getJs() {
        return js;
    }

    public NavigationHelper getNavigationHelper() {
        return navigation;
    }

    public LoginHelper getLoginHelper() {
        return auth;
    }

    public PostHelper getPostHelper() {
        return post;
    }

    public void stop() {
        try {
            driver.quit();
        } catch (Exception ignored) {
            // Игнорируем исключения при завершении работы драйвера
        }
    }
}
