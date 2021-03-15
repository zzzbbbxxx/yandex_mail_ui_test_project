package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.EmailTabPage;
import pages.LoginPage;
import tests.base.BaseTest;
import users.mailOwner;

public class LoginTest extends BaseTest {

   private LoginPage loginPage;
   private EmailTabPage emailTabPage;

    @BeforeMethod
    public void initPages() {
        loginPage = new LoginPage(driver);
        emailTabPage = new EmailTabPage(driver);

    }

    @Test
    public void loginToEmail() {

        loginPage.openLoginPage();
        loginPage.enterLoginV2(mailOwner.LOGIN);
        loginPage.enterPasswordV2(mailOwner.PASSWORD);
        Assert.assertTrue(loginPage.isStartPageOpen());

    }

    @Test
    public void logOut() {
        loginPage.openMailPage(mailOwner.LOGIN,mailOwner.PASSWORD);
        emailTabPage.logOut();
        Assert.assertTrue(emailTabPage.isLogOut());
    }


}
