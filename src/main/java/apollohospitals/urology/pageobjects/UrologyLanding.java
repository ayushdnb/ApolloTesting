package apollohospitals.urology.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import apollohospitals.urology.abstractcomponents.AbstractComponent;

public class UrologyLanding extends AbstractComponent {
	WebDriver driver;
	public Log LOGGER=LogFactory.getLog(this.getClass());
	//Constructor to initialize PageFactory elements and inherit from AbstractComponent
	public UrologyLanding(WebDriver driver) {
		super(driver);
		LOGGER.info("🧠🧠Entering Constructor: `UrologyLandingPage(WebDriver driver)` "
				+ "in apollohospitals.urology.pageobjects.UrologyLandingPage 🧠🧠");
		this.driver=driver;
		//initialize variables
		PageFactory.initElements(driver, this);
		LOGGER.info("✅✅UrologyLandingPage elements initialized with PageFactory✅✅");
		LOGGER.info("🏁🏁Exiting Constructor: `UrologyLandingPage(WebDriver driver)` "
				+ "in apollohospitals.urology.pageobjects.UrologyLandingPage🏁🏁\n");
}
	@FindBy(css = "h1[class='node-header__heading'] span span")
	WebElement bannerHeading;
	@FindBy(xpath = "//input[@placeholder='Search For Doctors & Specialities']")
	WebElement searchBox;
	@FindBy(xpath = "//*[contains(text(),'Expertise in Every Aspect')]")
	WebElement overviewText;
	@FindBy(css="div.doctor-specialist-card")
	List<WebElement> doctorCards;

	//Gets the main banner heading text
	public String getBannerHeading() {
	    LOGGER.info("📋📋Entering method: `getBannerHeading()` in in apollohospitals.urology.pageobjects.UrologyLandingPage");
	    String text = bannerHeading.getText().trim();
	    LOGGER.info("🎯🎯Banner heading found: " + text+"🎯🎯");
	    LOGGER.info("🏁🏁Exiting method: `getBannerHeading()` in in apollohospitals.urology.pageobjects.UrologyLandingPage\n");
	    return text;
	}
	
	// Fetches the page title
	public String getPageTitle() {
	    LOGGER.info("🧾🧾Entering method: `getPageTitle()` in apollohospitals.urology.pageobjects.UrologyLandingPage🧾🧾");
	    String title = driver.getTitle();
	    LOGGER.info("📌📌Title found: " + title + "📌📌");
	    LOGGER.info("🏁🏁Exiting method: `getPageTitle()` in apollohospitals.urology.pageobjects.UrologyLandingPage🏁🏁\n");
	    return title;
	}
	
	// Performs search using the search box
	public void searchFor(String query) {
	    LOGGER.info("🔍🔍Entering method: `searchFor(String query)` in apollohospitals.urology.pageobjects.UrologyLandingPage🔍🔍");
	    LOGGER.info("⌨️⌨️Clearing search box and entering query: " + query+"⌨️⌨️");
	    searchBox.clear();
	    searchBox.sendKeys(query);
	    searchBox.submit(); // or press Enter, depending on site behavior
	    LOGGER.info("📤📤Search submitted for query: " + query+"📤📤");
	    LOGGER.info("🏁🏁Exiting method: `searchFor(String query)` in apollohospitals.urology.pageobjects.UrologyLandingPage🏁🏁\n");
	}
	
	// Fetches the overview text
	public String getOverviewText() {
	    LOGGER.info("📋📋Entering method: `getOverviewText()` in apollohospitals.urology.pageobjects.UrologyLandingPage📋📋");
	    String text = overviewText.getText();
	    LOGGER.info("📌📌Overview found: " + text + "📌📌");
	    LOGGER.info("🏁🏁Exiting method: `getOverviewText()` in apollohospitals.urology.pageobjects.UrologyLandingPage🏁🏁\n");
	    return text;
	}
	
	// Retrieves all doctor names from the landing page
	public List<String> getAllDoctorNames() {
	    LOGGER.info("📋📋Entering method: `getAllDoctorNames()` in apollohospitals.urology.pageobjects.UrologyLandingPage📋📋");
	    List<String> names = new ArrayList<>();
	
	    for (WebElement card : doctorCards) {
	        String name = card.findElement(By.cssSelector("div.doctor-specialist-card__name > span")).getText().trim();
	        LOGGER.info("🩺🩺Found doctor: " + name + "🩺🩺");
	        names.add(name);
	    }
	    LOGGER.info("✅✅getAllDoctorNames() completed. Total doctors found: " + names.size());
	    LOGGER.info("🏁🏁Exiting method: `getAllDoctorNames()` in apollohospitals.urology.pageobjects.UrologyLandingPage🏁🏁\n");
	    return names;
}	
	public void goTo() {
		LOGGER.info("📋📋Entering method: `goTo()` in apollohospitals.urology.pageobjects.UrologyLandingPage📋📋");
		driver.get("https://www.apollohospitals.com/departments/urology");
		LOGGER.info("🏁🏁Exiting method: `goTo()` in apollohospitals.urology.pageobjects.UrologyLandingPage🏁🏁\n");
	    }
	}
