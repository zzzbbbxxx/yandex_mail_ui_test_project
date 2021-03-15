package tests.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    public static final int IMPLICIT_TIMEOUT = 20;


    public String login;
    public String password;
    public String emailSubject;
    public String senderName;
    public String senderEmail;
    public String emailText;

    public void readProperty() {

        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("config.properties");
            property.load(fis);

            login = property.getProperty("login");
            password = property.getProperty("password");
            emailSubject = property.getProperty("emailSubject");
            senderName = property.getProperty("senderName");
            senderEmail = property.getProperty("senderEmail");
            emailText = property.getProperty("emailText");

            System.out.println("LOGIN: " + login + ", PASSWORD: " + password);

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсутствует!");
        }
    }

    @BeforeMethod
    public void setUp() {
        readProperty();
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
        this.driver.get("https://mail.yandex.ru/");



    }

    @AfterMethod
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
