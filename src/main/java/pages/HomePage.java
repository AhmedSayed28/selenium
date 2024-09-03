package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Base{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By loaderLocator = By.cssSelector("img[class=\" loader-logo loader-logo-gif\"]");
    private final By localizationLocator = By.cssSelector("ul[class=\"d-flex gap-3 align-items-center mb-0 p-0\"] a[title=\"language\"] span");
    private final By aboutSectionLocator = By.cssSelector("section[id=\"about\"]");


    public boolean IsLoaderExist(){
        try{
            WebElement loader = driver.findElement(loaderLocator);
            return loader.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }
    public void SwitchLanguage(){
        click(localizationLocator);
    }
    public boolean IsWebsiteSectionsExist(){
        try{
            WebElement aboutSec = driver.findElement(aboutSectionLocator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            Thread.sleep(2000);
            js.executeScript("window.scrollBy(0, 700)");
            Thread.sleep(500);
            js.executeScript("window.scrollBy(500,1300)");
            Thread.sleep(500);
            js.executeScript("window.scrollBy(1300,2400)");
            Thread.sleep(500);
            js.executeScript("window.scrollBy(2400,3000)");
            Thread.sleep(500);
            js.executeScript("window.scrollBy(3000,3600)");
            Thread.sleep(500);
            return true;
        }catch (NoSuchElementException e){
            return false;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
