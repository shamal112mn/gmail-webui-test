package com.appsenseca.util;

import com.appsenseca.pageobjects.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by shamal on 9/14/2016.
 */
public class WebUtil {
    public static SignInPage goToSignInPage(WebDriver dr, WebDriverWait wd) {
        dr.get("http://gmail.com");
        return PageFactory.initElements(dr, SignInPage.class);
    }


}
