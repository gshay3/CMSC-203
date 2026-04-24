/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: A Junit test that runs multiple different tests cases to confirm 
 * the Smoothie class is functioning properly.
 * Due: 12/10/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Griffin Shay
*/

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SmoothieTestStudent {

	// Smoothie objects used for testing different scenarios.
	Smoothie smoothie1,smoothie2,smoothie3,smoothie4;
	
	// Runs before each test to initialize test data.
	@Before
	public void setUp() throws Exception {
		smoothie1 = new  Smoothie ("s1Name", Size.SMALL, 1,false );
		smoothie2 = new  Smoothie ("s2NAme", Size.MEDIUM, 2,true );
		smoothie3 = new  Smoothie ("s3NAme", Size.MEDIUM, 3, false );
		smoothie4 = new  Smoothie ("s4NAme", Size.LARGE, 5, true );
		
	}

	// Runs after each test to clean up objects.
	@After
	public void tearDown() throws Exception {
		smoothie1=smoothie2=smoothie3=smoothie4=null;
	}
	
	// Test to verify base price is consistent for all smoothies.
	@Test
	public void testGetBasePrice()
	{
		assertEquals(2,smoothie1.getBasePrice(), .01);
		assertEquals(2,smoothie2.getBasePrice(), .01);
		assertEquals(2,smoothie3.getBasePrice(), .01);
		assertEquals(2,smoothie4.getBasePrice(), .01);
	}
 
	// Test to verify correct price calculations based on size, fruit, and protein.
	@Test
	public void testCalPrice() {
		
		assertEquals(2.5,smoothie1.calcPrice(), .01 );
		assertEquals(5.5,smoothie2.calcPrice(), .01 );
		assertEquals(4.5,smoothie3.calcPrice(), .01 );
		assertEquals(8,smoothie4.calcPrice(), .01 );
		 
	}
	
	// Test to verify toString contains all required smoothie information.
	@Test
	public void testToString() {
		
		assertTrue(smoothie1.toString().contains(smoothie1.getBevName()));
		assertTrue(smoothie1.toString().contains(String.valueOf(smoothie1.calcPrice()) ));
		assertTrue(smoothie1.toString().contains(smoothie1.getSize().toString() ));
		assertTrue(smoothie1.toString().contains( String.valueOf(smoothie1.getNumOfFruits()) ));
  
	}
}