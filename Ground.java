import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The ground class represents the ground in game 
 * It inherits the actor class and is responsible for actions related to the ground such as when a actor touches the ground
 * @author (Saharsh) 
 * 
 */
public class Ground extends Actor{
 
   // The main method, it handles keyboard input for movement
 // This allows the ground to move along the screen as the player moves
    public void act(){
         if(Greenfoot.isKeyDown("right"))
        {
            move(3);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            move(-3);
        }
    }}
    
    
    
    

