package curs20;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Utils.BaseTest;



public class CssSelectorExample2 extends BaseTest{
	/*
	 * li[class*='sc_tabs_title']:first-of-type   >> ia primul element cu patternul asta; * inseamna "contine" stringul din atribut
	 * li[class*='sc_tabs_title']:tf-of-type(2)	>>ia al doilea element si functioneaza pe baza de index cu orice element care urmeaza
	 */
	
	//@Test
	public void cssSelectorTest() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//Home page book categories menu entries
		//first-of-type ---> New Releases
		WebElement newReleases =  driver.findElement
				(By.cssSelector("li[class*='sc_tabs_title']:first-of-type"));
		jse.executeScript("arguments[0].setAttribute"
				+ "('style', 'background: orange;border:4px solid blue')", newReleases);
		
		//nth-of-type --> Coming soon
				WebElement comingSoon =  driver.findElement
						(By.cssSelector("li[class*='sc_tabs_title']:nth-of-type(2)"));
				jse.executeScript("arguments[0].setAttribute"
						+ "('style', 'background:red; border:4px solid black')", comingSoon);
				
		//nth-of-type --> best sellers
				WebElement bestSellers =  driver.findElement
						(By.cssSelector("li[class*='sc_tabs_title']:nth-of-type(3)"));
				jse.executeScript("arguments[0].setAttribute"
						+ "('style', 'background:purple; border:4px solid pink')", bestSellers);
				
		//last-of-type -->>
				WebElement awardWinners =  driver.findElement
						(By.cssSelector("li[class*='sc_tabs_title']:last-of-type"));
				jse.executeScript("arguments[0].setAttribute"
						+ "('style', 'background:grey; border:4px solid yellow')", awardWinners);
	}
	
	@Test
	public void cssSelectorTest2() {
		//selectez doar elem care are atributul aria-selected=true, adica este dat cu clickul pe el in aplicatie
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement menuEntry = driver.findElement(By.cssSelector("li[class*='sc_tabs_title'][aria-selected='true']"));
		jse.executeScript("arguments[0].setAttribute"
				+ "('style', 'background: orange;border:4px solid blue')", menuEntry);
		
		//selectez tot in afara de elementul care are atributul ('aria-selected='true'')
		//apare operatorul not
	
	
	List<WebElement> menuEntries = driver.findElements(By.cssSelector("li[class*='sc_tabs_title']:not([aria-selected='true'])"));
	for(WebElement element : menuEntries) {
		
		jse.executeScript("arguments[0].setAttribute"
				+ "('style', 'background: orange;border:4px solid blue')", element);
	}
	}
	
	@Test
	public void cssSelectorTest3() throws InterruptedException {
		// direct child --> li[class='menu_user_login']>a[class*='popup_login_link']
		//cand sar mai multe elemente ca sa pot identifica unic ---> folosim " " in loc de ">" care face trimitere doar la child ---> ul[class*='menu_user_nav'] a[class*='popup_login_link']
		
		WebElement loginMenu = driver.findElement(By.cssSelector("ul[class*='menu_user_nav'] a[class*='popup_login_link']"));
		loginMenu.click();
		Thread.sleep(3000);
		//logical And --> tagname[atribut=value][atribut=value] ---> li[class='menu_user_login'] input[id='log'][name='log']
		WebElement username = driver.findElement(By.cssSelector("li[class='menu_user_login'] input[id='log'][name='log']"));
		username.sendKeys("TestUser");
		
		//logical OR --  tagname[atribut=value],[atribut=value] (apare o virgula intre atribute)
		WebElement password = driver.findElement(By.cssSelector("input[type='password'],[name='pwd']"));
		password.sendKeys("testUser");
	}
	}

