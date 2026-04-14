package krishna.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import krishna.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	


	@FindBy(css=".cart h3")
	List<WebElement> cartProducts;
	
	@FindBy(css=".subtotal .btn")
	WebElement checkOutButton;
	
	public Boolean verifyProduct(String productName) {
		
		Boolean match = cartProducts.stream().anyMatch(cp->cp.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public PaymentPage clickOnCheckout() {
		checkOutButton.click();
		PaymentPage paymentPage = new PaymentPage(driver);
		return paymentPage;
	}

	
	

}
