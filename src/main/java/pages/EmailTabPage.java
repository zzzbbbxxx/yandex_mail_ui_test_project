package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class EmailTabPage extends BasePage {

    public EmailTabPage(WebDriver driver) {
        super(driver);
    }

    public void logOut() {
        openUserMenu();
        clickOnlogOut();
    }

    public void clickOnlogOut() {
        clickOn("//*[contains(@class,'menu__list-item')]//*[@aria-label='Выйти из аккаунта']");
    }

    public void openUserMenu() {
        clickOn("//*[contains(@class,'PSHeader-User')]");

    }

    public boolean isLogOut() {

        return isElementPresent("//*[contains(@class,'passp-title')]" +
                "//*[contains(text(),'Войдите, чтобы перейти')]");
    }



}
