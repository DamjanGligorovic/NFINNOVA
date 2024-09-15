package projectNFInnova;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestClassNFInnova extends BaseClassNFInnova {
WebDriverWait wait;

   @BeforeMethod
   public void navigation() {
   driver.navigate().to("http://ibweb25.saga.rs/PRODUCT/Retail/Retail/Home/Login");
   wait = new WebDriverWait(driver, Duration.ofSeconds(20));
   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
   
   }
   @AfterMethod
   public void deleteCookie() {
   driver.manage().deleteAllCookies();
 }
   @Test
   public void internalTransfer()  {
   SoftAssert softassert = new SoftAssert();
   String actualURL = driver.getCurrentUrl();
   String expectedURL = "http://ibweb25.saga.rs/PRODUCT/Retail/Retail/Home/Login";
   String actualTitle = driver.getTitle();
   String expectedTitle = "Fintense by Innova";
   softassert.assertTrue(loginPage.verifySelectedCategoryCreateAccount(), "The Category Create Account is Selected.");
   softassert.assertTrue(loginPage.verifySelectedCategoryIHaveAccount(), "The Category I Have Account is not Selected.");
   softassert.assertEquals(actualTitle, expectedTitle, "The Titles are not matched.");
   softassert.assertEquals(actualURL, expectedURL, "The URL's are not matched");
   loginPage.insertInput_Username("testproduct");
   loginPage.insertInput_Password("Test123");
   loginPage.click_ButtonLogin2();
   String actualTitle1 = driver.getTitle();
   String expectedTitle1 = "Fintense by Innova";
   softassert.assertEquals(actualTitle1, expectedTitle1, "The Titles are not matched.");
   String actualURL1 = driver.getCurrentUrl();
   String expectedURL2 = "http://ibweb25.saga.rs/PRODUCT/Retail/Retail/";
   softassert.assertNotEquals(actualURL1, expectedURL2, "The URL's are  matched.");
   loginPage.scrollDown();
   loginPage.clickPaymentSection();
   loginPage.click_InternalTransfer();
   String actualURL3 = driver.getCurrentUrl();
   String expectedURL3 = "http://ibweb25.saga.rs/PRODUCT/Retail/Retail/user/placanja/internal_transfer";
   softassert.assertEquals(actualURL3, expectedURL3);
   String actualText = loginPage.verifyInputDefault();
   loginPage.clickDartsAccounts();
   String expectedText= loginPage.verifyinputDefault2();
   softassert.assertEquals(expectedText, actualText, "The Prices are not matched");
   loginPage.clicklistButtonsSecondary();
   loginPage.insertReferenceInput("Transaction workflow");
   loginPage.insertAmount("500.00");
   loginPage.clickButtonContinue();
   loginPage.clickButtonConfirm();
   softassert.assertTrue(loginPage.verifyErrorMessage());
   loginPage.clickButtonOk();
   softassert.assertAll();
   }
  
}