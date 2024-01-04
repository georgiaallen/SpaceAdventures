import greenfoot.*;  // // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;  // Import Color class from Greenfoot

/**
 * Represents a health bar for astronaut & astronaut2 in the Mission 1 & 2.
 * 
 * Author: (Georgia)
 * 
 */
public class healthBar extends Actor 
{
    // Instance variables
    private int health = 5;  // Set health for astronaut & astronaut2
    int healthBarWidth = 100;  // Width of the health bar
    int healthBarHeight = 17;  // Height of the health bar
    int pixelsPerHealth = (int)healthBarWidth/health;  // Pixels per health point

    /**
     * Constructor for the healthBar class.
     * Initializes health to 5 and calls the update method.
     */
    public healthBar(){
        health = 5;  
        update();  
    }

    /**
     * Act method - called whenever the 'Act' or 'Run' button gets pressed in the environment.
     * Updates the health bar and checks for keyboard input to move the object.
     */
    public void act()
    {
        update();  // Refresh the appearance of the health bar
        if(Greenfoot.isKeyDown("right"))
        {
            move(3);  // Move the object to the right
        }
        if(Greenfoot.isKeyDown("left"))
        {
            move(-3);  // Move the object to the left
        }
    }

    /**
     * Updates the appearance of the health bar.
     * Draws a white rectangle around the health bar and fills it with a red color.
     */
    public void update(){
        setImage(new GreenfootImage(healthBarWidth + 2, healthBarHeight + 2));  // Set image size
        GreenfootImage myImage = getImage();  // Get the image of the actor
        myImage.setColor(Color.WHITE);  // Set color to white
        myImage.drawRect(0, 0, healthBarWidth + 1, healthBarHeight + 1);  // Draw a white rectangle
        myImage.setColor(Color.RED);  // Set color to red
        myImage.fillRect(1, 1, health * pixelsPerHealth, healthBarHeight);  // Fill the health bar with red based on current health
    }

    /**
     * Decreases the health of the actor by one.
     */
    public void loseHealth() {
        health--;  // Decrease health
    }

    /**
     * Returns the current health of the actor.
     */
    public int getHealth() {
        return health;  // Return the current health
    }
}
