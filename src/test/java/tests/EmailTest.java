package tests;

import org.openqa.selenium.support.PageFactory;
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

        PageFactory.initElements(driver, loginPage);
        PageFactory.initElements(driver, emailListPage);
        PageFactory.initElements(driver, emailContentPage);

    }

    @Test
    public void subjectTest()  {
        String emailSubject = "Кандидатская работа (черновик)";

        loginPage.openMailPage(mailOwner.LOGIN,mailOwner.PASSWORD);
        emailListPage.openLastEmail();
        Assert.assertTrue(emailContentPage.isSubjectCorrectV2(emailSubject));
    }

    @Test
    public void senderTest() {
        String senderName = "Мустафаев Магомед";
        String senderEmail = "m-v.m-d@yandex.ru";

        loginPage.openMailPage(mailOwner.LOGIN,mailOwner.PASSWORD);
        emailListPage.openLastEmail();
        Assert.assertTrue(emailContentPage.isAuthorCorrect(senderName, senderEmail));
    }

    @Test
    public void contentTest() {
        String emailText = "Текст для кандидатской работы - черновик";

        loginPage.openMailPage(mailOwner.LOGIN,mailOwner.PASSWORD);
        emailListPage.openLastEmail();
        Assert.assertTrue(emailContentPage.isMessageTextCorrect(emailText));
    }

}
