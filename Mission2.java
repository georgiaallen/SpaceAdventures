import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Mission 2 notes with both players objectives for the mission

 * 
 * @author (Georgia) 
 * 
 */
public class Mission2 extends World
{
    public Mission2()
    {    
        super(3000, 700, 1);//screen size
    }
    public void prepare(){
        Introduction introduction = new Introduction();
        addObject(introduction,0,0);//intro screen using introduction class
        
    }
    public void act(){
        if(Greenfoot.isKeyDown("enter")){
        Greenfoot.setWorld(new MyWorld2());//when player presses enter this will move screen to MyWorld2 so Mission 2 gameplay can commence
    
    }
}
}
