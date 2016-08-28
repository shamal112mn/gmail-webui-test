import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

/**
 * Created by shamal on 8/28/2016.
 */
public class GmailSignInTest{
    WebDriver dr = new FirefoxDriver();
    WebDriverWait wd = new WebDriverWait(dr, 30);


    @Test
    public void gmailLoginShouldBeSuccessful(){

// SignIn
        dr.get("http://gmail.com/");
        System.out.println(dr.getTitle());
        dr.findElement(By.xpath("//input[@id='Email']")).sendKeys("nazymhealthywater");
        dr.findElement(By.id("next")).click();


        wd.until(ExpectedConditions.elementToBeClickable(By.id("Passwd")));
        // Thread.sleep(1000);
        dr.findElement(By.id("Passwd")).sendKeys("Arlen@470317");
        dr.findElement(By.id("signIn")).click();
        wd.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
        Assert.assertTrue("Inbox should exist", dr.findElements(By.partialLinkText("Inbox")).size()>0);


        // SIGNOUT

        //Actions ms = new Actions(dr);
        WebElement profileButton = dr.findElement(By.xpath("//span[@class='gb_3a gbii']"));
        profileButton.click();

        WebElement signOutLinkage = dr.findElement(By.id("gb_71"));
        signOutLinkage.click();
        wd.until(ExpectedConditions.visibilityOfElementLocated(By.id("signIn")));
        Assert.assertTrue("signIn button should exist", dr.findElements(By.id("signIn")).size()>0);
    }
    @Test
    public void gmailSendAndReseiveEmailTest(){
        dr.get("http://gmail.com/");
        System.out.println(dr.getTitle());
        dr.findElement(By.xpath("//input[@id='Email']")).sendKeys("nazymhealthywater");
        dr.findElement(By.id("next")).click();


        wd.until(ExpectedConditions.elementToBeClickable(By.id("Passwd")));
        // Thread.sleep(1000);
        dr.findElement(By.id("Passwd")).sendKeys("Arlen@470317");
        dr.findElement(By.id("signIn")).click();
        wd.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
        Assert.assertTrue("Inbox should exist", dr.findElements(By.partialLinkText("Inbox")).size()>0);

            //Compose email
        WebElement composeEmail = dr.findElement(By.id(":en"));
        composeEmail.click();
        WebElement emailAddress = By.name("to").findElement(dr);

        emailAddress.sendKeys("nazymhealthywater@gmail.com");

        WebElement subjectLine = By.name("subjectbox").findElement(dr);
        subjectLine.sendKeys("New message for you");

        WebElement emailBody = By.xpath("//div[@aria-label='Message Body']").findElement(dr);
        emailBody.sendKeys("Today is good time to code app");

        WebElement sendButton = By.xpath("//div[starts-with(@aria-label,'Send')]").findElement(dr);

        sendButton.click();





    }

//    @After
//    public  void closeBrowser(){
//        // changes
//
//        dr.close();
//    }
 }