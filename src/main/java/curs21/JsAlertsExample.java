package curs21;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Utils.BaseTest;
/*
 * alertele apar in afara DOMului, nu pot fi identificate
 * selenium nu poate interactiona cu o alerta decat daca face un switch catre alt context, catre o alterta JS
 * cazuri cand facem switch de context: cand trec dintr-un tab in altul/ alerte JS/ iFrames
 */

public class JsAlertsExample extends BaseTest {
	
	@Test (priority=1)
	public void simpleJsAlertExample() throws InterruptedException {
		driver.findElement(By.cssSelector("button[onclick = \"jsAlert()\"")).click();
		Thread.sleep(3000);
		
		//trebuie sa schimbam focusul pe alerte JS	
		//alert().accept() -> da click pe ok
		driver.switchTo().alert().accept(); //va da click pe butonul OK; merg doar metodele care sunt marcate cu Alert din cele predefinite
		
		WebElement result = driver.findElement(By.cssSelector("p[id=\"result\"]"));
		assertEquals(result.getText(), "You successfully clicked an alert");
		
		
	}
	
	@Test(priority=2)
	public void confirmJsAlertExample() throws InterruptedException {
		driver.findElement(By.cssSelector("button[onclick = \"jsConfirm()\"")).click();
		Thread.sleep(3000);
		
		//trebuie sa schimbam focusul pe alerte JS
		//alert().dismiss(); da click pe cancel
		driver.switchTo().alert().dismiss(); //va da click pe butonul Cancel; merg doar metodele care sunt marcate cu Alert din cele predefinite
		
		WebElement result = driver.findElement(By.cssSelector("p[id=\"result\"]"));
		assertEquals(result.getText(), "You clicked: Cancel");		
	}	
	
	@Test(priority=3)
	public void promptJsAlertExample() throws InterruptedException {
		driver.findElement(By.cssSelector("button[onclick = \"jsPrompt()\"")).click();
		Thread.sleep(3000);
		
		//clasa parinte de alerte
		Alert alertaJs = driver.switchTo().alert();	//pune in obiectul js alerta respectiva
		alertaJs.sendKeys("Text");		//textul este trimis in DOM, dar nu este vizibil la rulare, se scrie in background
		alertaJs.accept();
		
		
		
		WebElement result = driver.findElement(By.cssSelector("p[id=\"result\"]"));
		assertEquals(result.getText(), "You entered: Text");		
	}	

}
