package com.appsenseca.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by shamal on 9/14/2016.
 */
public class SignInPage {

    public void fillInUsername(WebDriver dr,WebDriverWait wd, String s) {
        wd.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Email']")));
        By.xpath("//input[@id='Email']").findElement(dr).sendKeys(s);
        dr.findElement(By.id("next")).click();
    }

    public void fillInPassword(WebDriver dr, WebDriverWait wd, String s) {
        //WebDriverWait wd = new WebDriverWait(dr, 30);
        wd.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));
        dr.findElement(By.id("Passwd")).sendKeys(s);

    }

    public EmailHomePage clickSignIn(WebDriver dr, WebDriverWait wd) {
        dr.findElement(By.id("signIn")).click();

        wd.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
        return PageFactory.initElements(dr, EmailHomePage.class);
    }

    public boolean isSignInButtonExist(WebDriver dr, WebDriverWait wd) {
        wd.until(ExpectedConditions.visibilityOfElementLocated(By.id("signIn")));
         return dr.findElements(By.id("signIn")).size()>0;
    }
}
