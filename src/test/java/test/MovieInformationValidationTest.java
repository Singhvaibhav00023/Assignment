package test;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.IMDBLandingPage;
import pageobjects.IMDBMovieDetailsPage;
import pageobjects.WikiMainPage;
import pageobjects.WikiSearchResultsPage;
import testcomponents.BaseTest;

public class MovieInformationValidationTest extends BaseTest {
	WebDriver driver = null;

	@BeforeMethod
	public void setup() throws IOException {

		// Initialize Driver
		driver = InitializeDriver();
	}

	@Test()
	@Parameters(value = { "Moviename" })
	public void CompareMovieDataFromImdbAndWiki(String Moviename) {

		// Create an object of IMDB Landing page
		IMDBLandingPage landingpage = new IMDBLandingPage(driver);

		// Navigate to IMDB URL
		landingpage.goTo();

		// Search Movie
		IMDBMovieDetailsPage moviedetail = landingpage.searchMovie(Moviename);

		// Extract Country
		String countryimdb = moviedetail.getCountry();

		// Extract ReleaseDate
		String releasedateimdb = moviedetail.getReleaseDate();

		// Create an object of Wiki Main Page
		WikiMainPage wikimainpage = new WikiMainPage(driver);

		// Navigate to WIKI URL
		wikimainpage.goTo();

		// Search Movie
		WikiSearchResultsPage searchResultsPage = wikimainpage.searchMovie(Moviename);

		// Extract Country
		String countrywiki = searchResultsPage.getCountry();

		// Extract ReleaseDate
		String releasedatewiki = searchResultsPage.getReleaseDate();

		// Compare Country From IMDB and WIKI
		Assert.assertTrue(countrywiki.contains(countryimdb));

		// Compare ReleaseDate From IMDB and WIKI
		Assert.assertTrue(releasedatewiki.contains(releasedateimdb));

		System.out.println("Details of Movie " + Moviename + " in IMDB and WIKI Matched Successfully");
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}