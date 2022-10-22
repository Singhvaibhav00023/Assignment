package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiMainPage {

	WebDriver driver;

	@FindBy(css = "input[id=\"searchInput\"]")
	private WebElement searchbox;

	@FindBy(id = "searchButton")
	private WebElement searchbutton;

	public WikiMainPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WikiSearchResultsPage searchMovie(String moviename) {
		searchbox.sendKeys(moviename);
		searchbutton.click();
		return new WikiSearchResultsPage(driver);
	}

	public void goTo() {
		// Navigate to WIKI URL
		driver.get("https://en.wikipedia.org/");
	}

}
