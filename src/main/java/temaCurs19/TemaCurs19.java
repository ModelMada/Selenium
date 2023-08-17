package temaCurs19;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Utils.BaseTest;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class TemaCurs19 extends BaseTest{
	
	@Test
	public void findTheBook() {

		//WebElement searchedBook = driver.findElement(By.linkText("The forest"));
		WebElement searchedBook = driver.findElement(By.cssSelector("a[href^='the-forest']"));
		
		List<WebElement> menuEntries = driver.findElements(By.cssSelector("li[class*='sc_tabs_title']:not([aria-selected='true'])"));
		for(WebElement element : menuEntries) {
			element.click();
//			if(searchedBook.isDisplayed()) {
//				searchedBook.click();
//				System.out.println(driver.getCurrentUrl());		
			
			System.out.println(searchedBook.isDisplayed());
			}
		}
		
	}


