package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class EmailListPage extends BasePage {

    @FindBy(xpath = "(//*[contains(@class,'messages-scroll-area')]//*[contains(@class,'Item_subject')])[1]")
    public WebElement lastIncomingEmail;

    public EmailListPage(WebDriver driver) {
        super(driver);
    }

    public void findByAuthorEmail(String email) {

        WebElement webElement = getWebElementFromFormattedXpathString(
                "(//*[contains(@class,'MessagesList')]" +
                "//*[contains(@class,'MessageSnippet-Item_sender')]//*[@title='%s'])[1]",email);

        clickOn(webElement);
    }

    public void findByAuthorName(String name) {

        WebElement webElement = getWebElementFromFormattedXpathString(
                "(//*[contains(@class,'MessagesList')]" +
                "//*[contains(@class,'MessageSnippet-Item_sender')]//*[contains(text(),'%s')])[1]",name);

        clickOn(name);
    }

    public void findBySubject(String subject) {

        WebElement webElement = getWebElementFromFormattedXpathString(
                "(//*[contains(@class,'MessagesList')]" +
                "//*[contains(@class,'Item_subject')]//*[@title='%s'])[1]",subject);

        clickOn(subject);
    }

    public void openLastEmail(){

        clickOn(lastIncomingEmail);

    }

    public void findBySenderAndSubject(String sender, String subject){

        String name = "";
        String email = "";

        if (sender.contains("@")) email = sender;
        else name = sender;

        WebElement webElement = getWebElementFromFormattedXpathString(
                "//*[contains(@class,'mail-MessageSnippet-Content')]" +
                "//*[contains(@class,'Item_sender')]" +
                "//*[text()='%s' or @title='%s']//following::*[contains(@class,'Item_subject')]//*[@title='%s']"
                ,name,email,subject);

        clickOn(webElement);
    }

}
