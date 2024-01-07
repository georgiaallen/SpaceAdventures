import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Mission2 class represents the second mission in the Greenfoot scenario.
 * Mission 2 notes are included here with both players' objectives for the mission.
 * 
 * Author: Libby
 */
public class Mission2 extends World
{
    /**
     * Constructor for objects of class Mission2.
     */
    public Mission2()
    {    
        super(3000, 700, 1); // Screen size of the world
    }
    
   
    public void act()
    {
        // Check if the "enter" key is pressed
        if(Greenfoot.isKeyDown("enter"))
        {
            // When the player presses enter, switch to MyWorld2 for Mission 2 gameplay
            Greenfoot.setWorld(new MyWorld2());
        }
    }
}
