package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IMDBMovieDetailsPage {

	WebDriver driver;
	By country = By.cssSelector("a[href=\"/search/title/?country_of_origin=IN&ref_=tt_dt_cn\"]");
	By releasedate = By.xpath("(//li[@data-testid=\"title-details-releasedate\"]//a)[2]");
	By releasedateIndia = By.xpath("(//a[contains(@href,\"region=in\")]/../following-sibling::td)[1]");

	public IMDBMovieDetailsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public String getCountry() {
		return driver.findElement(country).getText();
	}

	public String getReleaseDate() {
		driver.findElement(releasedate).click();
		return driver.findElement(releasedateIndia).getText();
	}
}
