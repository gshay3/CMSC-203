import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PropertyTestStudent 
{
	@Test
    void testGetPlot() 
	{
        Property property = new Property("Sunsational", "Beckman", 2613.0, "BillyBob Wilson", 2, 5, 2, 2);
        Plot plot = property.getPlot();
        
        assertEquals(2, plot.getX());
        assertEquals(5, plot.getY());
        assertEquals(2, plot.getWidth());
        assertEquals(2, plot.getDepth());
    }

    @Test
    void testGetPropertyName() 
    {
        Property property = new Property("Sunsational", "Beckman", 2613.0, "BillyBob Wilson");
        assertEquals("Sunsational", property.getPropertyName());
    }

    @Test
    void testGetCity() 
    {
        Property property = new Property("Sunsational", "Beckman", 2613.0, "BillyBob Wilson");
        assertEquals("Beckman", property.getCity());
    }

    @Test
    void testGetRentAmount() 
    {
        Property property = new Property("Sunsational", "Beckman", 2613.0, "BillyBob Wilson");
        assertEquals(2613.0, property.getRentAmount(), 0.001);
    }

    @Test
    void testGetOwner()
    {
        Property property = new Property("Sunsational", "Beckman", 2613.0, "BillyBob Wilson");
        assertEquals("BillyBob Wilson", property.getOwner());
    }

    @Test
    void testToString()
    {
        Property property = new Property("Sunsational", "Beckman", 2613.0, "BillyBob Wilson");
        String expectedString = "Sunsational,Beckman,BillyBob Wilson,2613.0";
        assertEquals(expectedString, property.toString());
    }
}