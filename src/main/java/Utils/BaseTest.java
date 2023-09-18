package Utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

	
	public WebDriver driver;		//vreau sa fie accesibil obiectul , este null, reprezinta browseru nostru
	
	@BeforeClass
	public void setup() {
		
		driver = new EdgeDriver();		
		driver.manage().window().maximize();		//face maximize la browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	//setupul se propaga pe toata rularea, orice findElem va activa implicit wait. se pune in base test ca best practice, nu are sens sa il folosim in test
		driver.get("https://keybooks.ro/");
		//driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		//driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");


	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);			//ca sa se inchida browseru dupa 4 secunde -- este bad practice
		driver.close();
	}
}
