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



    @Test
    public void gmailLoginShouldBeSuccessful(){

// SignIn
        // code refactoring complete for signIn part
        SignInPage signInPage = WebUtil.goToSignInPage(dr);

        signInPage.fillInUsername(dr);

        signInPage.fillInPassword(dr);

       EmailHomePage emailHomePage = signInPage.clickSignIn(dr);

        Assert.assertTrue("Inbox should exist", emailHomePage.isInboxExist(dr));


        // SIGNOUT

        signInPage  = emailHomePage.signOut(dr);

        Assert.assertTrue("signIn button should exist",signInPage.isSignInButtonExist(dr));
    }
    @Test
    public void gmailSendAndReseiveEmailTest(){
        SignInPage signInPage = WebUtil.goToSignInPage(dr);

        signInPage.fillInUsername(dr);

        signInPage.fillInPassword(dr);

        EmailHomePage emailHomePage = signInPage.clickSignIn(dr);

        Assert.assertTrue("Inbox should exist", emailHomePage.isInboxExist(dr));

            //COMPOSE EMAIL
        emailHomePage.clickComposeButton(dr);

        String recipient = "nazymhealthywater@gmail.com";
        emailHomePage.fillInRecipient(dr, recipient);

        String subject = "New message for you";
        emailHomePage.fillInSubjectLine(dr, subject);


        String bodyMessage = "Today is good time to code app";
        emailHomePage.fillInEmailBody(dr,bodyMessage);


        emailHomePage.clickSendEmail(dr);

        emailHomePage.clickInboxWithNewEmail(dr);

        EmailViewPage emailViewPage = emailHomePage.clickNewEmail(dr);

        emailViewPage.getEmailSubjectText(dr);

        Assert.assertEquals("Email subject text should be the same", subject, emailViewPage.getEmailSubjectText(dr));

        emailViewPage.getEmailBodyText(dr);

        Assert.assertEquals("Email body text should be the same", bodyMessage, emailViewPage.getEmailBodyText(dr));


        // SIGNOUT

        //Actions ms = new Actions(dr);

        signInPage = emailHomePage.signOut(dr);
        Assert.assertTrue("signIn button should exist",signInPage.isSignInButtonExist(dr));
    }

    @After
    public  void closeBrowser(){
        // changes

       dr.close();
    }
}
