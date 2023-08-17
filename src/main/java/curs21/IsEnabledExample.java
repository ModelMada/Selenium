package curs21;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Utils.BaseTest;

public class IsEnabledExample extends BaseTest{
	
	@Test
	public void isEnabledTest() {
		
		driver.findElement(By.cssSelector("li>a[class*='popup_link']")).click();
		
		WebElement usernameField = driver.findElement(By.cssSelector("li input[id='log']"));
		System.out.println("Username before: "+ usernameField.isEnabled());
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].setAttribute('disabled', '')", usernameField);
		System.out.println("Username after: "+ usernameField.isEnabled());
		
		usernameField.sendKeys("ceva");
		
		/*
		 * FAILED: curs21.IsEnabledExample.isEnabledTest
		   org.openqa.selenium.ElementNotInteractableException: element not interactable
		 */
		
		
		
	}
}
