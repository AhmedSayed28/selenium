package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class InternApplyNowForm extends Base{

    public InternApplyNowForm(WebDriver driver) {
        super(driver);
    }

    private final By fullNameInputLocator = By.cssSelector("input[id=\"fullNameIntern\"]");
    private final By emailInputLocator = By.cssSelector("input[id=\"emailAddressIntern\"]");
    private final By addressInputLocator = By.cssSelector("input[id=\"addressIntern\"]");
    private final By genderSelectBoxLocator = By.cssSelector("select[id=\"genderIntern\"]");
    private final By phoneInputLocator = By.cssSelector("input[id=\"txtPhoneIntern\"]");
    private final By degreeAndGradYearInputLocator = By.cssSelector("input[id=\"degreeIntern\"]");
    private final By nextBtnLocator = By.cssSelector("form[id=\"intern-form\"] div[class=\"modal-footer border-0\"] button");


    // second phase
    private final By prevExLocator = By.cssSelector("input[id=\"previousExperienceIntern\"]");
    private final By selectProgramLocator = By.cssSelector("select[id=\"programIntern\"]");
    private final By selectTrainingTimeLocator = By.cssSelector("select[id=\"trainingTimeIntern\"]");
    private final By selectTechnicalSkillsLocator = By.cssSelector("select[id=\"technicalSkillsIntern\"]");
    private final By selectTrainingPeriodLocator = By.cssSelector("select[id=\"trainingPeriodIntern\"]");
    private final By selectOfficeOrRemoteLocator = By.cssSelector("select[id=\"officeIntern\"]");
    private final By next2BtnLocator = By.cssSelector("form[id=\"intern-form\"] div[class=\"modal-footer border-0\"] div[class=\"apply-job-step-two\"] button[id=\"job-next-btn\"]");

    // Phase Three

    private final By uploadFileLocator = By.cssSelector("input[id=\"attachFileIntern\"]");
    private final By noteInputLocator = By.cssSelector("textarea[id=\"notesIntern\"]");
    private final By sendBtnLocator = By.cssSelector("form[id=\"intern-form\"] div[class=\"apply-job-step-three\"] button[id=\"intern-send-btn\"]");

    public void InternApplyPhaseOne(String name , String email, String address , String gender , String phone , String degAndYear){
        setTextElement(driver.findElement(fullNameInputLocator),name);
        setTextElement(driver.findElement(emailInputLocator),email);
        setTextElement(driver.findElement(addressInputLocator),address);
        Select genderSelect = new Select(driver.findElement(genderSelectBoxLocator));
        genderSelect.selectByVisibleText(gender);
        setTextElement(driver.findElement(phoneInputLocator),phone);
        setTextElement(driver.findElement(degreeAndGradYearInputLocator),degAndYear);
        click(nextBtnLocator);
    }

    public void InternApplyPhaseTwo(String prevEx){
        setTextElement(driver.findElement(prevExLocator),prevEx);

        Select program = new Select(driver.findElement(selectProgramLocator));
        program.selectByIndex(1);

        Select trainingTime = new Select(driver.findElement(selectTrainingTimeLocator));
        trainingTime.selectByIndex(1);

        Select technicalSkills = new Select(driver.findElement(selectTechnicalSkillsLocator));
        technicalSkills.selectByIndex(1);

        Select trainingPeriod = new Select(driver.findElement(selectTrainingPeriodLocator));
        trainingPeriod.selectByIndex(1);

        Select officeOrRemote = new Select(driver.findElement(selectOfficeOrRemoteLocator));
        officeOrRemote.selectByIndex(1);

        click(next2BtnLocator);
    }

    public void InternApplyPhaseThree(String path,String note){
        driver.findElement(uploadFileLocator).sendKeys(path);
        setTextElement(driver.findElement(noteInputLocator),note);
        click(sendBtnLocator);
    }
}
