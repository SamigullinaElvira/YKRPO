package com.example.myapplication.helpers;

import com.example.myapplication.AppManager;
import com.example.myapplication.objects.PostData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    public PostData getCreatedPostData() {
        List<WebElement> noteElements = driver.findElements(By.cssSelector(".notes-list-item"));
        WebElement latestNoteElement = noteElements.get(noteElements.size() - 1);
        String time = latestNoteElement.findElement(By.cssSelector(".note-time")).getText();
        String text = latestNoteElement.findElement(By.cssSelector(".text-format")).getText();
        return new PostData(time, text);
    }


}

