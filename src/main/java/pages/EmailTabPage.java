package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class EmailTabPage extends BasePage {

    @FindBy(xpath = "//*[contains(@class,'menu__list-item')]//*[@aria-label='Выйти из аккаунта']")
    protected WebElement logOutLink;

    @FindBy(xpath = "//*[contains(@class,'PSHeader-User')]")
    protected WebElement userMenuLink;

    @FindBy(xpath = "//*[contains(@class,'passp-title')]//*[contains(text(),'Войдите, чтобы перейти')]")
    protected WebElement logInLink;


    public EmailTabPage(WebDriver driver) {
        super(driver);
    }


    public void logOut() {
        openUserMenu();
        clickOnlogOut();
    }

    public void clickOnlogOut() {
        clickOn(logOutLink);
    }

    public void openUserMenu() {
        clickOn(userMenuLink);

    }

    public boolean isLogOut() {
        return isElementPresent(logInLink);
    }



}
