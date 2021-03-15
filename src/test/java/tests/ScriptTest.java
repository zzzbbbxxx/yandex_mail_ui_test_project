package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.EmailContentPage;
import pages.EmailListPage;
import pages.EmailTabPage;
import pages.LoginPage;
import tests.base.BaseTest;
import users.mailOwner;


public class ScriptTest extends BaseTest {

    private LoginPage loginPage;
    private EmailListPage emailListPage;
    private EmailContentPage emailContentPage;
    private EmailTabPage emailTabPage;

    @BeforeMethod
    public void initPages() {
        loginPage = new LoginPage(driver);
        emailListPage = new EmailListPage(driver);
        emailContentPage = new EmailContentPage(driver);
        emailTabPage = new EmailTabPage(driver);
    }

    @Test
    public void scenario() {

        loginPage.openMailPage(mailOwner.LOGIN,mailOwner.PASSWORD);
        emailListPage.findBySenderAndSubject("","");

        Assert.assertTrue(emailContentPage.isTextCorrect(""));
        Assert.assertTrue(emailContentPage.isAuthorCorrect("",""));
        Assert.assertTrue(emailContentPage.isSubjectCorrectV2(""));

        emailTabPage.logOut();

    }



}