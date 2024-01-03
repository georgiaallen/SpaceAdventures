import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;
/**
 * Write a description of class healthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date) 
 */
public class healthBar extends Actor 
{
     private int health = 5;
    int healthBarWidth = 100;
    int healthBarHeight = 17;
   int pixelsPerHealth = (int)healthBarWidth/health;
    

    public healthBar(){
    health = 5;
     
    update();
}
    public void act()
    {
        update();
         if(Greenfoot.isKeyDown("right"))
        {
            move(3);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            move(-3);
        }
    }


    public void update(){
        setImage(new GreenfootImage(healthBarWidth + 2, healthBarHeight + 2));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.WHITE);
        myImage.drawRect(0,0,healthBarWidth + 1, healthBarHeight + 1);
        myImage.setColor(Color.RED);
        myImage.fillRect(1,1, health*pixelsPerHealth,healthBarHeight);
    }
    
    

    public void loseHealth() {
        health --; 
    }

    public int getHealth() {
        return health;
    }
    
}
