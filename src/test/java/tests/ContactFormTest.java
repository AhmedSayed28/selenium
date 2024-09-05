package tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.NavBar;

public class ContactFormTest extends TestBase{

    ContactPage contact;
    NavBar nav;
    Faker fake =new Faker();
    String firstName = fake.name().firstName();
    String email = fake.internet().safeEmailAddress();
    String phone = String.valueOf(fake.number().numberBetween(1000000,99999999));
    String subject = fake.lorem().paragraph(2);
    String message = fake.lorem().paragraph(4);
    @Test
    public void ContactTest() throws InterruptedException {
        logger = extent.createTest("Verify User can Contact us successfully");
        contact = new ContactPage(driver);
        nav = new NavBar(driver);

        nav.navigateToContactUsPage();

        contact.fillContactFormWithValidData(firstName,email,phone,subject,message);
        if (contact.IsSuccess()){
            reporter("pass","Your message has been sent successfully, We will contact you as soon as possible. Thank you!");
        }else {
            reporter("fail","User can not send his message !");
        }

    }
}
