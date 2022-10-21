import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.IMDBLandingPage;
import pageobjects.IMDBMovieDetailsPage;
import pageobjects.WikiMainPage;
import pageobjects.WikiSearchResultsPage;

public class MovieInformationValidationTest {
	WebDriver driver = null;

//	String Moviename = "Pushpa: The Rise - Part 1";
//	String Moviename = "Krrish 3";

	@BeforeMethod
	public void setup() {

		// Initialize Driver

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		// Maximize Window
		driver.manage().window().maximize();

		// Declared Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test()
	@Parameters(value = {"Moviename"})
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
		Assert.assertEquals(countryimdb, countrywiki);

		// Compare ReleaseDate From IMDB and WIKI
		Assert.assertEquals(releasedateimdb, releasedatewiki);

		System.out.println("Data of Movie " + Moviename + " in IMDB and WIKI Matched Successfully");
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}