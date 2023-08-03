package curs18;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Utils.BaseTest;

public class SeleniumLocators extends BaseTest {

	/*
	 * tagName
	 * linkText
	 * partialLinkText
	 * id
	 * name
	 * class name
	 * xpath
	 * css selector
	 */
	
	@Test
	public void tagNameLocator() {
		
		System.out.println("test");	
		System.err.println("eroare de test");
		
		WebElement discoverText = driver.findElement(By.tagName("em"));		//fac request catre browser o singura data si pastrez elemetul ca obiect de tip web driver pe care il pot apela cu orice functie //ia primul element cu tagul em
		System.out.println(discoverText.getText());
//		discoverText.click();
		assertEquals(discoverText.getText(), "Discover");
		
		driver.findElement(By.tagName("em")).getText();	//fac de fiecare data request catre browser pe elementul respectiv
//		driver.findElement(By.tagName("em")).click());
		
		//ca sa pot aplica metodele din selenium trebuie sa am un obiect de tip webElement
		
	}
	
	@Test(priority=2)
	public void linkTextLocator() {
		//linkText se aplica doar pe taguri de tip <a>
		//<a href="https://keybooks.ro/shop/">Books</a>
		driver.findElement(By.linkText("BOOKS")).click();
		assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/shop/");
	}
	
	@Test(priority=3)
	public void partialLinkTextLocator() {
		driver.findElement(By.partialLinkText("Cooking")).click();
		assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/shop/cooking-with-love/");
		
		//<a href="https://keybooks.ro/shop/cooking-with-love/">Cooking with love</a>
		/*
		 * la link text trebuie sa pun tot linkul
		 * la partialLinkText pot sa pun doar o parte din link
		 * exemple
		 * Partial link text: Cooking
		 * Partial link text: with
		 * Partial link text: love
		 * fac referinta catre tagurile de tip a
		 */
	}
	
	@Test(priority=4)
	public void classNameLocator() {
		//<p class = "price">
		WebElement price = driver.findElement(By.className("price"));
		//isDisplayed() --verifica daca un webelement apare (este vizibil) in aplicatie
		assertTrue(price.isDisplayed());
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('style', 'border:4px solid red')", price);		//facem highlight la u webelemet pe care nu vreau neaparat sa l folosesc
		System.out.println(price.getText());
		assertTrue(price.getText().contains("20,55"));
		
	}
	
	@Test(priority=5)
	public void idLocator() {
		driver.findElement(By.id("tab-title-reviews")).click();
		
		WebElement commentBox = driver.findElement(By.id("comments"));
		assertTrue(commentBox.isDisplayed());
	}
	
}
