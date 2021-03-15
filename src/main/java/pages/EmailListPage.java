package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class EmailListPage extends BasePage {

    public EmailListPage(WebDriver driver) {
        super(driver);
    }

    public void findByAuthorEmail(String email) {

        String xpath = String.format("(//*[contains(@class,'MessagesList')]" +
                "//*[contains(@class,'MessageSnippet-Item_sender')]//*[@title='%s'])[1]",email);

        clickOn(xpath);
    }

    public void findByAuthorName(String name) {

        String xpath = String.format("(//*[contains(@class,'MessagesList')]" +
                "//*[contains(@class,'MessageSnippet-Item_sender')]//*[contains(text(),'%s')])[1]",name);

        clickOn(xpath);
    }

    public void findBySubject(String subject) {

        String xpath = String.format("(//*[contains(@class,'MessagesList')]" +
                "//*[contains(@class,'Item_subject')]//*[@title='%s'])[1]",subject);

        clickOn(xpath);
    }

    public void openFirstEmail(){

        clickOn("(//*[contains(@class,'messages-scroll-area')]" +
                "//*[contains(@class,'Item_subject')])[1]");

    }

    public void findBySenderAndSubject(String sender, String subject){

        String name = "";
        String email = "";

        if (sender.contains("@")) email = sender;
        else name = sender;

        String xpath = String.format("//*[contains(@class,'mail-MessageSnippet-Content')]" +
                "//*[contains(@class,'Item_sender')]" +
                "//*[text()='%s' or @title='%s']" +
                "//following:://*[contains(@class,'Item_subject')]" +
                "//*[@title='%s']",name,email,subject);

        clickOn(xpath);
    }

}
