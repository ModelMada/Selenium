package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

	
	public WebDriver driver;		//vreau sa fie accesibil obiectul 
	
	@BeforeClass
	public void setup() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();		//face maximize la browser
		// driver.get("https://keybooks.ro/");
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);			//ca sa se inchida browseru dupa 4 secunde -- este bad practice
		driver.close();
	}
}
