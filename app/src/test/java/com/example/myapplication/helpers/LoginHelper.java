package com.example.myapplication.helpers;

import com.example.myapplication.AppManager;
import com.example.myapplication.objects.AccountData;

import org.openqa.selenium.By;

public class LoginHelper extends HelperBase {
    public LoginHelper(AppManager manager) {
        super(manager);
    }

    public void login(AccountData user) {
        driver.findElement(By.id("form__input-email")).click();
        driver.findElement(By.id("form__input-email")).sendKeys(user.getLogin());
        driver.findElement(By.id("form__input-password")).click();
        driver.findElement(By.id("form__input-password")).sendKeys(user.getPassword());
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
    }
}
