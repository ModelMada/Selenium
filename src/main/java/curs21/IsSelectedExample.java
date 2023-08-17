package curs21;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Utils.BaseTest;
/*
 * The Is Element Selected command determines if the referenced element is selected or not. This operation only makes sense on input elements of the Checkbox- and Radio Button states, or on option elements.
 */

public class IsSelectedExample extends BaseTest {
	
	@Test
	public void isSelectedTest() throws InterruptedException {
	//	WebElement element ;
	//	element.isDisplayed(); 	//functioneaza pe orice fel de element si verifica daca este disponibil
	//	element.isSelected(); //funtioneaza doar pe checkboxes sau radiobutton
		
	//isSelected() funtioneaza doar pe elementele care au atributul type = 'checkbox' sau type = 'radio-button' ------>    <input type="checkbox" value="forever" id="rememberme" name="rememberme">	
		driver.findElement(By.cssSelector("li>a[class*='popup_link']")).click();
		WebElement rememberMe = driver.findElement(By.cssSelector("li input[id='rememberme']"));	//li input s-a folosit spatiu pt ca input nu este direct child pt atributul list, este nepot
		System.out.println(rememberMe.isSelected());
		
		Thread.sleep(3000);
		
		rememberMe.click();
		System.out.println("After click: "+ rememberMe.isSelected());
		assertTrue(rememberMe.isSelected());
		
		
		WebElement usernameField = driver.findElement(By.cssSelector("li input[id='log']"));
		usernameField.click();
		Thread.sleep(3000);
		System.out.println("Username after click: "+ usernameField.isSelected());		//returneaza FALSE pt ca elementul nu este de tip checkbox/radiobutton
		
	}

}
