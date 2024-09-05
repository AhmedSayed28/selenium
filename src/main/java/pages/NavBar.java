package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavBar extends Base {

    public NavBar(WebDriver driver) {
        super(driver);
    }

    HomePage home;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    private final By aboutPageLinkLocator = By.cssSelector("div[id=\"nav-content\"] a[href=\"https://stg.wakeb.tech/about-us\"]");
    private final By solutionsPageLinkLocator = By.cssSelector("div[id=\"nav-content\"] a[href=\"https://stg.wakeb.tech/solutions-and-services\"]");
    private final By useCasePageLinkLocator = By.cssSelector("div[id=\"nav-content\"] a[href=\"https://stg.wakeb.tech/use-cases\"]");
    private final By blogPageLinkLocator = By.cssSelector("div[id=\"nav-content\"] a[href=\"https://stg.wakeb.tech/blogs\"]");
    private final By careerPageLinkLocator = By.cssSelector("div[id=\"nav-content\"] a[href=\"https://stg.wakeb.tech/careers\"]");
    private final By contactUsPageLinkLocator = By.cssSelector("div[id=\"nav-content\"] a[href=\"https://stg.wakeb.tech/contact\"]");
    private final By applyNowPageLinkLocator = By.cssSelector("button[class=\"btn btn-solid-main navbar-button\"]");

    // methods

    public void navigateToAboutPage() {
        click(aboutPageLinkLocator);
        home = new HomePage(driver);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(home.loaderLocator)));
    }

    public void navigateToSolutionsPage() {
        click(solutionsPageLinkLocator);
        home = new HomePage(driver);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(home.loaderLocator)));
    }

    public void navigateToUseCasePage() {
        click(useCasePageLinkLocator);
        home = new HomePage(driver);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(home.loaderLocator)));
    }

    public void navigateToBlogPage() {
        click(blogPageLinkLocator);
        home = new HomePage(driver);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(home.loaderLocator)));
    }

    public void navigateToCareerPage() {
        click(careerPageLinkLocator);
        home = new HomePage(driver);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(home.loaderLocator)));
    }

    public void navigateToContactUsPage() {
        click(contactUsPageLinkLocator);
        home = new HomePage(driver);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(home.loaderLocator)));
    }

    public void navigateToApplyNowPage() throws InterruptedException {
        click(careerPageLinkLocator);
//        Actions act = new Actions(driver);
//        act.scrollToElement(driver.findElement(By.cssSelector("footer[id=\"footer\"]")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollTo(0,1500)");
        Thread.sleep(1000);
        click(applyNowPageLinkLocator);
        home = new HomePage(driver);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(home.loaderLocator)));
    }
}
