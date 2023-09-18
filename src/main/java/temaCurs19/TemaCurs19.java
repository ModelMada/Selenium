package temaCurs19;

import static org.testng.Assert.assertEquals;
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
		//div[aria-hidden='false'] a[href^='the-forest']  // asta poate fi cautat in afara 
		//WebElement searchedBook = driver.findElement(By.linkText("The forest"));
		// WebElement searchedBook = driver.findElement(By.cssSelector("a[href^='the-forest']")); //daca identific cartea in afara forului, identific cartea, gaseste 4 elemente. il gaseste pr primul si apoi cand da click pe tabul 2 trebuie sa gaseasca elementul 2 si il gaseste tot pe primul
		
		WebElement searchedBook = driver.findElement(By.cssSelector("div[aria-hidden ='false'] a[href='the-forest']"));
		List<WebElement> categories = driver.findElements(By.cssSelector("li[class*='sc_tabs_title']:not([aria-selected='true'])"));
		for(WebElement element : categories) {
			element.click();
			//WebElement searchedBook = driver.findElement(By.cssSelector("a[href^='the-forest']"));	//va interoga de fiecare data domul
			searchedBook.isDisplayed();
			}	//la finalul forului oricum va fi cu clickul pe ultimul element din lista
		
		searchedBook.click();
		System.out.println(driver.getCurrentUrl());
		assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/shop/the-forest/");
		
		}
		
	}



/*
 * /*
		 * 
		 * List<WebElement> categoryTabs = driver.findElements(By.cssSelector("sc_tabs_title"));
		 * 
		 * WebElement theForest = driver.findElement(By.cssSelector("div[aria-hidden ='false'] a[href='the-forest']"));
		 * for(WebElement element : categoryTabs){
		 * 	
		 * 	element.click();
		 *  theForest.isDisplayed();
		 * 
		 * }
		 * 
		 * theForest.click();
		 * ---assert
		 * 
		 *
		 *
		 *alta varianta era sa iteram cu for i, si cand i = catergories.length.-1
		 *
		 *sau
		 *element.getText().equals('award winners')
 */







