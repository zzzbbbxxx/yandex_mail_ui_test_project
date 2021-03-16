package tests;

import org.openqa.selenium.support.PageFactory;
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

        PageFactory.initElements(driver, loginPage);
        PageFactory.initElements(driver, emailTabPage);
        PageFactory.initElements(driver, emailContentPage);
        PageFactory.initElements(driver, emailTabPage);
    }

    @Test
    public void scenario() {

        String emailSubject = "Задание для кандидата (черновик)";
        String emailSender = "m-v.m-d@yandex.ru";


        loginPage.openMailPage(mailOwner.LOGIN,mailOwner.PASSWORD);
        emailListPage.findBySenderAndSubject(emailSender,emailSubject);

        Assert.assertTrue(emailContentPage.isMessageTextCorrect("Черновая версия задания для кандидата"));
        Assert.assertTrue(emailContentPage.isAuthorCorrect("Мустафаев Магомед","m-v.m-d@yandex.ru"));
        Assert.assertTrue(emailContentPage.isSubjectCorrectV2("Задание для кандидата (черновик)"));

        emailTabPage.logOut();

    }



}