package curs19;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Utils.BaseTest;

public class FindElementsExample extends BaseTest{

	@Test
	public void findElementsExample() {
		/*
		 * driver.findElement --> intoarce un webElement (daca locatorul gaseste mai multe elemente cu acelasi id, actioneaza doar asupra primului)
		 * Daca nu gaseste niciun element cu locatorul, intoarce noSuchElementException
		 * 
		 * driver.findElements --> intoarce o lista de web elements. Putem sa accesam pe baza de index din interiorul listei
		 * Daca nu gaseste niciun element cu locatorul, intoarce o lista goala
		 */
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		List<WebElement> booksTitles = driver.findElements(By.cssSelector("h3[class~=\'sc_title_regular\'"));	//are nevoie de Stringul complet
		System.out.println(booksTitles.size());
		jse.executeScript("arguments[0].setAttribute('style', 'background: orange; border:4px solid blue')", booksTitles.get(1));
	}
}
