/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: A Junit test that runs multiple different tests cases to confirm 
 * the Customer class is functioning properly.
 * Due: 12/10/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Griffin Shay
*/

import static org.junit.Assert.*;
import org.junit.Test;

public class CustomerTestStudent {

	//Test getter method for age.
    @Test
    public void testGetAge() {
        Customer customer = new Customer("John", 30);
        assertEquals(30, customer.getAge());
    }

    //Test setter method for age.
    @Test
    public void testSetAge() {
        Customer customer = new Customer("Alice", 25);
        customer.setAge(35);
        assertEquals(35, customer.getAge());
    }

    //Test getter method for name.
    @Test
    public void testGetName() {
        Customer customer = new Customer("Bob", 40);
        assertEquals("Bob", customer.getName());
    }

    //Test setter method for name.
    @Test
    public void testSetName() {
        Customer customer = new Customer("Eve", 22);
        customer.setName("Charlie");
        assertEquals("Charlie", customer.getName());
    }

    //Test toString method to ensure correct format for output.
    @Test
    public void testToString() {
        Customer customer = new Customer("Dave", 28);
        assertEquals("Dave,28", customer.toString());
    }

    //Test copy constructor to ensure deep copy of values.
    @Test
    public void testCopyConstructor() {
        Customer originalCustomer = new Customer("Original", 50);
        Customer copiedCustomer = new Customer(originalCustomer);
        assertEquals(originalCustomer.getName(), copiedCustomer.getName());
        assertEquals(originalCustomer.getAge(), copiedCustomer.getAge());
    }
}