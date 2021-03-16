package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getWebElementFromFormattedXpathString(String xpathString, Object... parameters) {
        WebElement element = driver.findElement(By.xpath(String.format(xpathString, parameters)));
        return element;
    }

    public void clickOn(WebElement element) {

        element.click();
    }

    public void clickOn(String locator) {

        WebElement element = driver.findElement(By.xpath(locator));
        element.click();
    }

    public void sendToField(WebElement element, String value) {
        element.click();
        element.sendKeys(value);
    }

    public void enterToField(WebElement element, String value) {
        sendToField(element,value);
        element.submit();
    }

    public boolean isElementPresent(WebElement element) {

        return element.isDisplayed();


    }
}
