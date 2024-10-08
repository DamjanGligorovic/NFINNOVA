package projectNFInnova;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageNFInnova {
	private WebDriver driver;
	Actions actions;
	private WebDriverWait wait;
	Select select;
	@FindBy (id="usernameInput")
	WebElement inputField_Username;
	@FindBy(id="passwordInput")
	WebElement inputField_Password;
	@FindBy(css=".active[data-id='1']")
	WebElement category_IHaveAccount;
	@FindBy(css="span[data-id='2']")
	WebElement category_CreateAccount;
	@FindBy(css="button.btn-1.color-1")
	List<WebElement> button_Login;
	@FindBy(css="[data-class=\"login\"]")
	WebElement button_Login1;
	@FindBy(css="#panelUsernamePassword > button")
	WebElement button_Login2;
	@FindBy(css=".dropdown-trigger")
	List<WebElement> list_Darts;
	@FindBy(css=".dropdown-trigger")
	List<WebElement> list_Button_Payment;
	@FindBy(css="body > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(9) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1) > span:nth-child(2)")
	WebElement button_InternalTransfer;
	@FindBy(id="dk1-combobox")
	WebElement inputField_ToAccount;
	@FindBy(css="svg.account-detail-arrow")
	List<WebElement> list_DartsAccounts;
	@FindBy(css="body > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > h2:nth-child(1) > span:nth-child(1)")
	WebElement secondaryAccountText;
	@FindBy(css="div.accounts-intro-balance.right,resp")
	List<WebElement> listButtonsSecondary;
	@FindBy(css="input.input-1.input-amount")
	List<WebElement> inputsFieldsPaymentReference;
	@FindBy(id="inputAmount")
	WebElement inputField_Amount;
	@FindBy(css="[data-attr=\"button-submit\"]")
	WebElement button_Continue;
	@FindBy(css="[data-attr=\"confirmExchange\"]")
	WebElement button_Confirm;
	@FindBy(css="a.holos-menu-item[data-page-id=\"137460\"]")
	WebElement button_Payment1;
	@FindBy(css="div[id='mCSB_1_dragger_vertical'] div[class='mCSB_dragger_bar']")
	WebElement draggerToggleButton;
	@FindBy(id="messageBoxElement")
	WebElement errorMessage;
	@FindBy(css=".ui-dialog-buttonset")
	WebElement button_OK;
	
	
public LoginPageNFInnova (WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	actions = new Actions(driver);
	wait = new WebDriverWait(driver, Duration.ofSeconds(30));
}

public void insertInput_Username(String input) {
	wait.until(ExpectedConditions.visibilityOf(inputField_Username));
	inputField_Username.clear();
	inputField_Username.sendKeys(input);
}
public void insertInput_Password(String input) {
	wait.until(ExpectedConditions.visibilityOf(inputField_Password));
	inputField_Password.clear();
	inputField_Password.sendKeys(input);
}
public boolean verifySelectedCategoryIHaveAccount() {
	return category_IHaveAccount.isEnabled();
}
public boolean verifySelectedCategoryCreateAccount() {
	return !category_IHaveAccount.isSelected();
}
public void click_ButtonLogin() {
	wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("button.btn-1.color-1"), 11));
	button_Login.get(0).click();
}
public void click_ButtonLogin1() {
	wait.until(ExpectedConditions.elementToBeClickable(button_Login1)).click();
}
public void click_ButtonLogin2() {
	wait.until(ExpectedConditions.elementToBeClickable(button_Login2)).click();
}
public void click_List_Darts() {
	wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".dropdown-trigger"), 3));
	button_Login.get(2).click();
}

public void click_ButtonPayment() {
	wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".dropdown-trigger"), 3));
	list_Button_Payment.get(2).click();
}

public void click_InternalTransfer() {
	wait.until(ExpectedConditions.elementToBeClickable(button_InternalTransfer)).click();
}
public String verifyInputDefault() {
	return inputField_ToAccount.getText().replaceAll("[^\\d.]", "");
}
public String verifyinputDefault2() {
	return  secondaryAccountText.getText().replaceAll("[^\\d.]", "");
}
public void clickDartsAccounts() {
	wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("svg.account-detail-arrow"), 3));
	list_DartsAccounts.get(0).click();
}
public void insertReferenceInput(String input) {
	wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("input.input-1.input-amount"), 2));
	inputsFieldsPaymentReference.get(0).clear();
	inputsFieldsPaymentReference.get(0).sendKeys(input);
}
public void clicklistButtonsSecondary() {
	wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("div.accounts-intro-balance.right,resp"), 3));
	listButtonsSecondary.get(2).click();
}
public void insertAmount(String input) {
	wait.until(ExpectedConditions.visibilityOf(inputField_Amount));
	inputField_Amount.clear();
	inputField_Amount.sendKeys(input);
}
public void clickButtonContinue() {
	wait.until(ExpectedConditions.elementToBeClickable(button_Continue)).click();
}
public void clickButtonConfirm() {
	wait.until(ExpectedConditions.elementToBeClickable(button_Confirm)).click();
}

public void scrollDownUsingDragger() {
    Actions actions = new Actions(driver);
    actions.moveToElement(draggerToggleButton).perform();
    actions.clickAndHold(draggerToggleButton)
           .moveByOffset(0, 1000) // Adjust the offset for more scroll distance
           .release()
           .perform();
}


public boolean verifyErrorMessage() {
	return errorMessage.isDisplayed();
}
public void clickButtonOk() {
	wait.until(ExpectedConditions.elementToBeClickable(button_OK)).click();
}

public void clickPaymentSection() {
    try {
        WebElement paymentSection = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li.payment-ico.dropdown > a")));
        
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paymentSection);
        
        wait.until(ExpectedConditions.visibilityOf(paymentSection));

        actions.moveToElement(paymentSection).click().perform();
        
        if (!paymentSection.isDisplayed()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", paymentSection);
        }
        
    } catch (ElementClickInterceptedException e) {
        System.out.println("Element is blocked from being clicked: " + e.getMessage());
        
        WebElement paymentSection = driver.findElement(By.cssSelector("li.payment-ico.dropdown > a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", paymentSection);
        
    } catch (TimeoutException e) {
        System.out.println("Timeout while waiting for the payment section: " + e.getMessage());
    } catch (Exception e) {
        System.out.println("An error occurred while clicking the payment section: " + e.getMessage());
    }
}
public void scrollDown() {
    try {
        WebElement dragger = driver.findElement(By.cssSelector("#mCSB_1_dragger_vertical .mCSB_dragger_bar"));
        int draggerHeight = dragger.getSize().height;
   
        int scrollAmount = 100; 
        
        Actions actions = new Actions(driver);
        
        actions.clickAndHold(dragger)
               .moveByOffset(0, scrollAmount) 
               .release()
               .perform();
        
        System.out.println("Scrolled down successfully.");
        
    } catch (Exception e) {
        System.out.println("An error occurred while scrolling: " + e.getMessage());
    }
}

}


