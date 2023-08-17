package curs21;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Utils.BaseTest;

public class ExplicitWaitExample extends BaseTest{

	@Test
	public void explicitWaitTest() {
		
		driver.findElement(By.cssSelector("div[id=\"start\"]>button")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div[id=\"finish\"]>h4"),"Hello World!"));
		
		WebElement helloWorld = driver.findElement(By.cssSelector("div[id=\"finish\"]>h4"));
		assertEquals(helloWorld.getText(),"Hello World!");
	}
}
