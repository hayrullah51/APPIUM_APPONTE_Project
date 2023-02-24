package apponteotomasyon;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LoginTest {

    public AppiumDriver<WebElement>  driver;
    public WebDriverWait wait;

    By consultantButton = By.id("mobi.appcent.apponte:id/btnInstitutional");

    By loginButton = By.id("mobi.appcent.apponte:id/ibSignIn");

    By numberText = By.id("mobi.appcent.apponte:id/etPhoneNumber");

    By sendCodeButton = By.id("mobi.appcent.apponte:id/btnSendCode");





    @BeforeTest

    public void beforeTest() throws MalformedURLException {


        try {
            DesiredCapabilities cap;
            cap = new DesiredCapabilities();

            cap.setCapability("deviceName","techo");
            cap.setCapability("platformName","Android");
            cap.setCapability("udid","0772625218103071");
            cap.setCapability("platformVersion","12.0");
            cap.setCapability("appPackage","mobi.appcent.apponte");
            cap.setCapability("appActivity","mobi.appcent.apponte.ui.activity.login.LoginActivity");
            cap.setCapability("skipUnlock","true");
            cap.setCapability("noReset","false");

            driver = new AndroidDriver (new URL("http://127.0.0.1:4723/wd/hub"),cap);
            wait = new WebDriverWait(driver,10);
        }
        catch (MalformedURLException mx){
            System.out.println("Hatali olusturulmus URL !!!");
        }
    }


    @Test

    public void test() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement consultantSelect = driver.findElement(consultantButton);
        consultantSelect.click();

        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        WebElement loginSelect = driver.findElement(loginButton);
        loginSelect.click();

        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        WebElement phoneNumberSelect = driver.findElement(numberText);
        driver.getKeyboard().pressKey("5551112233");

        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        WebElement sendCodeSelect = driver.findElement(sendCodeButton);
        sendCodeSelect.click();

        Thread.sleep(10000);




    }


    @AfterTest

    public void teardown(){

    }
}
