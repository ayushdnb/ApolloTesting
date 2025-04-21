package apollohospitals.urology.abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import apollohospitals.urology.pageobjects.ApolloDoctors;
import apollohospitals.urology.pageobjects.ApolloExpertOpinion;
import apollohospitals.urology.pageobjects.ApolloHospitalsFacilities;
import apollohospitals.urology.pageobjects.ApolloSearch;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class AbstractComponent {
	WebDriver driver;
    WebDriverWait wait;
    public Log LOGGER = LogFactory.getLog(this.getClass());
    // 🔹 Language Selectors
    @FindBy(css = "select[aria-label='Select Language']")
    WebElement languageDropdown;
    @FindBy(css = "option[value='hi']")
    WebElement hindiOption;
    @FindBy(css = "option[value='xh']")
    WebElement xhosaOption;
    // 🔹 CTA Buttons
    @FindBy(css = "div[data-drupal-selector='grid-cta-items'] div.grid-card.grid-card--orange a.grid-card__full-cta")
    WebElement sideButtonBookAppointment;
    @FindBy(css = "div[data-drupal-selector='grid-cta-items'] div.grid-card--light_blue a.grid-card__full-cta")
    WebElement sideButtonFindHospital;
    @FindBy(css = "div[data-drupal-selector='grid-cta-items'] div.grid-card--green a.grid-card__full-cta")
    WebElement sideButtonBookHealthCheckup;
    @FindBy(xpath = "//div[@data-drupal-selector='grid-cta-items']//a[contains(@class,'grid-card__full-cta')][normalize-space()='View Get Expert Opinion']")
    WebElement sideButtonGetExpertOpinion;
    @FindBy(css = "div[data-drupal-selector='grid-cta-items'] div.grid-card a.grid-card__full-cta")
    WebElement sideButtonSearch;
    // Constructor to initialize WebDriver, WebDriverWait, and PageFactory elements
    public AbstractComponent(WebDriver driver) {
    	LOGGER.info("🧠🧠Strarting Constructor: `AbstractComponent(WebDriver driver)` in"
    			+ " apollohospitals.urology.abstractcomponents.AbstractComponent.class🧠🧠");
    	LOGGER.info("🔧🔧Initializing AbstractComponent constructor🔧🔧");
    	this.driver=driver;
    	this.wait=new WebDriverWait(driver, Duration.ofSeconds(5));
    	PageFactory.initElements(driver,this);
    	LOGGER.info("✅✅AbstractComponent initialized with 5s explicit wait✅✅\n");
    	LOGGER.info("🏁🏁Exiting Constructor: `AbstractComponent(WebDriver driver)` in "
    			+ "apollohospitals.urology.abstractcomponents.AbstractComponent.class🏁🏁");
    }
    // Waits until the element located by the given By locator becomes visible
    public void waitForElementToAppear(By findBy) {
    	LOGGER.info("🔍🔍Entering method: `waitForElementToAppear(By)` in "
    			+ "apollohospitals.urology.abstractcomponents.AbstractComponent🔍🔍");
        LOGGER.info("⏳⏳Waiting for element located by: " + findBy.toString()+"⏳⏳");
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
        LOGGER.info("👁️👁️Element located by " + findBy.toString() + " is now visible👁️👁️");
        LOGGER.info("🏁🏁Exiting method: `waitForElementToAppear(By)`"
        		+ " in apollohospitals.urology.abstractcomponents.AbstractComponent🏁🏁\n");
    }
    // Waits until the provided WebElement becomes visible
    public void waitForWebElementToAppear(WebElement findBy) {
    	LOGGER.info("🔍🔍Entering method: `waitForWebElementToAppear(WebElement)` in "
    			+ "apollohospitals.urology.abstractcomponents.AbstractComponent🔍🔍");
        LOGGER.info("⏳⏳Waiting for WebElement to become visible: " + findBy.toString()+"⏳⏳");
        wait.until(ExpectedConditions.visibilityOf(findBy));
        LOGGER.info("👁️👁️WebElement is now visible: " + findBy.toString()+"👁️👁️");
        LOGGER.info("🏁🏁Exiting method: `waitForWebElementToAppear(WebElement)` "
        		+ "in apollohospitals.urology.abstractcomponents.AbstractComponent🏁🏁\n");
    }
    // Waits until the provided WebElement becomes invisible
    public void waitForElementToDisappear(WebElement webElement) {
    	LOGGER.info("🔍🔍Entering method: `waitForElementToDisappear(WebElement)` "
    			+ "in apollohospitals.urology.abstractcomponents.AbstractComponent🔍🔍");
        LOGGER.info("⏳⏳Waiting for WebElement to disappear: " + webElement.toString()+"⏳⏳");
        wait.until(ExpectedConditions.invisibilityOf(webElement));
        LOGGER.info("🙈🙈WebElement has disappeared: " + webElement.toString()+"🙈🙈");
        LOGGER.info("🏁🏁Exiting method: `waitForElementToDisappear(WebElement)` "
        		+ "in apollohospitals.urology.abstractcomponents.AbstractComponent🏁🏁\n");
    }
  //Switches language to Hindi
  	public void switchToHindi() {
  		LOGGER.info("🌐🌐Entering method: `switchToHindi()` in "
  				+ "apollohospitals.urology.pageobjects.UrologyLandingPage🌐🌐");
  		LOGGER.info("🔽🔽Clicking on language dropdown🔽🔽");
  		languageDropdown.click();
  		LOGGER.info("🇮🇳🇮🇳Clicking on Hindi language option🇮🇳🇮🇳");
  		hindiOption.click();
  		LOGGER.info("✅✅Hindi language selected successfully✅✅");
  		LOGGER.info("🏁🏁Exiting method: `switchToHindi()` in "
  				+ "apollohospitals.urology.pageobjects.UrologyLandingPage🏁🏁\n");
  	}
  	// Switches language to Xhosa
  	public void switchToXhosa() {
  	    LOGGER.info("🌐🌐Entering method: `switchToXhosa()` in "
  	    		+ "apollohospitals.urology.pageobjects.UrologyLandingPage🌐🌐");
  	    LOGGER.info("🔽🔽Clicking on language dropdown🔽🔽");
  	    languageDropdown.click();
  	    LOGGER.info("🌍🌍Clicking on Xhosa language option🌍🌍");
  	    xhosaOption.click();
  	    LOGGER.info("✅✅Xhosa language selected successfully✅✅");
  	    LOGGER.info("🏁🏁Exiting method: `switchToXhosa()` in "
  	    		+ "apollohospitals.urology.pageobjects.UrologyLandingPage🏁🏁\n");
  	}
  	public ApolloDoctors clickOnSideButtonBookAppointment() {
  	    LOGGER.info("🧭🧭Entering method: `clickOnSideButtonBookAppointment()` in"
  	    		+ " apollohospitals.urology.pageobjects.ApolloDoctorsPage🧭🧭");
  	    LOGGER.info("🖱️🖱️Clicking on side button: Book Appointment🖱️🖱️");
  	    sideButtonBookAppointment.click(); 
  	    LOGGER.info("✅✅Click action performed on Book Appointment button✅✅");
  	    ApolloDoctors apolloDoctors=new ApolloDoctors(driver);
  	  LOGGER.info("🏁🏁Exiting method: `clickOnSideButtonBookAppointment()` in "
  	  		+ "apollohospitals.urology.pageobjects.ApolloDoctorsPage🏁🏁\n");
  	    return apolloDoctors;
  	}
 // Clicks on "Find Hospital" side tab and redirects to ApolloHospitalsFacilities page
  	public ApolloHospitalsFacilities clickOnSideButtonFindHospital() {
  	    LOGGER.info("🧭🧭Entering method: `clickOnSideButtonFindHospital()` in UrologyLanding 🧭🧭");
  	    LOGGER.info("🏥🏥Clicking on `Find Hospital` side tab🏥🏥");
  	    sideButtonFindHospital.click();
  	    LOGGER.info("✅✅Redirection initiated for Find Hospital✅✅");
  	    LOGGER.info("🏁🏁Exiting method: `clickOnSideButtonFindHospital()` in UrologyLanding 🏁🏁\n");
  	    return new ApolloHospitalsFacilities(driver);
  	}
  	// Clicks on "Search" side tab and redirects to ApolloSearch page
  	public ApolloSearch clickOnSideButtonSearch() {
  	    LOGGER.info("🔍🔍Entering method: `clickOnSideButtonSearch()` in UrologyLanding 🔍🔍");
  	    LOGGER.info("🔎🔎Clicking on `Search` side tab🔎🔎");
  	    sideButtonSearch.click();
  	    LOGGER.info("✅✅Redirection initiated for Search✅✅");
  	    LOGGER.info("🏁🏁Exiting method: `clickOnSideButtonSearch()` in UrologyLanding 🏁🏁\n");
  	    return new ApolloSearch(driver);
  	}
  	// Clicks on "Get Expert Opinion" side tab and redirects to ApolloExpertOpinion page
  	public ApolloExpertOpinion clickOnSideButtonGetExpertOpinion() {
  	    LOGGER.info("🩺🩺Entering method: `clickOnSideButtonGetExpertOpinion()` in UrologyLanding 🩺🩺");
  	    LOGGER.info("💡💡Clicking on `Get Expert Opinion` side tab💡💡");
  	    sideButtonGetExpertOpinion.click();
  	    LOGGER.info("✅✅Redirection initiated for Expert Opinion✅✅");
  	    LOGGER.info("🏁🏁Exiting method: `clickOnSideButtonGetExpertOpinion()` in UrologyLanding 🏁🏁\n");
  	    return new ApolloExpertOpinion(driver);
  	}

  	public void clickOnSideButtonBookHealthCheckup() {
  	    LOGGER.info("🧬🧬Entering method: `clickOnSideButtonBookHealthCheckup()` "
  	              + "in apollohospitals.urology.abstractcomponents.AbstractComponent🧬🧬");
  	    LOGGER.info("🖱️🖱️Clicking on side tab: Book Health Checkup🖱️🖱️");
  	    sideButtonBookHealthCheckup.click();
  	    LOGGER.info("✅✅Click action performed on `Book Health Checkup`✅✅");
  	    LOGGER.info("🏁🏁Exiting method: `clickOnSideButtonBookHealthCheckup()` in "
  	              + "apollohospitals.urology.abstractcomponents.AbstractComponent🏁🏁\n");
  	}

}
