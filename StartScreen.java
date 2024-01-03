import greenfoot.*;  

/**
 * Intro screen with control instructions for both players
 * @author (Georgia) 
 * 
 */
public class StartScreen extends World
{
    public StartScreen()
    {    
        super(3000, 700, 1);//screen size
        
        
    }
    public void prepare(){
        Introduction introduction = new Introduction();
        addObject(introduction,0,0);//intro screen using introduction class
        
    }
    public void act(){
        if(Greenfoot.isKeyDown("enter")){
        Greenfoot.setWorld(new Mission1());//when player presses enter this will move screen to Mission 1 player objectives and notes 
    }
}
}
