package krishna.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import krishna.PageObjects.CartPage;
import krishna.PageObjects.OrdersPage;

public class AbstractComponent {
	
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="ul li:nth-of-type(4)")
	WebElement cartButton;
	
	@FindBy(css="ul li:nth-of-type(3)")
	WebElement ordersButton;
	
	public void waitForElementToAppear(By findBy) {	

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	
	}
	
//	public void waitForWebElementToAppear(WebElement findBy) {	
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOf(findBy));
//		
//		}
	
	public CartPage goToCart() {
		
		cartButton.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public OrdersPage goToOrders() {
		
		ordersButton.click();
		OrdersPage ordersPage = new OrdersPage(driver);
		return ordersPage;
	}
	
	public void waitForElementToDisappear(WebElement ele) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}

}
	
