package curs21;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Utils.BaseTest;

public class ImplicitWaitExample extends BaseTest {
	
	@Test
	public void implicitWaitTest() throws InterruptedException {
		//implicit wait se aplica pe toate web elementele, se aplica pe instanta de driver
		//cand face findElement, Selenium va aplica waitul implicit
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	//avantajul este ca desi ii setam 10 secunde, daca conditia in aplicatie este indeplinita, daca elem apare dupa 2 sec, nu mai sta restul de timp si asteapta, da resume la executie
		
		driver.findElement(By.cssSelector("div[id=\"start\"]>button")).click();
		
		// Thread.sleep(5000);	//bad practice, el sta 3 secunde indiferent de ce se intampla in aplicatie
		
		WebElement helloWorld = driver.findElement(By.cssSelector("div[id=\"finish\"]>h4"));
		assertEquals(helloWorld.getText(),"Hello World!");
	}

}
