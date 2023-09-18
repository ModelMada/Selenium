package temaCurs21;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Utils.BaseTest;

public class TemaCurs21 extends BaseTest {
	
	@Test(priority=1)
	public void addBookReview() {
		
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/");
		driver.findElement(By.cssSelector("a[href=the-forest]")).click();
		driver.findElement(By.cssSelector("li[id=tab-title-reviews]")).click();
		//assert ca checkboxul nu este selectat
		System.out.println(driver.findElement(By.cssSelector("input[id=wp-comment-cookies-consent]")).isSelected());
		//assertTrue(driver.findElement(By.cssSelector("input[id=wp-comment-cookies-consent]")).isSelected());
		//click pe submit si tratarea alertei JS
		driver.findElement(By.cssSelector("input[id=submit]")).click();
		driver.switchTo().alert().accept();
		//completam campurile review
		driver.findElement(By.cssSelector("a[class=star-5]")).click();
		driver.findElement(By.cssSelector("textarea[id=comment]")).sendKeys("My review2");
		driver.findElement(By.cssSelector("input[id=author]")).sendKeys("Madalina Model");
		driver.findElement(By.cssSelector("input[id=email]")).sendKeys("mada@abc.com");
		driver.findElement(By.cssSelector("input[id=wp-comment-cookies-consent]")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id=wp-comment-cookies-consent]")).isSelected());
		assertTrue(driver.findElement(By.cssSelector("input[id=wp-comment-cookies-consent]")).isSelected());
		driver.findElement(By.cssSelector("input[id=submit]")).click();
		//facem assert dupa submit
		System.out.println(driver.findElement(By.cssSelector("em[class=woocommerce-review__awaiting-approval]")).getText());
		assertEquals(driver.findElement(By.cssSelector("em[class=woocommerce-review__awaiting-approval]")).getText(), "Your review is awaiting approval");
		
	}

}
