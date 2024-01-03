import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;
/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    int score = 0;
     

    public void act()
    {
        setImage(new GreenfootImage("Score: " + score, 24 , Color.WHITE, Color.BLUE));
 if(Greenfoot.isKeyDown("right"))
        {
            move(3);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            move(-3);
        }
        
    }
    public void addScore(){
        score++;
    }
    public int getScore(){
        return score;
    }
    
}
