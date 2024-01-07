import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Star class represents a star in the Greenfoot scenario.
 * When the astronaut collects a star object it increases the score counter by 1 
 * 
 * Author: Libby
 */
public class Star extends Actor
{
    
    public void act()
    {
        // Check if the right arrow key is pressed
        if(Greenfoot.isKeyDown("right"))
        {
            // Move the star to the left 
            move(-4);
        }
        
        // Check if the left arrow key is pressed
        if(Greenfoot.isKeyDown("left"))
        {
            // Move the star to the right 
            move(4);
        }
        
        // Check if the star has reached the left edge of the world
        if (getX() == 0)
        {
            // 
            setLocation(getWorld().getWidth() - 1, Greenfoot.getRandomNumber(600) + 100);
        }
    }
}
