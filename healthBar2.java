import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class healthBar2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class healthBar2 extends Actor
{
    /**
     * Act - do whatever the healthBar2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int health = 5;
    int healthBarWidth = 100;
    int healthBarHeight = 17;
   int pixelsPerHealth = (int)healthBarWidth/health;

    public healthBar2(){
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
        myImage.setColor(Color.BLUE);
        myImage.fillRect(1,1, health*pixelsPerHealth,healthBarHeight);
    }
    
    

    public void loseHealth() {
        health --; 
    }

    public int getHealth() {
        return health;
    }
    
}
