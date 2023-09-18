package temaCurs20;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Utils.BaseTest;

public class TemaCurs20 extends BaseTest{
	
	@Test(priority=1)
	public void searchDesiredBook() throws InterruptedException {
		WebElement searchButton = driver.findElement(By.cssSelector("div[class*='search_style_regular'] button[title='Open search']"));
		searchButton.click();
		WebElement inputBookname = driver.findElement(By.cssSelector("input[class=\"search_field\"][placeholder=\"Search\"]"));
		inputBookname.sendKeys("The story about me");
		Thread.sleep(1000);
		searchButton.click();
		
		/*
		 * CUM FACEM MAI ELEGAT, sa verificam daca elementul este in pagina, si doar daca nu se afla, atunci sa dam click pe Show more
		 * 
		WebElement storyAboutMeBook = driver.findElement(By.cssSelector("h4[class='post_title'] a[href*='story-about-me']"));
		boolean isPresent = storyAboutMeBook.isDisplayed();
		System.out.println(isPresent);
		while(isPresent = false) {
			driver.findElement(By.cssSelector("a[id=viewmore_link]>span[class*=viewmore_text_]")).click();
		}
		*/
		driver.findElement(By.cssSelector("a[id=viewmore_link]>span[class*=viewmore_text_]")).click();
		driver.findElement(By.cssSelector("a[id=viewmore_link]>span[class*=viewmore_text_]")).click();
		Thread.sleep(3000);
		WebElement storyAboutMeBook = driver.findElement(By.cssSelector("h4[class='post_title'] a[href*='story-about-me']"));
		storyAboutMeBook.click();
		
		//verificam linkul la care suntem
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/the-story-about-me/");
		driver.findElement(By.cssSelector(".single_add_to_cart_button")).click();
		System.out.println(driver.findElement(By.cssSelector("div[class=woocommerce-message][role=alert]")).getText());
		//assertEquals(driver.findElement(By.cssSelector("div[class=woocommerce-message][role=alert]")).getText(),"“The story about me” has been added to your cart.");
		String expectedText = driver.findElement(By.cssSelector("div[class=woocommerce-message][role=alert]")).getText();
		String actualText = "“The story about me” has been added to your cart.";
		assertTrue(expectedText.contains(actualText));
		
		//dam click pe view cart
		driver.findElement(By.cssSelector("a[href*=cart][tabindex=\"1\"]")).click();
		Thread.sleep(1000);
		//verificam linkul la care suntem
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/cart/");
	}
	
		@Test(priority=2)
		public void changeQuantity() throws InterruptedException {
			
			driver.findElement(By.cssSelector("span[class=q_inc]")).click();
			driver.findElement(By.cssSelector("button[name=update_cart]")).click();
			System.out.println(driver.findElement(By.cssSelector("div[class=woocommerce-message][role=alert]")).getText());
			assertEquals(driver.findElement(By.cssSelector("div[class=woocommerce-message][role=alert]")).getText(), "Cart updated.");

			Thread.sleep(3000);
			WebElement proceedToCheckout = driver.findElement(By.cssSelector("div[class='wc-proceed-to-checkout']"));
			proceedToCheckout.click();

			
			
			assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/checkout/");
			System.out.println(driver.findElement(By.cssSelector("div[class=col-1] h3")).getText());
			assertEquals(driver.findElement(By.cssSelector("div[class=col-1] h3")).getText(), "Billing details");
			System.out.println(driver.findElement(By.cssSelector("div[class=col-2] h3")).getText());
			assertEquals(driver.findElement(By.cssSelector("div[class=col-2] h3")).getText(), "Additional information");
			
		}
		

		
	}

