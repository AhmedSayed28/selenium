package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage extends Base{

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    private final By firstNameInputLocator = By.cssSelector("input[id=\"name\"]");
    private final By emailInputLocator = By.cssSelector("input[id=\"email\"]");
    private final By phoneInputLocator = By.cssSelector("input[id=\"phone\"]");
    private final By subjectInputLocator = By.cssSelector("input[id=\"subject\"]");
    private final By messageInputLocator = By.cssSelector("textarea[id=\"message\"]");
    private final By submitBtnLocator = By.cssSelector("button[id=\"contactFormSubmit\"]");
    private final By contactFormSuccessMsgLocator = By.cssSelector("div[class=\"alert alert-success alert-dismissible fade show mt-3\"]");

    public void fillContactFormWithValidData(String name,String email,String phone,String subject,String message){
        setTextElement(driver.findElement(firstNameInputLocator),name);
        setTextElement(driver.findElement(emailInputLocator),email);
        setTextElement(driver.findElement(phoneInputLocator),phone);
        setTextElement(driver.findElement(subjectInputLocator),subject);
        setTextElement(driver.findElement(messageInputLocator),message);
        click(submitBtnLocator);
    }

    public boolean IsSuccess(){
        return driver.findElement(contactFormSuccessMsgLocator).isDisplayed();
    }

}
