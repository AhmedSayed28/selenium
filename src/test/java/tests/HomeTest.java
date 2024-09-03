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
        logger = extent.createTest("Verify the Website Loader");
        home = new HomePage(driver);
        if (home.IsLoaderExist()){
            reporter("pass","The loader displayed successfully");
            reporter("pass","Home page loaded successfully");
        }else {
            reporter("fail","The loader doesn't displayed!!!!");
        }
    }

    @Test
    public void Localization() throws InterruptedException {
        logger = extent.createTest("Verify that user can switch the language");
        home = new HomePage(driver);
        home.SwitchLanguage();
        Thread.sleep(2000);
        if (Objects.equals(driver.getCurrentUrl(), "https://stg.wakeb.tech/ar")){
            reporter("pass","Language Switched successfully");
        }else {
            reporter("fail","Language doesn't Switched !!!!");
        }
    }
    @Test
    public void AboutSection() throws InterruptedException {
        logger = extent.createTest("Verify About Section is exist and visible");
        home = new HomePage(driver);
        if (home.IsWebsiteSectionsExist()){
            reporter("pass","Website Sections are exist and visible successfully");
        }else {
            reporter("fail","Website Sections aren't exist and visible !!!!");
        }
    }
}
