import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Astronaut class represents the player's character in the game.
 * It handles movement, collision detection with meteors and stars,
 * and implements actions related to the game's objectives.
 * 
 * @author (Saharsh) 
 * 
 */
public class Astronaut extends Actor
{
    // Track collisions with meteor and star 
    boolean touchingMeteor = false;
    boolean touchingStar = false;
    boolean TenStarsCollected = false;

    // Variables for movement and gravity 
    private int speed = 7;
    private int vSpeed = 0;
    private int gravity = 2;
    
    // Time an astronout has to move away from metor before health reduces again
    private final int COLLISION_TIMEOUT = 100;
    public int collisionTimer = 0;

    // Reference to my world 
    private MyWorld myworld;
  
    

    // Constuctor for the astronaut class 
    public Astronaut(MyWorld myworld) {
        this.myworld = myworld;
    }



    /**
     * The main act method, called during every frame update.
     * It handles movement, collision detection, and game objectives.
     */
    public void act() {
        move();
        fall();
        hitMeteor();
        hitStar();
        Mission2();
         
        // Checking if the astronaut is on the floor and ending game if they are 
        if (onGround()) {
          Greenfoot.setWorld(new GameOver());
                Greenfoot.stop();
        }
    }

  
/**
     * Checks if the astronaut is on the ground.
     * 
     * @return True if the astronaut is on the ground, false otherwise.
     */
    public boolean onGround() {
        Actor under = getOneObjectAtOffset(0, getImage().getHeight() / 16, Ground.class);
        return under != null;
        
           }
    // Handles user input for movement 
  public void move()
    {
        
    {
        if(Greenfoot.isKeyDown("down"))
        {
            setRotation(90);
            move(2);
            setRotation(0);
        }
        
        if(Greenfoot.isKeyDown("up"))
        {
            setRotation(270);
            move(4);
            setRotation(0);
        }
        
        if(Greenfoot.isKeyDown("right"))
        {
            move(3);
        }
        
        if(Greenfoot.isKeyDown("left"))
        {
            setRotation(180);
            move(3);
            setRotation(0);
        }
    }
}

    
// Handles collisions with meteors and then changes the health 
 public void hitMeteor() {
   
    
    Actor meteor = getOneIntersectingObject(Meteor.class);
    
    
    // Astronaut is overlapping with a meteor
    if (meteor != null) {
        if (this.collisionTimer == 0) {
            // decrease health on the world healthbar
            myworld.healthbar.loseHealth();
        // End game if health reaches zero 
            if (myworld.healthbar.getHealth() <= 0) {
                
                Greenfoot.setWorld(new GameOver());
                Greenfoot.stop();
                  
            }
            // reset timer
            this.collisionTimer = COLLISION_TIMEOUT;
        } else {
            // decrease timer by 1
            this.collisionTimer = this.collisionTimer - 1;
        }
    } else {

        // Reset collision timer if no collision 
        this.collisionTimer = COLLISION_TIMEOUT;
    }
      


     /**
     * Handles collision with stars and updates the score.
     * Also triggers additional actions when certain conditions are met.
     */
}
public void hitStar() {
   
    Actor star = getOneIntersectingObject(Star.class);
    // check if astronaut is overlapping with a star
    if (star != null) {

        //Increase score on the world counter 
        
            // decrease health on the world healthbar
            myworld.counter.addScore();
        // Remove collected star 
        getWorld().removeObject(star);

        // Check if 10 stars are collected to proceed to the next level 
        if(myworld.counter.getScore()>=10 && TenStarsCollected==false)
        {
            getWorld().addObject(new Rocket(), 2936, 366);
            TenStarsCollected = true;
        }
    }
    }
  
    
    /**
     * Checks for collision with a rocket, triggering a world transition.
     */         
     public void Mission2(){
         Actor rocket = getOneIntersectingObject(Rocket.class);
    
    if (rocket != null) {
        
        Greenfoot.setWorld(new Mission2());
        
     }
       
    }

    /**
     * Handles the falling of the astronaut due to gravity.
     */
public void fall(){
    
        setLocation (getX(),getY()+ vSpeed);
            vSpeed = gravity;
            
    
    
        }}


    
