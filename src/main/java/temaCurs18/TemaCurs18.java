package temaCurs18;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Utils.BaseTest;

public class TemaCurs18 extends BaseTest{
	
	@Test(priority=1)
	public void findLoginButton() throws InterruptedException {
		
		WebElement login = driver.findElement(By.linkText("Login"));
		//<a href="#popup_login" class="popup_link popup_login_link icon-user inited" title="">Login</a>
		assertTrue(login.isDisplayed());
		
		WebElement loginOrEmail = driver.findElement(By.id("log"));
		System.out.println(loginOrEmail.isDisplayed());
		
		WebElement password = driver.findElement(By.id("password"));
		System.out.println(password.isDisplayed());
		
		login.click();
		Thread.sleep(3000);
		
		assertTrue(loginOrEmail.isDisplayed());
		System.out.println(loginOrEmail.isDisplayed());
		assertTrue(password.isDisplayed());	
		System.out.println(loginOrEmail.isDisplayed());
	}
}
