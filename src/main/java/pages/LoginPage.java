package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//*[contains(@class,'HeadBanner-Button-Enter')]")
    private WebElement creatAccountButton;
    public void clickOnCreateAccount() {
        clickOn(creatAccountButton);
    }

    @FindBy(xpath = "//*[contains(@class,'HeadBanner-Button-Enter')]")
    private WebElement enterToAccountButton;
    public void clickOnEnterToAccount() {
        clickOn(enterToAccountButton);
    }


    @FindBy(xpath = "//*[contains(@id,'passp-field-login')]")
    private WebElement fieldLogin;
    public void enterLoginV1(String login) {
        enterToField(fieldLogin,login);
    }

    @FindBy(xpath = "//*[contains(@id,'passp-field-passwd')]")
    private WebElement fieldPassword;
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

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;
    public void clickOnSubmitButton(){
        clickOn(submitButton);
    }

    public boolean isStartPageOpen(){
        return isElementPresent("//*[contains(@class,'mail-ComposeButton js-main-action-compose')]");
    }

    public void openLoginPage(){
        clickOnEnterToAccount();
    }


    public void openFirstEmail(){
        clickOn("(//*[contains(@class,'messages-scroll-area')]" +
                "//*[contains(@class,'Item_subject')])[1]");

    }

    public void openMailPage(String login, String password){
        openLoginPage();
        enterLoginV2(login);
        enterPasswordV2(password);
    }

}
