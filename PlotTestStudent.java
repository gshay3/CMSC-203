import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlotTestStudent 
{
	@Test
    void testOverlaps() 
	{
        Plot plot1 = new Plot(1, 1, 3, 3);
        Plot plot2 = new Plot(2, 2, 2, 2);

        assertTrue(plot1.overlaps(plot2));
    }

    @Test
    void testDoesNotOverlap()
    {
        Plot plot1 = new Plot(1, 1, 2, 2);
        Plot plot2 = new Plot(4, 4, 2, 2);

        assertFalse(plot1.overlaps(plot2));
    }

    @Test
    void testEncompasses()
    {
        Plot plot1 = new Plot(1, 1, 4, 4);
        Plot plot2 = new Plot(2, 2, 2, 2);

        assertTrue(plot1.encompasses(plot2));
    }

    @Test
    void testDoesNotEncompass()
    {
        Plot plot1 = new Plot(1, 1, 2, 2);
        Plot plot2 = new Plot(2, 2, 3, 3);

        assertFalse(plot1.encompasses(plot2));
    }

    @Test
    void testSetX()
    {
        Plot plot = new Plot(1, 2, 3, 4);
        plot.setX(5);

        assertEquals(5, plot.getX());
    }

    @Test
    void testSetY()
    {
        Plot plot = new Plot(1, 2, 3, 4);
        plot.setY(6);

        assertEquals(6, plot.getY());
    }

    @Test
    void testSetWidth()
    {
        Plot plot = new Plot(1, 2, 3, 4);
        plot.setWidth(7);

        assertEquals(7, plot.getWidth());
    }

    @Test
    void testSetDepth()
    {
        Plot plot = new Plot(1, 2, 3, 4);
        plot.setDepth(8);

        assertEquals(8, plot.getDepth());
    }

    @Test
    void testToString()
    {
        Plot plot = new Plot(1, 2, 3, 4);
        String expectedString = "1,2,3,4";

        assertEquals(expectedString, plot.toString());
    }
}
