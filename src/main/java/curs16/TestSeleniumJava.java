package curs16;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

public class TestSeleniumJava {

	
	@Test
	public void testOpenBrowser() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://keybooks.ro/");
	}
}
