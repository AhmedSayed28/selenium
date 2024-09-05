package tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pages.InternApplyNowForm;
import pages.NavBar;

public class InternApplyNowTest extends TestBase{
    InternApplyNowForm apply;
    NavBar nav;
    Faker fake = new Faker();

    String fullName = fake.name().fullName();
    String email = fake.internet().safeEmailAddress();
    String phone = String.valueOf(fake.number().numberBetween(1000000,99999999));
    String gender = "Male";
    String address = fake.address().fullAddress();
    String degAndYear = fake.educator().course() + ", " + fake.number().numberBetween(1900, 2024);
    @Test
    public void InternApplyNowForm() throws InterruptedException {
        logger = extent.createTest("Verify Inter can apply successfully");
        apply = new InternApplyNowForm(driver);
        nav = new NavBar(driver);

        nav.navigateToApplyNowPage();
        apply.InternApplyPhaseOne(fullName,email,address,gender,phone,degAndYear);
        reporter("pass","The step one has been completed successfully");

        apply.InternApplyPhaseTwo("frontEnd");
        reporter("pass","The step Two has been completed successfully");

        apply.InternApplyPhaseThree("C:\\Users\\qaahm\\Downloads\\test.pdf","This is notes");
        Thread.sleep(1000);
        reporter("pass","Intern has been Applied successfully");

    }
}
