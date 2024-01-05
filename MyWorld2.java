import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class for Mission 2 gameplay
 * 
 * Author: Libby
 */

public class MyWorld2 extends World
{
public healthBar healthbar; //healthabar institiated here so can be referenced in astronaut class
    public Counter counter;//counter institiated here so can be referenced in astronaut class
    public healthBar2 healthbar2;//healthabar2 institiated here so can be referenced in astronaut2 class
  
    public MyWorld2()
    {    
        super(3000, 700, 1); //screen size
        prepare();
        populate();
        populate2();
    }
    public healthBar getheHealthBar() {
        return healthbar; 
    }
    public healthBar2 gettheHealthBar(){
        return healthbar2;
    }
    public Counter getCounter(){
        return counter;
    }
private void populate(){
        for (int i = 0; i < 10; i++) {
    int randomX = Greenfoot.getRandomNumber(getWidth());
    int randomY = Greenfoot.getRandomNumber(getHeight());
    addObject(new Meteor(), randomX, randomY);
}}//population of meteor class in random formation 

private void populate2(){
        for (int i = 0; i < 17; i++) {
    int randomX = Greenfoot.getRandomNumber(getWidth());
    int randomY = Greenfoot.getRandomNumber(getHeight());
    addObject(new Star(), randomX, randomY);
}}//population of star class in random formation 
private void prepare() {
        Astronaut2 astronaut2 = new Astronaut2(this);
        addObject(astronaut2, 475, 359);
        Ground ground = new Ground();
        addObject(ground, 561, 699);
        UFO2 ufo2 = new UFO2(this);
        addObject(ufo2, 4, 359);
        healthBar2 healthbar2 = new healthBar2();
        this.healthbar2 = healthbar2;
        addObject(healthbar2, 62, 654);
        healthBar healthbar = new healthBar(); 
        this.healthbar = healthbar;
        addObject(healthbar, 62, 48);
        Counter counter = new Counter();
        this.counter = counter;
        addObject(counter, 192, 48);
    }//population of each actor and their set location in MyWorld2

    
}
