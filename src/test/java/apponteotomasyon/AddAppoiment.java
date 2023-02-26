package apponteotomasyon;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AddAppoiment {

    public AppiumDriver<WebElement> driver;

    public WebDriverWait wait;

    By addAppimentButton = By.id("mobi.appcent.apponte:id/addFragmentIcon");

    By addPersonButton = By.id("mobi.appcent.apponte:id/tvAddPeople");

    By rowItem = By.xpath("//android.widget.TextView[@text='Hayrullah Dedeler']");

    By addDateButton = By.id("mobi.appcent.apponte:id/tvAddDate");

    By addDateSaveButton = By.id("mobi.appcent.apponte:id/btnAddPeopleSave");




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

            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
            wait = new WebDriverWait(driver,10);
        } catch (MalformedURLException e) {
            System.out.println("Appium Driver Error !!!");;
        }

    }

    @Test
    public void test() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement addAppoiment = driver.findElement(addAppimentButton);
        addAppoiment.click();

        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        WebElement addPersonSelect = driver.findElement(addPersonButton);
        addPersonSelect.click();

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        WebElement rowItemSelect = driver.findElement(rowItem);
        rowItemSelect.click();

        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        WebElement saveButtonSelect = driver.findElement(addDateSaveButton);
        saveButtonSelect.click();

        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        WebElement addDateSelect = driver.findElement(addDateButton);
        addDateSelect.click();


        TouchAction swipe = new TouchAction(driver)
                .press(PointOption.point(584,2110))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
                .moveTo(PointOption.point(669,1264))
                .release()
                .perform();

        //Gecmise yonelik randevu
        //randevu ayarinin yapilmasi
        //her iki kosulda saglaniyorsa randevunun alinmasi
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.findElementByXPath("//android.widget.TextView[@text='20']").click();

        if (driver.findElementByXPath("//android.widget.TextView[@text='Geçmişe yönelik randevu alınamamaktadır.']").isDisplayed()){
          String selectDayStr =  driver.findElementByXPath("//android.widget.TextView[@text='20']").getText();
          String todayDayStr =  driver.findElementByXPath("//android.widget.TextView[@text='24']").getText();

            System.out.println(selectDayStr);
            System.out.println(todayDayStr);

            int selectDayInt = Integer.parseInt(selectDayStr);
            int todayDayInt = Integer.parseInt(todayDayStr);

            for (int i=selectDayInt; i<=todayDayInt; i++){
                selectDayInt++;
            }

            System.out.println(selectDayInt);

            if (selectDayInt>=todayDayInt){
                driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
                driver.findElementByXPath("//android.widget.TextView[@text='"+selectDayInt+"']").click();
                Thread.sleep(10000);

                TouchAction swipe2 = new TouchAction(driver)
                        .press(PointOption.point(584,2110))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
                        .moveTo(PointOption.point(669,1264))
                        .release()
                        .perform();

                driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
                driver.findElementByXPath("//android.widget.TextView[@text='09.00 - 10.00']").click();
            }
        }

    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }

}
