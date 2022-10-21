package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiSearchResultsPage {

	WebDriver driver;

	@FindBy(xpath = "//th[text()=\"Country\"]/../td")
	WebElement country;

	@FindBy(xpath = "//div[text()=\"Release date\"]/../../td//li")
	WebElement releasedate;

	public WikiSearchResultsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getCountry() {
		return country.getText();
	}

	public String getReleaseDate() {
		return releasedate.getText();
	}

}
