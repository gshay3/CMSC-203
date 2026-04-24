/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: A Junit test that runs multiple different tests cases to confirm 
 * the Coffee class is functioning properly.
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

public class CoffeeTestStudent {

	//Coffee objects used for testing different scenarios.
	Coffee coffee1,coffee2,coffee3,coffee4;
	
	//Runs before each test to initialize test data.
	@Before
	public void setUp() throws Exception {
		coffee1 = new  Coffee ("Alexa", Size.SMALL, false,false );
		coffee2 = new  Coffee ("namec2", Size.SMALL, true,true );
		coffee3 = new  Coffee ("Namec3", Size.MEDIUM, false, true );
		coffee4 = new  Coffee ("Cf4NAme", Size.LARGE, true, false );
		
	}
	
	//Runs after each test to clean up objects.
	@After
	public void tearDown() throws Exception {
		coffee1=coffee2=coffee3=coffee4=null;
	}
	
	//Test to verify base price is consistent for all coffee objects.
	@Test
	public void testGetBasePrice()
	{
		assertEquals(2,coffee1.getBasePrice(), .01);
		assertEquals(2,coffee2.getBasePrice(), .01);
		assertEquals(2,coffee3.getBasePrice(), .01);
		assertEquals(2,coffee4.getBasePrice(), .01);
	}
	
	//Test to verify price calculation including size, shot, and syrup.
	@Test
	public void testCalPrice() {
		
		assertEquals(2,coffee1.calcPrice(), .01 );
		assertEquals(3,coffee2.calcPrice(), .01 );
		assertEquals(3.5,coffee3.calcPrice(), .01 );
		assertEquals(4.5,coffee4.calcPrice(), .01 );
		 
	}
	
	//Test to verify toString contains key coffee information.
	@Test
	public void testToString() {
		
		assertTrue(coffee1.toString().contains(coffee1.getBevName()));
		assertTrue(coffee1.toString().contains(String.valueOf(coffee1.calcPrice()) ));
		assertTrue(coffee1.toString().contains(coffee1.getSize().toString() ));
	 
	 
	}
}