package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class EmailContentPage extends BasePage {

    public EmailContentPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSubjectCorrectV2(String subject) {
        String xpath = String.format("//*[contains(@class,'mail-Message-Content')]" +
                "//*[contains(@class,'mail-Message-Toolbar-Subject_message') " +
                "and text()= '%s']",subject);

        return isElementPresent(xpath);
    }

    public boolean isAuthorCorrect(String senderName, String senderEmail) {
        String xpath = String.format("//*[contains(@class,'mail-Message-Sender')]" +
                "//*[contains(@class,'message-head-sender-name') and @title='%s']//.." +
                "//*[contains(@class,'mail-Message-Sender-Email') and @title='%s']",senderName,senderEmail);

        return isElementPresent(xpath);
    }

    public boolean isTextCorrect(String text) {

        String xpath = String.format("//*[contains(@class,'mail-Message-Content')]" +
                "//*[contains(@class,'Message-Body-Content')]" +
                "//*[contains(text(),'%s')]",text);

        return isElementPresent(xpath);
    }


}
