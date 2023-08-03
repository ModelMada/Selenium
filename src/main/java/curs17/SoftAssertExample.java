package curs17;

import static org.testng.Assert.*;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertExample {

	//1.SoftAssert
	//2.HardAssert
	
	@Test
	public void softAssert() {
		System.out.println("Soft assert incepe aici!");
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(false);
		System.out.println("Soft assert continua aici!");
		sa.assertEquals("unu", "altul");
		System.out.println("Soft assert se termina aici!");
		sa.assertAll();
	
	}
	
	@Test
	public void hardAssert() {
		System.out.println("Hard assert incepe aici!");
		assertTrue(false);
		System.out.println("Hard assert continua aici!");
		assertEquals("unu", "altul");
		System.out.println("Hard assert se termina aici!");
	}
	
	
	
	
	
}
