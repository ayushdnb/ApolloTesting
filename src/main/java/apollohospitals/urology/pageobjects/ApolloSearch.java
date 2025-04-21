package apollohospitals.urology.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import apollohospitals.urology.abstractcomponents.AbstractComponent;

public class ApolloSearch extends AbstractComponent{
	WebDriver driver;
	public ApolloSearch(WebDriver driver) {
		super(driver);
        LOGGER.info("🧠🧠Entering Constructor: `ApolloSearch(WebDriver driver)` "
                + "in apollohospitals.urology.pageobjects.ApolloSearch.class🧠🧠");
        this.driver = driver;
        PageFactory.initElements(driver, this);
        LOGGER.info("✅✅ApolloSearch elements initialized with PageFactory✅✅");
        LOGGER.info("🏁🏁Exiting Constructor: `ApolloSearch(WebDriver driver)` "
                + "in apollohospitals.urology.pageobjects.ApolloSearch.class🏁🏁\n");
	}
	// Returns the title of the Search page
	public String getPageTitle() {
	    LOGGER.info("📋📋Entering method: `getPageTitle()` in apollohospitals.urology.pageobjects.ApolloSearch 📋📋");
	    String title = driver.getTitle();
	    LOGGER.info("📌📌Title found: " + title + "📌📌");
	    LOGGER.info("🏁🏁Exiting method: `getPageTitle()` in apollohospitals.urology.pageobjects.ApolloSearch 🏁🏁\n");
	    return title;
	}

}
