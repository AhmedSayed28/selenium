package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

import java.time.Duration;
import java.util.Objects;

public class HomeTest extends TestBase {
    HomePage home;
    SoftAssert soft = new SoftAssert();
    Faker fake = new Faker();

    @Test
    public void Loader() throws InterruptedException {
        logger = extent.createTest("Verify the Home page loaded successfully");
        home = new HomePage(driver);
        Thread.sleep(1000);
        reporter("pass", "Home page loaded successfully");
    }

    @Test
    public void Localization() throws InterruptedException {
        logger = extent.createTest("Verify that user can switch the language");
        home = new HomePage(driver);
        home.SwitchLanguage();
        Thread.sleep(2000);
        if (Objects.equals(driver.getCurrentUrl(), "https://stg.wakeb.tech/ar")) {
            reporter("pass", "Language Switched successfully");
        } else {
            reporter("fail", "Language doesn't Switched !!!!");
        }
    }

    @Test
    public void AboutSection() throws InterruptedException {
        logger = extent.createTest("Verify About Section is exist and visible");
        home = new HomePage(driver);
        if (home.IsWebsiteSectionsExist()) {
            reporter("pass", "Website Sections are exist and visible successfully");
        } else {
            reporter("fail", "Website Sections aren't exist and visible !!!!");
        }
    }

    @Test
    public void SubscribeNews() throws InterruptedException {
        logger = extent.createTest("Verify User can subscribe newsletter");
        home = new HomePage(driver);
        home.SubscribeNewsletter(fake.internet().safeEmailAddress());
        soft.assertEquals(home.GetSubscribeNewsletterSuccessMsg(), "You have Subscribed successfully");
        if (Objects.equals(home.GetSubscribeNewsletterSuccessMsg(), "You have Subscribed successfully")) {
            reporter("pass", "User can subscribe newsletter successfully");
        } else {
            reporter("fail", "User can't subscribe newsletter !!!!");
        }

        soft.assertAll();
    }
}
