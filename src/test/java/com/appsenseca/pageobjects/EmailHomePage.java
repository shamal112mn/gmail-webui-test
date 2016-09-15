package com.appsenseca.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by shamal on 9/14/2016.
 */
public class EmailHomePage {


    public SignInPage signOut(WebDriver dr, WebDriverWait wd) {
        WebElement profileButton = dr.findElement(By.xpath("//span[@class='gb_7a gbii']"));
        profileButton.click();
        WebElement signOutLinkage = dr.findElement(By.id("gb_71"));
        signOutLinkage.click();
        //WebDriverWait wd = new WebDriverWait(dr, 30);
        wd.until(ExpectedConditions.elementToBeClickable(By.id("signIn")));
        return PageFactory.initElements(dr, SignInPage.class);
    }

    public boolean isInboxExist(WebDriver dr, WebDriverWait wd) {
        //WebDriverWait wd = new WebDriverWait(dr, 30);
        wd.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
    return dr.findElements(By.partialLinkText("Inbox")).size()>0;
    }
}