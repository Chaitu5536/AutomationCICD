package selenium.TestClasses;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import krishna.PageObjects.CartPage;
import krishna.PageObjects.ConfirmationPage;
import krishna.PageObjects.LandingPage;
import krishna.PageObjects.OrdersPage;
import krishna.PageObjects.PaymentPage;
import krishna.PageObjects.ProductCatalogue;
import selenium.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest{
	
	String productName = "ADIDAS ORIGINAL";
	String country = "ind";	
	
	@Test(dataProvider="getData", groups= {"Purchase"})
	public void submitOrder(HashMap<String, String> input) throws InterruptedException, IOException  {
		
		
		
			
//		launchApplication(); no need to call here because @BeforeMethod will do that launching the application
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
		productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));
		Thread.sleep(4000);
		CartPage cartPage = productCatalogue.goToCart();
		Boolean match = cartPage.verifyProduct(input.get("product"));
		Assert.assertTrue(match);
		PaymentPage paymentPage = cartPage.clickOnCheckout();			
		System.out.println("code is continuing");
		paymentPage.selectCountry(country);
		ConfirmationPage confirmationPage = paymentPage.placeOrder();
		String ab = confirmationPage.getTheMessage();
		Assert.assertTrue(ab.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		System.out.println("Test Completed");
		
	}
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void OrderHistoryTest() throws InterruptedException {
		ProductCatalogue productCatalogue = landingPage.loginApplication("chaitanyakrishna043@gmail.com", "Chaitanya@123");
		OrdersPage ordersPage = productCatalogue.goToOrders();
		ordersPage.verifyOrdered(productName);
		Boolean match = ordersPage.verifyOrdered(productName);
		Assert.assertTrue(match);
		System.out.println(match);
		System.out.println("Product showing in the orders");
		
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "anshika@gmail.com");
//		map.put("password", "Iamking@000");
//		map.put("product", "ZARA COAT 3");
//		
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("email", "chaitanyakrishna043@gmail.com");
//		map1.put("password", "Chaitanya@123");
//		map1.put("product", "ADIDAS ORIGINAL");
		
		List<HashMap<String, String>> data = getJsonDataToHash(System.getProperty("user.dir") + "\\src\\test\\java\\selenium\\data\\PurchaseOrder.json");
		
		return new Object[][] {{data.get(0)}, {data.get(1)}};
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
		
		
		
		
		







