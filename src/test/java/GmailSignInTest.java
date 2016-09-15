import com.appsenseca.pageobjects.EmailHomePage;
import com.appsenseca.pageobjects.EmailViewPage;
import com.appsenseca.util.WebUtil;
import com.appsenseca.pageobjects.SignInPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


//Created by shamal on 8/28/2016.

public class GmailSignInTest{
    WebDriver dr = new FirefoxDriver();
    WebDriverWait wd = new WebDriverWait(dr, 30);


    @Test
    public void gmailLoginShouldBeSuccessful(){

// SignIn
        // vcs 8
        SignInPage signInPage = WebUtil.goToSignInPage(dr, wd);

        signInPage.fillInUsername(dr,wd, "nazymhealthywater");

        signInPage.fillInPassword(dr, wd, "Arlen@470317");

       EmailHomePage emailHomePage = signInPage.clickSignIn(dr, wd);

        Assert.assertTrue("Inbox should exist", emailHomePage.isInboxExist(dr, wd));


        // SIGNOUT

        signInPage  = emailHomePage.signOut(dr, wd);

        Assert.assertTrue("signIn button should exist",signInPage.isSignInButtonExist(dr, wd));
    }
    @Test
    public void gmailSendAndReseiveEmailTest(){
        SignInPage signInPage = WebUtil.goToSignInPage(dr, wd);

        signInPage.fillInUsername(dr,wd, "nazymhealthywater");

        signInPage.fillInPassword(dr, wd, "Arlen@470317");

        EmailHomePage emailHomePage = signInPage.clickSignIn(dr, wd);

        Assert.assertTrue("Inbox should exist", emailHomePage.isInboxExist(dr, wd));

            //COMPOSE EMAIL
        emailHomePage.clickComposeButton(dr, wd);

        String recipient = "nazymhealthywater@gmail.com";
        emailHomePage.fillInRecipient(dr, wd, recipient);

        String subject = "New message for you";
        emailHomePage.fillInSubjectLine(dr, wd, subject);


        String bodyMessage = "Today is good time to code app";
        emailHomePage.fillInEmailBody(dr,wd,bodyMessage);


        emailHomePage.clickSendEmail(dr);

        emailHomePage.clickInboxWithNewEmail(dr,wd);

        EmailViewPage emailViewPage = emailHomePage.clickNewEmail(dr,wd);

        emailViewPage.getEmailSubjectText(dr, wd);

        Assert.assertEquals("Email subject text should be the same", subject, emailViewPage.getEmailSubjectText(dr,wd));

        emailViewPage.getEmailBodyText(dr);

        Assert.assertEquals("Email body text should be the same", bodyMessage, emailViewPage.getEmailBodyText(dr));


        // SIGNOUT

        //Actions ms = new Actions(dr);
        emailHomePage.signOut(dr,wd);

    }

    @After
    public  void closeBrowser(){
        // changes

        dr.close();
    }
}
