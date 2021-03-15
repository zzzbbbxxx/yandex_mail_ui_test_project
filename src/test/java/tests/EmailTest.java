package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.EmailContentPage;
import pages.EmailListPage;
import pages.LoginPage;
import tests.base.BaseTest;
import users.mailOwner;

public class EmailTest extends BaseTest {

    private LoginPage loginPage;
    private EmailListPage emailListPage;
    private EmailContentPage emailContentPage;

    @BeforeMethod
    public void initPages() {
        loginPage = new LoginPage(driver);
        emailListPage = new EmailListPage(driver);
        emailContentPage = new EmailContentPage(driver);
    }

    @Test
    public void subjectTest()  {
        String emailSubject = "";

        loginPage.openMailPage(mailOwner.LOGIN,mailOwner.PASSWORD);
        emailListPage.openFirstEmail();
        Assert.assertTrue(emailContentPage.isSubjectCorrectV2(emailSubject));
    }

    @Test
    public void senderTest() {
        String senderName = "";
        String senderEmail = "";

        loginPage.openMailPage(mailOwner.LOGIN,mailOwner.PASSWORD);
        emailListPage.openFirstEmail();
        Assert.assertTrue(emailContentPage.isAuthorCorrect(senderName, senderEmail));
    }

    @Test
    public void contentTest() {
        String emailText = "";

        loginPage.openMailPage(mailOwner.LOGIN,mailOwner.PASSWORD);
        emailListPage.openFirstEmail();
        Assert.assertTrue(emailContentPage.isTextCorrect(emailText));
    }

    @Test
    public void searchEmailTest()  {
        String senderEmail = "";
        String senderName = "";

        loginPage.openMailPage(mailOwner.LOGIN,mailOwner.PASSWORD);
        emailListPage.findByAuthorEmail(senderEmail);
        Assert.assertTrue(emailContentPage.isAuthorCorrect(senderName, senderEmail));

    }
}
