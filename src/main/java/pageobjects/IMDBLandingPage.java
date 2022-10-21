package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IMDBLandingPage {

	WebDriver driver;

	By searchbox = By.id("suggestion-search");

	public IMDBLandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public IMDBMovieDetailsPage searchMovie(String moviename) {
		driver.findElement(searchbox).sendKeys(moviename);
		driver.findElement(By.xpath("//div[text()=\"" + moviename + "\"]")).click();
		return new IMDBMovieDetailsPage(driver);
	}

	public void goTo() {
		driver.get("https://www.imdb.com/");
	}
}
