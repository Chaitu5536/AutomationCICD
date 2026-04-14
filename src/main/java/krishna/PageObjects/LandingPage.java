package krishna.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import krishna.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
	WebDriver driver;
	
	
	public LandingPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	WebElement userEmail = driver.findElement(By.id("userEmail")); line for reference that how we can convert to page factory model below
	
	 @FindBy(id="userEmail")
	 WebElement userEmail;
	 
	 @FindBy(id="userPassword")
	 WebElement passwordEle;
	 
	 @FindBy(id="login")
	 WebElement submit;
	 
//	 @FindBy(css="div[role='alert']")
//	 WebElement errorMessage;
	 
	 
	 By errorMessage = By.cssSelector("div[role='alert']");
	 By loginMessage = By.cssSelector(".toast-title");
	 
	 public String getErrorMessage() {
		 waitForElementToAppear(errorMessage);
		 return driver.findElement(errorMessage).getText();
		 
	 }
	 
	 
	 public void goTo() {
		 driver.get("https://rahulshettyacademy.com/client");
	 }
	 
	 
	 
	 public ProductCatalogue loginApplication(String email, String password) throws InterruptedException {
		 
		 userEmail.sendKeys(email);
		 passwordEle.sendKeys(password);
		 submit.click();
//		 waitForElementToAppear(loginMessage);
		 ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		 return productCatalogue;
		 
	 }

}
