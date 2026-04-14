package selenium.TestClasses;

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

import krishna.PageObjects.LandingPage;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		
		
		
		String productName = "ZARA COAT 3";
		String country = "ind";
		WebDriver driver = new ChromeDriver();
		
		LandingPage landingpage = new LandingPage(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		
		driver.findElement(By.id("userEmail")).sendKeys("chaitanyakrishna043@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Chaitanya@123");
		driver.findElement(By.cssSelector("input[name='login']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-title")));
		
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
//		for(WebElement p:products) {
//			
//			if(p.findElement(By.cssSelector("b")).getText().equals(productName)) {
//				
//				WebElement prod = p;
//				System.out.println(prod);
//				prod.findElement(By.cssSelector("button.btn.w-10.rounded")).click();
//			}
//			
//		}
		
		
		
		WebElement prod = products.stream().filter(p->
		p.findElement(By.cssSelector("b")).getText().equals(productName))
				.findFirst()
				.orElse(null);
		
		prod.findElement(By.cssSelector("button.btn.w-10.rounded")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ngx-spinner-overlay"))));
//		
		
		driver.findElement(By.cssSelector("[routerlink='/dashboard/cart']")).click();
//		
		Thread.sleep(10);
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cart h3"));
		
		Boolean match = cartProducts.stream().anyMatch(cp->cp.getText().equalsIgnoreCase(productName));
		
		Assert.assertTrue(match);
		
		System.out.println("code is continuing");
		
		driver.findElement(By.cssSelector(".totalRow:last-of-type")).click();
//		
		
		Actions a = new Actions(driver);
		
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), country).build().perform();
		
		
//		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-item")));
		
		List<WebElement> options = driver.findElements(By.cssSelector(".ta-item"));
		
		WebElement countryTo = options.stream().filter(op->op.getText().equalsIgnoreCase("India")).findFirst().orElse(null);
		
		countryTo.click();
		
//		driver.findElement(By.cssSelector(".ta-results button:last-of-type")).click(); //static type
		
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		
		String ab = driver.findElement(By.cssSelector(".hero-primary")).getText();
		
		Assert.assertTrue(ab.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		System.out.println("Test Completed");
		

	}

}
