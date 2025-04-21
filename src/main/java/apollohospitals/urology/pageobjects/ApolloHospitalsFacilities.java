package apollohospitals.urology.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import apollohospitals.urology.abstractcomponents.AbstractComponent;

public class ApolloHospitalsFacilities extends AbstractComponent{
	WebDriver driver;
	public ApolloHospitalsFacilities(WebDriver driver) {
		super(driver);
        LOGGER.info("🧠🧠Entering Constructor: `ApolloHospitalsFacilities(WebDriver driver)` "
                + "in apollohospitals.urology.pageobjects.ApolloHospitalsFacilities.class🧠🧠");
        this.driver = driver;
        PageFactory.initElements(driver, this);
        LOGGER.info("✅✅ApolloHospitalsFacilities elements initialized with PageFactory✅✅");
        LOGGER.info("🏁🏁Exiting Constructor: `ApolloHospitalsFacilities(WebDriver driver)` "
                + "in apollohospitals.urology.pageobjects.ApolloHospitalsFacilities.class🏁🏁\n");
    }
	// Returns the title of the Hospitals Facilities page
	public String getPageTitle() {
	    LOGGER.info("📋📋Entering method: `getPageTitle()` in apollohospitals.urology.pageobjects.ApolloHospitalsFacilities 📋📋");
	    String title = driver.getTitle();
	    LOGGER.info("📌📌Title found: " + title + "📌📌");
	    LOGGER.info("🏁🏁Exiting method: `getPageTitle()` in apollohospitals.urology.pageobjects.ApolloHospitalsFacilities 🏁🏁\n");
	    return title;
	}
	
}
