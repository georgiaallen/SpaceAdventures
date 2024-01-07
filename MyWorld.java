import greenfoot.*;  //(World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class for Mission 1 gameplay
 * 
 * Author: Libby
 */
public class MyWorld extends World {
    public healthBar healthbar; //healthabar institiated here so can be referenced in astronaut class
    public healthBar2 healthbar2;//healthabar2 institiated here so can be referenced in astronaut2 class
    public Counter counter;//counter institiated here so can be referenced in astronaut class

    public MyWorld() {    
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
        for (int i = 0; i < 7; i++) {
    int randomX = Greenfoot.getRandomNumber(getWidth());
    int randomY = Greenfoot.getRandomNumber(getHeight());
    addObject(new Meteor(), randomX, randomY);
}} //population of meteor class in random formation 

private void populate2(){
        for (int i = 0; i < 14; i++) {
    int randomX = Greenfoot.getRandomNumber(getWidth());
    int randomY = Greenfoot.getRandomNumber(getHeight());
    addObject(new Star(), randomX, randomY);
}} //population of star class in random formation

    private void prepare() {
        Astronaut astronaut = new Astronaut(this);
        addObject(astronaut, 362, 359);
        Ground ground = new Ground();
        addObject(ground, 561, 699);
        UFO ufo = new UFO(this);
        addObject(ufo, 13, 359);
        healthBar2 healthbar2 = new healthBar2();
        this.healthbar2 = healthbar2;
        addObject(healthbar2, 62, 654);
        healthBar healthbar = new healthBar(); 
        this.healthbar = healthbar;
        addObject(healthbar, 62, 48);
        Counter counter = new Counter();
        this.counter = counter;
        addObject(counter, 192, 48);
    } //population of each actor and their set location in MyWorld

    
}
