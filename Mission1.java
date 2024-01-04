import greenfoot.*;  

/**
 * Mission 1 notes with both players objectives for the mission
 * 
 * @author (Georgia) 
 * 
 */
public class Mission1 extends World
{
    public Mission1()
    {    
        super(3000, 700, 1);//screen size
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("space")){
        Greenfoot.setWorld(new MyWorld());//when player presses space this will move screen to MyWorld so Mission 1 gameplay can commence
    }
    }
}
