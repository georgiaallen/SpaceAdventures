import greenfoot.*;  

/**
 * StartScreen class represents the introductory screen with control instructions for both players.
 * This screen provides a transition to the main gameplay or mission.
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
     * Prepare method adds the Introduction object to the world.
     * The Introduction object likely contains text or graphics for the intro screen.
     */
    public void prepare(){
        Introduction introduction = new Introduction();
        addObject(introduction, 0, 0);  // Add the Introduction object to the world at coordinates (0,0)
    }

    /**
     * Act method - executed continuously during the game.
     * Checks if the "enter" key is pressed.
     * If the "enter" key is pressed, it transitions to Mission1, moving to the next screen or level.
     */
    public void act(){
        if(Greenfoot.isKeyDown("enter")){
            Greenfoot.setWorld(new Mission1());  // Move to Mission1 when the player presses the "enter" key
        }
    }
}
