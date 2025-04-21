package apollohospitals.urology.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import apollohospitals.urology.abstractcomponents.AbstractComponent;

public class ApolloDoctors extends AbstractComponent {
	WebDriver driver;
	public ApolloDoctors(WebDriver driver) {
		super(driver);
		LOGGER.info("🧠🧠Entering Constructor: `ApolloDoctorsPage(WebDriver driver)` "
				+ "in apollohospitals.urology.pageobjects.ApolloDoctorsPage.class🧠🧠");
		this.driver=driver;
		//initialize variables
		PageFactory.initElements(driver, this);
		LOGGER.info("✅✅UrologyLandingPage elements initialized with PageFactory✅✅");
		LOGGER.info("🏁🏁Exiting Constructor: `UrologyLandingPage(WebDriver driver)` "
				+ "in apollohospitals.urology.pageobjects.ApolloDoctorsPage.class🏁🏁\n");
	}
	 // Returns the title of the page
    public String getPageTitle() {
        LOGGER.info("📋📋Entering method: `getPageTitle()` in apollohospitals.urology.pageobjects.ApolloDoctorsPage 📋📋");
        String title = driver.getTitle();
        LOGGER.info("📌📌Title found: " + title + "📌📌");
        LOGGER.info("🏁🏁Exiting method: `getPageTitle()` in apollohospitals.urology.pageobjects.ApolloDoctorsPage 🏁🏁\n");
        return title;
    }

}
