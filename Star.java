import greenfoot.*;  // Import necessary Greenfoot classes

/**
 * Star class represents a star in the Greenfoot scenario.
 * This class extends the Actor class, which is the base class for all actors in Greenfoot.
 * It means that objects of the Star class can be added to the world and will be displayed.
 * 
 * @author Libby
 */
public class Star extends Actor
{
    /**
     * Act - do whatever the Star wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Check if the right arrow key is pressed
        if(Greenfoot.isKeyDown("right"))
        {
            // Move the star to the left (negative x direction)
            move(-4);
        }
        
        // Check if the left arrow key is pressed
        if(Greenfoot.isKeyDown("left"))
        {
            // Move the star to the right (positive x direction)
            move(4);
        }
        
        // Check if the star has reached the left edge of the world
        if (getX() == 0)
        {
            // Wrap around to the right edge and reposition vertically with a random Y-coordinate
            setLocation(getWorld().getWidth() - 1, Greenfoot.getRandomNumber(600) + 100);
        }
    }
}
