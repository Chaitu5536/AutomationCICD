package krishna.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import krishna.AbstractComponents.AbstractComponent;

public class OrdersPage extends AbstractComponent{
	
	WebDriver driver;
	
	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	


	@FindBy(css="tr td:nth-of-type(2)")
	List<WebElement> orderedProducts;
	
	
	public Boolean verifyOrdered(String productName) {
		
		Boolean match = orderedProducts.stream().anyMatch(cp->cp.getText().equalsIgnoreCase(productName.trim()));
		return match;
	}
	
	

	
	

}
