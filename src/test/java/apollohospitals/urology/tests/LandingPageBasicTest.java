package apollohospitals.urology.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import apollohospitals.base.BaseTest;

public class LandingPageBasicTest extends BaseTest {
	String expectedTitle = "Nephrology & Urology | Apollo Hospitals";
	@Test(groups = {"sanity", "smoke"})
	public void validatePageTitle() {
		LOGGER.info("🧪🧪Starting test: `validatePageTitle()` "
				+ "in apollohospitals.urology.tests.LandingPageBasicTest🧪🧪");
	    String actualTitle = landingPage.getPageTitle();
	    LOGGER.info("📌 Expected Title: " + expectedTitle);
        LOGGER.info("📌 Actual Title: " + actualTitle);
	    Assert.assertEquals(actualTitle, expectedTitle, "❌❌Page title does not match the expected title❌❌");
	    LOGGER.info("✅✅Page title matched successfully✅✅");
        LOGGER.info("🏁🏁Test Completed: `validatePageTitle()` in apollohospitals.urology.tests.LandingPageBasicTest🏁🏁\n");
	}
	@Test(groups = {"sanity", "smoke"})
    public void validateBannerHeading() {
        LOGGER.info("🧪🧪Starting test: `validateBannerHeading()` in BannerAndOverviewTest🧪🧪");
        String heading = landingPage.getBannerHeading();
        LOGGER.info("📌 Banner Heading: " + heading);
        Assert.assertFalse(heading.isEmpty(), "❌❌Banner heading is empty❌❌");
        Assert.assertEquals(heading, "Nephrology & Urology", "❌❌Unexpected banner heading❌❌");
        LOGGER.info("✅✅Banner heading validated successfully✅✅");
        LOGGER.info("🏁🏁Test Completed: `validateBannerHeading()` in BannerAndOverviewTest🏁🏁\n");
    }

    @Test(groups = {"sanity"})
    public void validateOverviewSectionText() {
        LOGGER.info("🧪🧪Starting test: `validateOverviewSectionText()` in BannerAndOverviewTest🧪🧪");
        String overview = landingPage.getOverviewText();
        LOGGER.info("📋 Overview Text: " + overview);
        Assert.assertTrue(overview.contains("Expertise in Every Aspect"), 
            "❌❌Overview section text is missing or incorrect❌❌");
        LOGGER.info("✅✅Overview text validated successfully✅✅");
        LOGGER.info("🏁🏁Test Completed: `validateOverviewSectionText()` in BannerAndOverviewTest🏁🏁\n");
    }
	
}
