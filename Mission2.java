import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Mission2 class represents the second mission in the Greenfoot scenario.
 * This class extends the World class, which is the base class for world objects in Greenfoot.
 * It means that instances of the Mission2 class define the world where the second mission takes place.
 * 
 * Mission 2 notes with both players' objectives for the mission.
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
    
    /**
     * Act method is called automatically in the Greenfoot environment.
     */
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
