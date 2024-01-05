import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Meteor class represents a meteor in the Greenfoot scenario.
 * This class extends the Actor class, which is the base class for all actors in Greenfoot.
 * It means that objects of the Meteor class can be added to the world and will be displayed.
 * 
 * Author: Libby 
 */
public class Meteor extends Actor
{
    /**
     * Act - do whatever the Meteor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Check if the right arrow key is pressed
        if(Greenfoot.isKeyDown("right"))
        {
            // Move the meteor to the left (negative x direction)
            move(-4);
        }
        
        // Check if the left arrow key is pressed
        if(Greenfoot.isKeyDown("left"))
        {
            // Move the meteor to the right (positive x direction)
            move(4);
        }
        
        // Check if the meteor has reached the left edge of the world
        if (getX() == 0)
        {
            // Wrap around to the right edge and reposition vertically with a random Y-coordinate
            setLocation(getWorld().getWidth() - 1, Greenfoot.getRandomNumber(365) + 100);
        }
    }
}
    

