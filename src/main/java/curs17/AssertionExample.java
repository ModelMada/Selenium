package curs17;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class AssertionExample {
	
	String actualTitle = "test";
	String expectedTitle = "masina";
	
	
	@Test
	public void checkTitle() {
		
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Pass");
		}else {
			System.out.println("Failed");
		}	
	}
	
	@Test
	public void checkTitle2() {
		assertEquals(actualTitle, expectedTitle);

	
	}
	

}
