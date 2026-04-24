/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: A Junit test that runs multiple different tests cases to confirm 
 * the Alcohol class is functioning properly.
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

public class AlcoholTestStudent {

		//Declare Alcohol objects to be used.
		Alcohol alcohol1 , alcohol2 ,alcohol3,alcohol4;
		
		//This method runs before each test case to initialize test objects.
		@Before
		public void setUp() throws Exception {
			alcohol1 = new  Alcohol ("Whiskey", Size.MEDIUM, false );
			alcohol2 = new  Alcohol ("Vodka", Size.SMALL, false );
			alcohol3 = new  Alcohol ("Gin", Size.SMALL, true );
			alcohol4 = new  Alcohol ("Scotch", Size.LARGE, true );
			
		}
		
		//This method runs after each test to clean up objects.
		@After
		public void tearDown() throws Exception {
			alcohol1=alcohol2=alcohol3=alcohol4=null;
		}
		
		//Test to verify that the base price for all Alcohol objects is correct.
		@Test
		public void testGetBasePrice()
		{
			assertEquals(2,alcohol1.getBasePrice(), .01);
			assertEquals(2,alcohol2.getBasePrice(), .01);
			assertEquals(2,alcohol3.getBasePrice(), .01);
			assertEquals(2,alcohol4.getBasePrice(), .01);
		}
		
		//Test to verify that the calculated price includes size and weekend adjustments.
		@Test
		public void testCalPrice() {
			
			assertEquals(3,alcohol1.calcPrice(), .01 );
			assertEquals(2,alcohol2.calcPrice(), .01 );
			assertEquals(2.6,alcohol3.calcPrice(), .01 );
			assertEquals(4.6,alcohol4.calcPrice(), .01 );
		}
		
		//Test to verify that the string representation contains key information.
		@Test
		public void testToString() {
			
			assertTrue(alcohol1.toString().contains(alcohol1.getBevName()));
			assertTrue(alcohol1.toString().contains(String.valueOf(alcohol1.calcPrice()) ));
			assertTrue(alcohol1.toString().contains(alcohol1.getSize().toString() ));
		 
		 
		}
		

	}
