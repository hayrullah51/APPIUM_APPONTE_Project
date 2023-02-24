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

    String phoneNumber = "5411303151";

    By consultantButton = By.id("mobi.appcent.apponte:id/btnInstitutional");

    By loginButton = By.id("mobi.appcent.apponte:id/ibSignIn");

    By numberText = By.id("mobi.appcent.apponte:id/etPhoneNumber");

    By sendCodeButton = By.id("mobi.appcent.apponte:id/btnSendCode");

    By otpSendCodeButton = By.id("mobi.appcent.apponte:id/btnOTPContinue");

    By addClientButton = By.id("mobi.appcent.apponte:id/appointmentFragmentIcon");

    By addPersonButton = By.id("mobi.appcent.apponte:id/profileEditImgBox");

    By nameText = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText");

    By surnameText = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText");

    By phoneText = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText");

    By clientSaveButton = By.id("mobi.appcent.apponte:id/btnSave");

    By searchText = By.id("mobi.appcent.apponte:id/search_src_text");




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
            cap.setCapability("appActivity","mobi.appcent.apponte.ui.activity.home.HomeActivity");
            cap.setCapability("skipUnlock","true");
            cap.setCapability("noReset","true");

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
        driver.getKeyboard().pressKey("5411303151");

        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        WebElement sendCodeSelect = driver.findElement(sendCodeButton);
        sendCodeSelect.click();

        Thread.sleep(10000);

        WebElement otpSendCodeSelect = driver.findElement(otpSendCodeButton);
        otpSendCodeSelect.click();

        Thread.sleep(10000);

    }

    @Test
    public void addClient() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

        WebElement addClientSelect = driver.findElement(addClientButton);
        addClientSelect.click();

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        WebElement clientaddSelect = driver.findElement(addPersonButton);
        clientaddSelect.click();

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        WebElement nameTextSelect = driver.findElement(nameText);
        // First we click the text box because we want to open keyword, so we can send keys
        nameTextSelect.click();
        driver.getKeyboard().sendKeys("Hayrullah");

        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

        WebElement surnameTextSelect = driver.findElement(surnameText);
        surnameTextSelect.click();
        driver.getKeyboard().sendKeys("Dedeler");

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        WebElement phoneTextSelect = driver.findElement(phoneText);
        phoneTextSelect.click();
        driver.getKeyboard().pressKey(phoneNumber);

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        WebElement clientSaveSelect = driver.findElement(clientSaveButton);
        clientSaveSelect.click();

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        WebElement searchTextSelect = driver.findElement(searchText);
        searchTextSelect.click();
        driver.getKeyboard().sendKeys("H");

        Thread.sleep(2000);




    }


    @AfterTest

    public void teardown(){

        driver.quit();
    }
}
