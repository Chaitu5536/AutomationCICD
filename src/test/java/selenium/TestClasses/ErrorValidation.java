package selenium.TestClasses;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import krishna.PageObjects.CartPage;
import krishna.PageObjects.ConfirmationPage;
import krishna.PageObjects.LandingPage;
import krishna.PageObjects.PaymentPage;
import krishna.PageObjects.ProductCatalogue;
import selenium.TestComponents.BaseTest;
import selenium.TestComponents.Retry;

public class ErrorValidation extends BaseTest{
	
	@Test(groups= {"ErrorHandling"}, retryAnalyzer=Retry.class)
	public void wrongCredentialsValidation() throws InterruptedException, IOException  {
		
		landingPage.loginApplication("chaitanyakrishna043@gmail.com", "Chaitanya@12");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
		System.out.println("Wrong Credentials");
		
	}
	
	
	
	@Test
	public void wrongProductValidation() throws InterruptedException, IOException  {
		
		String productName = "ZARA COAT 3";
//		String country = "ind";		
//		launchApplication(); no need to call here because @BeforeMethod will do that launching the application
		ProductCatalogue productCatalogue = landingPage.loginApplication("chaitanyakrishna043@gmail.com", "Chaitanya@123");
		productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		Thread.sleep(3000);
		CartPage cartPage = productCatalogue.goToCart();
		Boolean match = cartPage.verifyProduct("ZARA COAT 33");
		Assert.assertFalse(match);
		System.out.print("Wrong Product");
		
		
	}


}	
		
		
		
		
//		go to url and login with the credentials ****************** after loging landing on productcataloguepage without creating object in test class
//		wait for the elements to be visible and getting them as a list of webelement in products variable ***********
//		selecting a product and adding it to the cart
//		Clicking the cart button logic written in AbstractComponent page and access through productcatalogue page because AbstractComponent is parent to it
//		verifying the name of the product in the cartPage class and taking assertion boolean to the test class
//		clicking on checkout button
//		Optional addition of verifying the code running properly
//		in payments page we are selecting country with the below line
//		clicking place order with the below line
//		getting confirmation message from the confirmation page and asserting
		
//		Actions a = new Actions(driver);
//		
//		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), country).build().perform();
//		
//		
////		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-item")));
		
//		List<WebElement> options = driver.findElements(By.cssSelector(".ta-item"));
//		
//		WebElement countryTo = options.stream().filter(op->op.getText().equalsIgnoreCase("India")).findFirst().orElse(null);
//		
//		countryTo.click();
		
//		driver.findElement(By.cssSelector(".ta-results button:last-of-type")).click(); //static type
		//for(WebElement p:products) {
		//
		//if(p.findElement(By.cssSelector("b")).getText().equals(productName)) {
		//	
//			WebElement prod = p;
//			System.out.println(prod);
//			prod.findElement(By.cssSelector("button.btn.w-10.rounded")).click();
		//}
		//
		//}
		
		
		
		
		







