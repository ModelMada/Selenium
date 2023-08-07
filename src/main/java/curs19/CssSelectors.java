package curs19;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Utils.BaseTest;

public class CssSelectors extends BaseTest {

	@Test(priority=1)
	public void cssSelectorsExample() throws InterruptedException{
		
		/*
		 * <ul id="menu_user" class="menu_user_nav inited sf-js-enabled sf-arrows">
		 * 
		 * ul[id='menu_user']   sau ul#menu_user
		 * 
		 * # reprezinta o referinta catre id
		 * #menu_user  inseama orice element care are id = menu+user
		 * 
		 * . ---> in CSS . este o referinta catre atributul class; > referinta directa catre copilul de sub atributul class
		 * 		.menu_user_nav >> gaseste orice combiatie din interiorul classului; daca bagam [css="tot ce exista pe atributul class"]
		 * 		ul.menu_user_nav	sau 	ul[class='menu_user_nav']
		 * 		li.menu_user_login>a[href='#popup_logi']
		 * 		li[class='menu_user_login']>a[href='#popup_login']		--> ">" face referinta catre copilul de tag a de sub class
		 * # ---> in CSS este o referinta catre atributul ID
		 * 		#menu_user  inseama orice element care are id = menu+user
		 * 		ul#menu_user
		 * 
		 * 
		 */
		// # --> referinta catre atributul id
		WebElement loginMenu = driver.findElement(By.cssSelector("#menu_user"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('style', 'border:4px solid red')", loginMenu);
		// . --> referinta catre atributul class
		WebElement logoSlogan = driver.findElement(By.cssSelector(".logo_slogan"));
		jse.executeScript("arguments[0].setAttribute('style', 'border:4px solid red')", logoSlogan);
		
		WebElement updatesText = driver.findElement(By.cssSelector("div.wpb_wrapper>h3.sc_title_underline"));
		jse.executeScript("arguments[0].setAttribute('style', 'border:4px solid black')", updatesText);
		Thread.sleep(2000);
	}
	
	@Test(priority=2)
	public void cssSelectorExample2() {
	/*
	 * h3[class*="sc_title sc_title_regular"   ---> * reprezinta contains, nu obliga userul sa puna tot textul de sub class
	 */
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	// * --> contains (cauta o combinatie)
	WebElement bookTilte = driver.findElement(By.cssSelector("h3[class*=\'sc_title_reg\'"));  //nu are nevoie de tot Stringul complet
	jse.executeScript("arguments[0].setAttribute('style', 'border:4px solid blue')", bookTilte);
	// ~ --> contains Word (cauta match case exact, un String exact -- daca clasa are mai multe stringuri despartite de spatii, are nevoie de un string delimitat de spatii)
	WebElement bookTilte2 = driver.findElement(By.cssSelector("h3[class~=\'sc_title_regular\'"));	//are nevoie de Stringul complet
	jse.executeScript("arguments[0].setAttribute('style', 'background: orange; border:4px solid blue')", bookTilte2);
	// ^ --> dam valoarea de inceput a atributului, cu ce incepe 
	WebElement bookTilte3 = driver.findElement(By.cssSelector("a[href^='life']"));	
	jse.executeScript("arguments[0].setAttribute('style', 'background: orange; border:4px solid blue')", bookTilte3);
	// $ --> ends with
	WebElement bookTilte4 = driver.findElement(By.cssSelector("a[href$='silence']"));	
	jse.executeScript("arguments[0].setAttribute('style', 'background: orange; border:4px solid blue')", bookTilte4);
}
}
