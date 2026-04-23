/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: A class that builds the plot object and tests whether it overlaps or is encompassed by another plot.
 * Due: 11/04/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Griffin Shay
*/

public class Plot
{
    private int x;
    private int y;
    private int width;
    private int depth;

    // Constructors
    public Plot()
    {
        this(0, 0, 1, 1);
    }

    public Plot(int x, int y, int width, int depth)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    public Plot(Plot otherPlot)
    {
        this(otherPlot.getX(), otherPlot.getY(), otherPlot.getWidth(), otherPlot.getDepth());
    }

    // Methods
    public boolean overlaps(Plot plot)
    {
        int thisX2 = this.x + this.width;
        int thisY2 = this.y + this.depth;
        int plotX2 = plot.x + plot.width;
        int plotY2 = plot.y + plot.depth;
        
        if(this.x < plotX2 && thisX2 > plot.x && this.y < plotY2 && thisY2 > plot.y)
        {
        	return true;
        }
        else
        {
        	return false;
        }
    }

    public boolean encompasses(Plot plot)
    {
        int thisX2 = this.x + this.width;
        int thisY2 = this.y + this.depth;
        int plotX2 = plot.x + plot.width;
        int plotY2 = plot.y + plot.depth;
        
        if(this.x <= plot.x && this.y <= plot.y && thisX2 >= plotX2 && thisY2 >= plotY2)
        {
        	return true;
        }
        else
        {
        	return false;
        }
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public void setDepth(int depth)
    {
        this.depth = depth;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getWidth()
    {
        return width;
    }

    public int getDepth()
    {
        return depth;
    }

    public String toString()
    {
        return x + "," + y + "," + width + "," + depth;
    }
}