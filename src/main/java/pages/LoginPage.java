package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;


public class LoginPage extends BasePage {

    @FindBy(xpath = "//*[contains(@class,'HeadBanner-Button-Enter')]")
    public WebElement creatAccountButton;

    @FindBy(xpath = "//*[contains(@class,'HeadBanner-Button-Enter')]")
    public WebElement enterToAccountButton;

    @FindBy(xpath = "//*[contains(@id,'passp-field-login')]")
    public WebElement fieldLogin;

    @FindBy(xpath = "//*[contains(@id,'passp-field-passwd')]")
    public WebElement fieldPassword;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//*[contains(@class,'mail-ComposeButton js-main-action-compose')]")
    public WebElement startPageElement;

    @FindBy(xpath = "(//*[contains(@class,'messages-scroll-area')]//*[contains(@class,'Item_subject')])[1]")
    public WebElement lastIncomingEmail;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnCreateAccount() {
        clickOn(creatAccountButton);
    }

    public void clickOnEnterToAccount() {
        clickOn(enterToAccountButton);
    }

    public void enterLoginV1(String login) {
        enterToField(fieldLogin,login);
    }

    public void enterPasswordV1(String password) {
        enterToField(fieldPassword, password);
    }

    public void enterLoginV2(String login) {
        sendToField(fieldLogin,login);
        clickOnSubmitButton();
    }

    public void enterPasswordV2(String password) {
        sendToField(fieldPassword, password);
        clickOnSubmitButton();
    }

    public void clickOnSubmitButton(){
        clickOn(submitButton);
    }

    public boolean isStartPageOpen(){
        return isElementPresent(startPageElement);
    }

    public void openLoginPage(){
        clickOnEnterToAccount();
    }


    public void openLastIncomingEmail(){
        clickOn(lastIncomingEmail);

    }

    public void openMailPage(String login, String password){
        openLoginPage();
        enterLoginV2(login);
        enterPasswordV2(password);
    }

}
