package apollohospitals.urology.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import apollohospitals.urology.abstractcomponents.AbstractComponent;

public class ApolloExpertOpinion extends AbstractComponent {
	WebDriver driver;
	public ApolloExpertOpinion(WebDriver driver) {	
		super(driver);
        LOGGER.info("🧠🧠Entering Constructor: `ApolloExpertOpinion(WebDriver driver)` "
                + "in apollohospitals.urology.pageobjects.ApolloExpertOpinion.class🧠🧠");
        this.driver = driver;
        PageFactory.initElements(driver, this);
        LOGGER.info("✅✅ApolloExpertOpinion elements initialized with PageFactory✅✅");
        LOGGER.info("🏁🏁Exiting Constructor: `ApolloExpertOpinion(WebDriver driver)` "
                + "in apollohospitals.urology.pageobjects.ApolloExpertOpinion.class🏁🏁\n");
	}
	// Returns the title of the Expert Opinion page
	public String getPageTitle() {
	    LOGGER.info("📋📋Entering method: `getPageTitle()` in apollohospitals.urology.pageobjects.ApolloExpertOpinion 📋📋");
	    String title = driver.getTitle();
	    LOGGER.info("📌📌Title found: " + title + "📌📌");
	    LOGGER.info("🏁🏁Exiting method: `getPageTitle()` in apollohospitals.urology.pageobjects.ApolloExpertOpinion 🏁🏁\n");
	    return title;
	}

}
