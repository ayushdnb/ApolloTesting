package apollohospitals.urology.pageobjects;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import apollohospitals.urology.abstractcomponents.AbstractComponent;

public class RequestCallBackForm extends AbstractComponent {
	WebDriver driver;
	WebDriverWait wait;
	public Log LOGGER = LogFactory.getLog(this.getClass());
	// 🔹 Error Messages (Dual Validation States)
	@FindBy(xpath = "//div[@id='edit-msg-container']//li[contains(text(),'Name is required')]")
	WebElement nameError;
	@FindBy(xpath = "//div[@id='edit-msg-container']//li[contains(text(),'Email is required') or contains(text(),'valid email address')]")
	WebElement emailError;
	@FindBy(xpath = "//div[@id='edit-msg-container']//li[contains(text(),'City selection is required')]")
	WebElement cityError;
	@FindBy(xpath = "//div[@id='edit-msg-container']//li[contains(text(),'Phone number is required') or contains(text(),'valid 10-digit phone number')]")
	WebElement phoneError;
	@FindBy(xpath = "//div[@id='edit-msg-container']//li[contains(text(),'Please enter otp')]")
	WebElement otpError;
	// 🔹 Form Title
	@FindBy(css = "div.title-text")
	WebElement formTitle;
	// 🔹 Dropdown - Select City
	@FindBy(css = "select#edit-city")
	WebElement selectCity;
	// 🔹 Form Fields
	@FindBy(css = "input#edit-name")
	private
	WebElement inputName;
	@FindBy(css = "input#edit-email")
	private
	WebElement inputEmail;
	@FindBy(css = "input#edit-phone")
	private
	WebElement inputMobile;
	// 🔹 Buttons
	@FindBy(css = "button#edit-send-otp")
	WebElement sendOTPButton;
	@FindBy(css = "input#edit-verify")
	WebElement submitBtn;
	// 🔹 Terms & Conditions Checkbox
	// Dropdown Box (clickable)
	@FindBy(css = "span.select2-selection")
	WebElement cityDropdownClickable;
	// Search Box inside dropdown (after click)
	@FindBy(css = "input.select2-search__field")
	WebElement citySearchInput;
	// All options in dropdown list
	@FindBy(css = "ul.select2-results__options li")
	List<WebElement> cityOptions;
	@FindBy(css = "input#edit-terms")
	WebElement termsCheckbox;
	// 🔹 Top Tabs
	@FindBy(xpath = "//label[@for='edit-request-type-appointment']")
	private
	WebElement tabBookAppointment;
	@FindBy(xpath = "//label[@for='edit-request-type-health-check']")
	private
	WebElement tabBookHealthCheck;
	@FindBy(xpath = "//label[@for='edit-request-type-second-opinion']")
	private
	WebElement tabBookSecondOpinion;
	// 🔹 Close (X) Button - To Close Popup
	@FindBy(css = "button[title='Close']")
	private
	WebElement closeButton;
	@FindBy(xpath = "//div[@id='edit-msg-container']//li")
	List<WebElement> allErrorMessages;
	// Constructor
	public RequestCallBackForm(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		LOGGER.info(
				"🧠🧠Entering Constructor: `RequestCallBackForm(WebDriver driver)` in apollohospitals.urology.pageobjects.RequestCallBackForm 🧠🧠");
		LOGGER.info("✅✅RequestCallBackForm initialized successfully with PageFactory✅✅");
		LOGGER.info(
				"🏁🏁Exiting Constructor: `RequestCallBackForm(WebDriver driver)` in apollohospitals.urology.pageobjects.RequestCallBackForm 🏁🏁\n");
	}

	public void clickSendOTP() {
		LOGGER.info("🔍🔍Entering method: `clickSendOTP()` in RequestCallBackForm 🔍🔍");
		LOGGER.info("📩📩Clicking on 'Send OTP' button📩📩");
		sendOTPButton.click();
		LOGGER.info("🏁🏁Exiting method: `clickSendOTP()` in RequestCallBackForm 🏁🏁\n");
	}

	public void clickSubmit() {
		LOGGER.info("🔍🔍Entering method: `clickSubmit()` in RequestCallBackForm 🔍🔍");
		LOGGER.info("📤📤Clicking on 'Submit' button📤📤");
		submitBtn.click();
		LOGGER.info("🏁🏁Exiting method: `clickSubmit()` in RequestCallBackForm 🏁🏁\n");
	}

	public String getNameError() {
		LOGGER.info("🔍🔍Entering method: `getNameError()` in RequestCallBackForm 🔍🔍");
		String err = nameError.getText().trim();
		LOGGER.info("❗❗Name Error: " + err + "❗❗");
		LOGGER.info("🔁🔁Returning name error message to test: " + err + " 🔁🔁");
		LOGGER.info("🏁🏁Exiting method: `getNameError()` in RequestCallBackForm 🏁🏁\n");
		return err;
	}

	public String getEmailError() {
		LOGGER.info("🔍🔍Entering method: `getEmailError()` in RequestCallBackForm 🔍🔍");
		String err = emailError.getText().trim();
		LOGGER.info("❗❗Email Error: " + err + "❗❗");
		LOGGER.info("🔁🔁Returning email error message to test: " + err + " 🔁🔁");
		LOGGER.info("🏁🏁Exiting method: `getEmailError()` in RequestCallBackForm 🏁🏁\n");
		return err;
	}

	public String getCityError() {
		LOGGER.info("🔍🔍Entering method: `getCityError()` in RequestCallBackForm 🔍🔍");
		String err = cityError.getText().trim();
		LOGGER.info("❗❗City Error: " + err + "❗❗");
		LOGGER.info("🔁🔁Returning city error message to test: " + err + " 🔁🔁");
		LOGGER.info("🏁🏁Exiting method: `getCityError()` in RequestCallBackForm 🏁🏁\n");
		return err;
	}

	public String getPhoneError() {
		LOGGER.info("🔍🔍Entering method: `getPhoneError()` in RequestCallBackForm 🔍🔍");
		String err = phoneError.getText().trim();
		LOGGER.info("❗❗Phone Error: " + err + "❗❗");
		LOGGER.info("🔁🔁Returning phone error message to test: " + err + " 🔁🔁");
		LOGGER.info("🏁🏁Exiting method: `getPhoneError()` in RequestCallBackForm 🏁🏁\n");
		return err;
	}

	public String getOtpError() {
		LOGGER.info("🔍🔍Entering method: `getOtpError()` in RequestCallBackForm 🔍🔍");
		String err = otpError.getText().trim();
		LOGGER.info("❗❗OTP Error: " + err + "❗❗");
		LOGGER.info("🔁🔁Returning OTP error message to test: " + err + " 🔁🔁");
		LOGGER.info("🏁🏁Exiting method: `getOtpError()` in RequestCallBackForm 🏁🏁\n");
		return err;
	}

	public String getInlineMobileError() {
		LOGGER.info("🔍🔍Entering method: `getInlineMobileError()` in RequestCallBackForm 🔍🔍");
		String err = phoneError.getText().trim();
		LOGGER.info("❗❗Inline Mobile Error: " + err + "❗❗");
		LOGGER.info("🔁🔁Returning inline mobile error message to test: " + err + " 🔁🔁");
		LOGGER.info("🏁🏁Exiting method: `getInlineMobileError()` in RequestCallBackForm 🏁🏁\n");
		return err;
	}

	public WebElement getFormTitle() {
		return formTitle;
	}

	public void setFormTitle(WebElement formTitle) {
		this.formTitle = formTitle;
	}

	public void selectCity(String cityName) {
		LOGGER.info("🏙️🏙️Selecting city: " + cityName + "🏙️🏙️");

		try {
			cityDropdownClickable.click();
			LOGGER.info("🔽🔽City dropdown opened🔽🔽");

			citySearchInput.sendKeys(cityName); // Filter the list
			LOGGER.info("🔍🔍Entered city search keyword: " + cityName + "🔍🔍");

			boolean cityFound = false;
			for (WebElement option : cityOptions) {
				String optionText = option.getText().trim();
				if (optionText.toLowerCase().contains(cityName.toLowerCase())) {
					LOGGER.info("✅✅City matched in dropdown: " + optionText + "✅✅");
					option.click();
					cityFound = true;
					break;
				}
			}
			if (!cityFound) {
				LOGGER.error("❌❌City not found in dropdown: " + cityName + "❌❌");
				throw new RuntimeException("City not found in dropdown: " + cityName);
			}
		} catch (Exception e) {
			LOGGER.error("❌❌Error while selecting city: " + cityName + "❌❌", e);
			throw e;
		}
		LOGGER.info("🏁🏁City selection completed for: " + cityName + "🏁🏁\n");
	}
	public String getSelectedCity() {
	    return cityDropdownClickable.getText().trim();
	}
	public void waitForFormToAppear() {
	    waitForWebElementToAppear(formTitle);
	}

	public WebElement getTabBookAppointment() {
		return tabBookAppointment;
	}

	public void setTabBookAppointment(WebElement tabBookAppointment) {
		this.tabBookAppointment = tabBookAppointment;
	}

	public WebElement getTabBookHealthCheck() {
		return tabBookHealthCheck;
	}

	public void setTabBookHealthCheck(WebElement tabBookHealthCheck) {
		this.tabBookHealthCheck = tabBookHealthCheck;
	}

	public WebElement getTabBookSecondOpinion() {
		return tabBookSecondOpinion;
	}

	public void setTabBookSecondOpinion(WebElement tabBookSecondOpinion) {
		this.tabBookSecondOpinion = tabBookSecondOpinion;
	}

	public WebElement getInputMobile() {
		return inputMobile;
	}

	public void setInputMobile(WebElement inputMobile) {
		this.inputMobile = inputMobile;
	}

	public WebElement getInputEmail() {
		return inputEmail;
	}

	public void setInputEmail(WebElement inputEmail) {
		this.inputEmail = inputEmail;
	}

	public WebElement getInputName() {
		return inputName;
	}

	public void setInputName(WebElement inputName) {
		this.inputName = inputName;
	}

	public WebElement getCloseButton() {
		return closeButton;
	}

	public void setCloseButton(WebElement closeButton) {
		this.closeButton = closeButton;
	}

}
