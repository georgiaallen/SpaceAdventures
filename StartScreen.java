import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * StartScreen class represents the introductory screen with control instructions for both players.
 * This screen provides a transition to the main mission.
 * @author (Georgia) 
 */
public class StartScreen extends World
{
    /**
     * Constructor for the StartScreen class.
     * Sets the size of the world.
     */
    public StartScreen()
    {    
        super(3000, 700, 1);  // Set the world size
    }
    
    /**
     * 
     * Checks if the "enter" key is pressed.
     * If the "enter" key is pressed, it transitions to Mission 1
     */
    public void act(){
        if(Greenfoot.isKeyDown("enter")){
            Greenfoot.setWorld(new Mission1());  // Move to Mission1 when the player presses the "enter" key
        }
    }
}
