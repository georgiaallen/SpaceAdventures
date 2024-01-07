import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Meteor class represents a meteor object in the world which acts as an obstacle to the playable characters.
 * Playable characters must avoid meteors in order to retain health.
 * 
 * 
 * 
 * Author: Libby 
 */
public class Meteor extends Actor
{
    
    public void act()
    {
        // Repositions meteors when they reach the edge of the screen to create a scrolling effect on the gameplay as the charcters move in the game.
        
        // Check if the right arrow key is pressed
        if(Greenfoot.isKeyDown("right"))
        {
            // Move the meteor to the left 
            move(-4);
        }
        
        // Check if the left arrow key is pressed
        if(Greenfoot.isKeyDown("left"))
        {
            // Move the meteor to the right
            move(4);
        }
        
        // Check if the meteor has reached the left edge of the world
        if (getX() == 0)
        {
            // Reposition meteor on screen in random formation as it reaches edge of world
            setLocation(getWorld().getWidth() - 1, Greenfoot.getRandomNumber(365) + 100);
        }
    }
}
    

