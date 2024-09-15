package projectNFInnova;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseClassNFInnova {
	WebDriver driver;
	LoginPageNFInnova loginPage;
	@BeforeTest
	public void initialization() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		loginPage = new LoginPageNFInnova (driver);
	}
	 @AfterTest
	  public void closeDriver() {
	     driver.quit();
	 }  
}