package tests;

import org.testng.annotations.Test;
import pages.NavBar;

public class NavBarTest extends TestBase {

    NavBar nav;

    @Test
    public void NavOnPages() throws InterruptedException {
        logger = extent.createTest("Verify User can Navigate on all website pages");
        nav = new NavBar(driver);

        nav.navigateToAboutPage();
        reporter("pass","User Navigated to about us page successfully");

        nav.navigateToSolutionsPage();
        reporter("pass","User Navigated to Solutions page successfully");

        nav.navigateToUseCasePage();
        reporter("pass","User Navigated to Use Case page successfully");

        nav.navigateToBlogPage();
        reporter("pass","User Navigated to Blog page successfully");

        nav.navigateToCareerPage();
        reporter("pass","User Navigated to Careers page successfully");

    }
}
