package apollohospitals.urology.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import apollohospitals.base.BaseTest;
import apollohospitals.urology.abstractcomponents.AbstractComponent;
import apollohospitals.urology.pageobjects.ApolloDoctors;
import apollohospitals.urology.pageobjects.ApolloExpertOpinion;
import apollohospitals.urology.pageobjects.ApolloHospitalsFacilities;
import apollohospitals.urology.pageobjects.ApolloSearch;
import apollohospitals.urology.pageobjects.UrologyLanding;

public class SideTabNavigationTest extends BaseTest {
	// ApolloExpertOpinion apolloExpertOpinion=new ApolloExpertOpinion(driver);
	@Test(groups = { "smoke", "navigation", "doctor" })
	public void verifyRedirectionToApolloDoctors() {
		LOGGER.info(
				"🧪🧪Starting test: `verifyRedirectionToApolloDoctors()` in apollohospitals.urology.tests.SideTabNavigationTest🧪🧪");
		AbstractComponent abstractComponent = new ApolloDoctors(driver);
		ApolloDoctors apolloDoctors = abstractComponent.clickOnSideButtonBookAppointment();
		// apolloDoctors=new ApolloDoctors(driver);
		// Get title and assert
		String title = apolloDoctors.getPageTitle();
		LOGGER.info(title);
		LOGGER.info("🎯🎯Captured title after redirection: " + title + "🎯🎯");
		Assert.assertEquals("Apollo Doctors | Apollo Hospitals", title, "❌❌Title does not indicate Doctors❌❌");
		LOGGER.info("✅✅Redirection to Doctors  verified successfully✅✅");
		LOGGER.info(
				"🏁🏁Ending test: `verifyRedirectionToApolloDoctors()` in apollohospitals.urology.tests.SideTabNavigationTest🏁🏁");
	}

	@Test(groups = {"smoke", "navigation", "hospital"})
	public void verifyRedirectionToHospitalsFacilities() {
	    LOGGER.info("🧪🧪Starting test: `verifyRedirectionToHospitalsFacilities()` in apollohospitals.urology.tests.SideTabNavigationTest🧪🧪");   
	    UrologyLanding urologyLanding = new UrologyLanding(driver);
	    ApolloHospitalsFacilities facilities = urologyLanding.clickOnSideButtonFindHospital();
	    String title = facilities.getPageTitle();
	    LOGGER.info("🎯🎯Captured title after redirection: " + title + "🎯🎯");
	    Assert.assertEquals(title, 
	        "Apollo Hospitals is the Best Cancer Treatment Hospitals across India - Apollo Hospitals", 
	        "❌❌Title does not indicate Hospital Facilities❌❌");
	    LOGGER.info("✅✅Redirection to Hospitals Facilities verified successfully✅✅");
	    LOGGER.info("🏁🏁Ending test: `verifyRedirectionToHospitalsFacilities()` in apollohospitals.urology.tests.SideTabNavigationTest🏁🏁\n");
	}
	@Test(groups = {"smoke", "navigation", "search"})
	public void verifyRedirectionToSearch() {
	    LOGGER.info("🧪🧪Starting test: `verifyRedirectionToSearch()` in apollohospitals.urology.tests.SideTabNavigationTest🧪🧪");   
	    UrologyLanding urologyLanding = new UrologyLanding(driver);
	    ApolloSearch search = urologyLanding.clickOnSideButtonSearch();
	    String title = search.getPageTitle();
	    LOGGER.info("🎯🎯Captured title after redirection: " + title + "🎯🎯");
	    Assert.assertEquals(title, 
	        "Apollo Doctors | Apollo Hospitals", 
	        "❌❌Title does not indicate Search❌❌");
	    LOGGER.info("✅✅Redirection to Search verified successfully✅✅");
	    LOGGER.info("🏁🏁Ending test: `verifyRedirectionToSearch()` in apollohospitals.urology.tests.SideTabNavigationTest🏁🏁\n");
	}

	@Test(groups = {"smoke", "navigation", "opinion"})//cant find element
	public void verifyRedirectionToExpertOpinion() {
	    LOGGER.info("🧪🧪Starting test: `verifyRedirectionToExpertOpinion()` in apollohospitals.urology.tests.SideTabNavigationTest🧪🧪");   
	    UrologyLanding urologyLanding = new UrologyLanding(driver);
	    ApolloExpertOpinion expert = urologyLanding.clickOnSideButtonGetExpertOpinion();
	    String title = expert.getPageTitle();
	    LOGGER.info("🎯🎯Captured title after redirection: " + title + "🎯🎯");
	    Assert.assertEquals(title, 
	        "Second Opinion Page | Apollo Hospitals", 
	        "❌❌Title does not indicate Expert Opinion❌❌");
	    LOGGER.info("✅✅Redirection to Expert Opinion verified successfully✅✅");
	    LOGGER.info("🏁🏁Ending test: `verifyRedirectionToExpertOpinion()` in apollohospitals.urology.tests.SideTabNavigationTest🏁🏁\n");
	}
}
