package apollohospitals.urology.tests;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import apollohospitals.base.BaseTest;
import apollohospitals.dataproviders.RequestCallBackFormData;
import apollohospitals.urology.pageobjects.RequestCallBackForm;

public class RequestCallBackFormTest extends BaseTest {
	@Test(groups = { "ui", "popup", "smoke" })
	public void testFormHeaderIsVisible() {
		LOGGER.info("🧪🧪Starting test: `testFormHeaderIsVisible()` in RequestCallBackFormTest🧪🧪");
		// Step 1: Open the popup via landing page button
		landingPage.clickOnSideButtonBookHealthCheckup();
		// Step 2: Create form object and wait for it
		RequestCallBackForm form = new RequestCallBackForm(driver);
		form.waitForFormToAppear();
		// Step 3: Capture and assert the form title
		String actualTitle = form.getFormTitle().getText().trim();
		Assert.assertEquals(actualTitle, "Request A Call Back", "❌❌Form heading is incorrect❌❌");
		LOGGER.info("✅✅Form header validated successfully: " + actualTitle + "✅✅");
		LOGGER.info("🏁🏁Ending test: `testFormHeaderIsVisible()` in RequestCallBackFormTest🏁🏁\n");
	}

	@Test(groups = { "ui", "tab", "sanity" })
	public void testTabSwitching() {
		LOGGER.info("🧪🧪Starting test: `testTabSwitching()` in RequestCallBackFormTest🧪🧪");
		// Step 1: Trigger popup
		landingPage.clickOnSideButtonBookHealthCheckup();
		// Step 2: Create form object and wait for it
		RequestCallBackForm form = new RequestCallBackForm(driver);
		form.waitForWebElementToAppear(form.getFormTitle());
		// Step 3: Switch to each tab and assert they are displayed/enabled
		LOGGER.info("🗂️🗂️Switching to 'Book Appointment' tab🗂️🗂️");
		form.getTabBookAppointment().click();
		Assert.assertTrue(form.getTabBookAppointment().isDisplayed(), "❌❌Book Appointment tab not visible❌❌");
		LOGGER.info("🧬🧬Switching to 'Book Health Check' tab🧬🧬");
		form.getTabBookHealthCheck().click();
		Assert.assertTrue(form.getTabBookHealthCheck().isDisplayed(), "❌❌Book Health Check tab not visible❌❌");
		LOGGER.info("🧠🧠Switching to 'Book Second Opinion' tab🧠🧠");
		form.getTabBookSecondOpinion().click();
		Assert.assertTrue(form.getTabBookSecondOpinion().isDisplayed(), "❌❌Book Second Opinion tab not visible❌❌");
		LOGGER.info("✅✅Tab switching verified successfully✅✅");
		LOGGER.info("🏁🏁Ending test: `testTabSwitching()` in RequestCallBackFormTest🏁🏁\n");
	}

	@Test(dataProvider = "invalidFormData", dataProviderClass = RequestCallBackFormData.class, groups = {"validation", "form", "comprehensive"})
	public void testAllFieldValidations(Map<String, String> formData) {
	    LOGGER.info("🧪🧪Starting test: `testAllFieldValidations()` in RequestCallBackFormTest 🧪🧪");
	    // Step 1: Trigger the popup
	    LOGGER.info("🧲🧲Clicking on `Book Health Checkup` side tab to trigger form popup🧲🧲");
	    landingPage.clickOnSideButtonBookHealthCheckup();
	    // Step 2: Initialize form object and wait
	    RequestCallBackForm form = new RequestCallBackForm(driver);
	    form.waitForFormToAppear();
	    // Step 3: Fill form fields from JSON
	    LOGGER.info("📝📝Filling form fields with test data from JSON📝📝");
	    form.getInputName().clear();
	    form.getInputName().sendKeys(formData.get("name"));
	    LOGGER.info("✍️ Name Entered: " + formData.get("name"));
	    form.getInputEmail().clear();
	    form.getInputEmail().sendKeys(formData.get("email"));
	    LOGGER.info("📧 Email Entered: " + formData.get("email"));
	    form.getInputMobile().clear();
	    form.getInputMobile().sendKeys(formData.get("mobile"));
	    LOGGER.info("📱 Mobile Entered: " + formData.get("mobile"));
	    if (!formData.get("city").isEmpty()) {
	        form.selectCity(formData.get("city"));
	        LOGGER.info("🏙️ City Selected: " + formData.get("city"));
	    }
	    // Step 4: Submit the form
	    LOGGER.info("📤📤Clicking Submit button📤📤");
	    form.clickSubmit();
	    // Step 5: Validation Assertions
	    LOGGER.info("🧪🧪Validating error messages field by field🧪🧪");
	    if (formData.containsKey("expectedError_name")) {
	        String actual = form.getNameError();
	        Assert.assertTrue(actual.contains(formData.get("expectedError_name")),
	                "❌ Name Error Mismatch ❌\nExpected: " + formData.get("expectedError_name") + "\nActual: " + actual);
	        LOGGER.info("✅ Name Error Validated: " + actual);
	    }
	    if (formData.containsKey("expectedError_email")) {
	        String actual = form.getEmailError();
	        Assert.assertTrue(actual.contains(formData.get("expectedError_email")),
	                "❌ Email Error Mismatch ❌\nExpected: " + formData.get("expectedError_email") + "\nActual: " + actual);
	        LOGGER.info("✅ Email Error Validated: " + actual);
	    }
	    if (formData.containsKey("expectedError_city")) {
	        String actual = form.getCityError();
	        Assert.assertTrue(actual.contains(formData.get("expectedError_city")),
	                "❌ City Error Mismatch ❌\nExpected: " + formData.get("expectedError_city") + "\nActual: " + actual);
	        LOGGER.info("✅ City Error Validated: " + actual);
	    }
	    if (formData.containsKey("expectedError_mobile")) {
	        String actual = form.getPhoneError();
	        Assert.assertTrue(actual.contains(formData.get("expectedError_mobile")),
	                "❌ Mobile Error Mismatch ❌\nExpected: " + formData.get("expectedError_mobile") + "\nActual: " + actual);
	        LOGGER.info("✅ Mobile Error Validated: " + actual);
	    }
	    if (formData.containsKey("expectedError_otp")) {
	        String actual = form.getOtpError();
	        Assert.assertTrue(actual.contains(formData.get("expectedError_otp")),
	                "❌ OTP Error Mismatch ❌\nExpected: " + formData.get("expectedError_otp") + "\nActual: " + actual);
	        LOGGER.info("✅ OTP Error Validated: " + actual);
	    }
	    LOGGER.info("🏁🏁Ending test: `testAllFieldValidations()` in RequestCallBackFormTest 🏁🏁\n");
	}
	@Test(groups = {"ui", "dropdown", "functional", "smoke"})
	public void testMultipleCityDropdownSelections() {
	    LOGGER.info("🧪🧪Starting test: `testMultipleCityDropdownSelections()` in RequestCallBackFormTest🧪🧪");
	    // 🔁🔁List of cities to test dropdown selection🔁🔁
	    List<String> citiesToTest = Arrays.asList("Delhi", "Bangalore", "Hyderabad", "Mumbai", "Chennai");
	    // 🧲🧲Triggering popup via 'Book Health Checkup' tab🧲🧲
	    landingPage.clickOnSideButtonBookHealthCheckup();
	    RequestCallBackForm form = new RequestCallBackForm(driver);
	    form.waitForFormToAppear();
	    // 🔍🔍Looping through cities and validating dropdown selection🔍🔍
	    for (String city : citiesToTest) {
	        LOGGER.info("🏙️🏙️Attempting to select city: " + city + "🏙️🏙️");
	        form.selectCity(city);

	        String selected = form.getSelectedCity();
	        Assert.assertTrue(selected.toLowerCase().contains(city.toLowerCase()),
	            "❌❌City selection mismatch❌❌\nExpected: " + city + "\nActual: " + selected);
	        LOGGER.info("✅✅City validated successfully: " + selected + "✅✅\n");
	    }
	    LOGGER.info("📊📊All cities validated successfully in dropdown📊📊");
	    LOGGER.info("🏁🏁Ending test: `testMultipleCityDropdownSelections()` in RequestCallBackFormTest🏁🏁\n");
	}
	@Test(groups = {"ui", "popup", "close", "functional"})
	public void testPopupClosesOnClickingX() {
	    LOGGER.info("🧪🧪Starting test: `testPopupClosesOnClickingX()` in RequestCallBackFormTest🧪🧪");
	    // Step 1: Open the Request A Call Back popup
	    landingPage.clickOnSideButtonBookHealthCheckup();
	    RequestCallBackForm form = new RequestCallBackForm(driver);
	    form.waitForFormToAppear();
	    // Step 2: Click the close (X) button
	    LOGGER.info("❌❌Clicking close (X) button on popup❌❌");
	    form.getCloseButton().click();
	    // Step 3: Check if form is closed by verifying absence of form title
	    boolean isClosed;
	    try {
	        isClosed = !form.getFormTitle().isDisplayed();
	    } catch (Exception e) {
	        isClosed = true;  // Popup probably closed and DOM updated
	        LOGGER.warn("⚠️⚠️Caught exception while checking form visibility: " + e.getMessage(), e);
	    }
	    Assert.assertTrue(isClosed, "❌❌Form did not close after clicking X❌❌");
	    LOGGER.info("✅✅Form popup closed successfully after clicking X✅✅");
	    LOGGER.info("🏁🏁Ending test: `testPopupClosesOnClickingX()` in RequestCallBackFormTest🏁🏁\n");
	}
}
