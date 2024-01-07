import greenfoot.*;  

/**
 * This is the first mission screen in the game and it shows players their objectives based on the player they have selected
 * Also allows upon pressing the space bar for players to proceed into mission one gameplay 
 * @author (Saharsh) 
 * 
 */
public class Mission1 extends World
{
    // Constuctor for mission one 
    public Mission1()
    {    
        super(3000, 700, 1);//screen size
    }
    // The main method, checks if the space bar is pressed to transition to myWorld
    public void act(){
        if(Greenfoot.isKeyDown("space")){
    //when player presses space this will move screen to MyWorld so Mission 1 gameplay can commence
        Greenfoot.setWorld(new MyWorld());
            
    }
    }
}
