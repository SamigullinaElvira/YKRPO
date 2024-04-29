package com.example.myapplication.helpers;

import com.example.myapplication.AppManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PostHelper extends HelperBase {
    public PostHelper(AppManager manager) {
        super(manager);
    }

    public void createPost(String postText) {
        driver.findElement(By.cssSelector(".menu-item__title")).click();
        {
            WebElement element = driver.findElement(By.xpath("//div[@id=\'editor-content\']/div"));
            js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = arguments[1]}", element, postText);
        }
        driver.findElement(By.cssSelector(".lg\\3A block")).click();
    }
}
