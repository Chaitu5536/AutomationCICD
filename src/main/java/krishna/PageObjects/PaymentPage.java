package krishna.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import krishna.AbstractComponents.AbstractComponent;

public class PaymentPage extends AbstractComponent{
	
	WebDriver driver;
	
	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".form-group .text-validated")
	WebElement countryInput;
	
	@FindBy(css=".ta-item")
	List<WebElement> options;
	
	@FindBy(css=".action__submit")
	WebElement placeOrder;
	
	By countryList = By.cssSelector(".ta-item");
	
	public void selectCountry(String country) throws InterruptedException {
		
//	Thread.sleep(2000);
	Actions a = new Actions(driver);
	a.sendKeys(countryInput, country).build().perform();
	
	waitForElementToAppear(countryList);
	WebElement countryTo = options.stream().filter(op->op.getText().equalsIgnoreCase("India")).findFirst().orElse(null);
	countryTo.click();
	
	}
	
	public ConfirmationPage placeOrder() {
		
		placeOrder.click();
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		return confirmationPage;
	}

}
