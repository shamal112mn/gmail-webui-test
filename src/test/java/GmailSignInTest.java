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
import static org.openqa.selenium.By.cssSelector;


  //Created by shamal on 8/28/2016.

public class GmailSignInTest{
    WebDriver dr = new FirefoxDriver();
    WebDriverWait wd = new WebDriverWait(dr, 30);


    @Test
    public void gmailLoginShouldBeSuccessful(){

// SignIn
        // vcs 7
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
        WebElement profileButton = dr.findElement(By.xpath("//span[@class='gb_7a gbii']"));
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
        WebElement composeEmail = dr.findElement(By.xpath(".//*[@class='aic']/div/div"));
        composeEmail.click();


        WebElement emailAddress = By.name("to").findElement(dr);

        emailAddress.sendKeys("nazymhealthywater@gmail.com");
        String subject = "New message for you";

        WebElement subjectLine = By.name("subjectbox").findElement(dr);
        subjectLine.sendKeys(subject);

        String bodyMessage = "Today is good time to code app";
        WebElement emailBody = By.xpath("//div[@aria-label='Message Body']").findElement(dr);
        emailBody.sendKeys(bodyMessage);


        WebElement sendButton = By.xpath("//div[starts-with(@aria-label,'Send')]").findElement(dr);
        sendButton.click();

        wd.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Inbox (1)")));
        WebElement inboxLinkage = By.linkText("Inbox (1)").findElement(dr);
        inboxLinkage.click();

        wd.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='y6']>span[id]>b")));
        WebElement newEmail = By.cssSelector("div[class='y6']>span[id]>b").findElement(dr);
        newEmail.click();

        wd.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2[class='hP']")));
        WebElement subjectArea = By.cssSelector("h2[class='hP']").findElement(dr);
        Assert.assertEquals("Email subject text should be the same", subject, subjectArea.getText());

        WebElement bodyArea = By.xpath("//div[@class='nH'][@role='list']/div/div/div/div/div/div[1]/div[2]/div[7]/div/div[1]").findElement(dr);
        Assert.assertEquals("Email body text should be the same", bodyMessage, bodyArea.getText());


        // SIGNOUT

        //Actions ms = new Actions(dr);
        wd.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='gb_7a gbii']")));
        WebElement profileButton = dr.findElement(By.xpath("//span[@class='gb_7a gbii']"));
        profileButton.click();

        wd.until(ExpectedConditions.elementToBeClickable(By.id("gb_71")));
        WebElement signOutLinkage = dr.findElement(By.id("gb_71"));
        signOutLinkage.click();




    }

    @After
    public  void closeBrowser(){
        // changes

        dr.close();
    }
}
