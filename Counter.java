import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;
/**
 * The counter class represents the score counter for stars collected in the game
 * 
 * @author (Saharsh) 
 * 
 */
public class Counter extends Actor
{

    // This is the current score at the beginning of the game
    int score = 0;
     
    // Main method, it will update the score on the score counter 
    // It refreshes the score display and responds to keyboard input for horizontal movement to create a scrolling effect
    public void act()
    {
        setImage(new GreenfootImage("Score: " + score, 24 , Color.WHITE, Color.BLUE));

        // Move the counter left or right based on keyboard input
        if(Greenfoot.isKeyDown("right"))
        {
            move(3);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            move(-3);
        }
        
    }

    // Increases the score by one 
    public void addScore(){
        score++;
    }

    // Gets the current score 
    public int getScore(){
        return score;
    }
    
}
