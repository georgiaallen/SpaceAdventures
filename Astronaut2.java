import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Astronaut2 class represents the player's character in the second level of the game.
 * It handles movement, collision detection with meteors and stars,
 * and implements actions related to the game's objectives for the second level.
 * 
 * @author (Saharsh) 
 * 
 */
public class Astronaut2 extends Actor
{
   
    // Tracks collisions with meteors and stars 
    boolean touchingMeteor = false;
    boolean touchingStar = false;
    boolean FifteenStarsCollected = false;
    
    // Varibales for movement and gravity
    private int speed = 7;
    private int vSpeed = 0;
    private int gravity = 2;
    
    // time an astronout has to move away from metor before health reduces again
    private final int COLLISION_TIMEOUT = 100;
    public int collisionTimer = 0;
    
    private MyWorld2 myworld2;
  
    
    
    // Constructor for the Astronaut2 class 
    public Astronaut2(MyWorld2 myworld2) {
        this.myworld2 = myworld2;
    }




    // The main method 
    // Handles movement, collision, and the game objectives bro
    public void act() {
        move();
        fall();
        hitMeteor();
        hitStar();
        YouWin();
         
        // Check if the astronaut is on the ground and if on the ground end the game and transfer to the game over screen
        if (onGround()) {
          Greenfoot.setWorld(new GameOver());
                Greenfoot.stop();
        }
    }

  

    /*
    * Checks if the astronuat on the ground 
    * Return True if the astronaut if on the ground otherwise will be false
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

    
// Handles collison with meteors and then changes health accordingly 
 public void hitMeteor() {
    //healthBar healthbar2 = myworld.getheHealthBar();
    //healthbar2.loseHealth();
    
    Actor meteor = getOneIntersectingObject(Meteor.class);
    
    
    // astronaut is overlapping with a meteor
    if (meteor != null) {
        if (this.collisionTimer == 0) {
            // decrease health on the world healthbar
            myworld2.healthbar.loseHealth();
        
            if (myworld2.healthbar.getHealth() <= 0) {
                
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
        this.collisionTimer = COLLISION_TIMEOUT;
    }
      
    
   
}

// Handles collison with stars     
public void hitStar() {
    //healthBar healthbar2 = myworld.getheHealthBar();
    //healthbar2.loseHealth();
    
    Actor star = getOneIntersectingObject(Star.class);
    
    // astronaut is overlapping with a meteor
    if (star != null) {
        
            // decrease health on the world healthbar
            myworld2.counter.addScore();
        // Remove collected star 
        getWorld().removeObject(star);
      
      // Checks if the astronaut has collected 15 stars this will allow for the next action to happen 
        if(myworld2.counter.getScore()>=15 && FifteenStarsCollected==false)
        {
            getWorld().addObject(new Rocket2(), 2936, 366);
            FifteenStarsCollected = true;
        }
    }
    }
 
    // Cheks for collison with a rocket, triggering a world transformation(YouWin screen) 
    public void YouWin(){
         Actor rocket2 = getOneIntersectingObject(Rocket2.class);
    
    if (rocket2 != null) {
        
        Greenfoot.setWorld(new YouWin());
        
     }
       
    }

    // Handles the falling off the astronaut due to gravity. 
     public void fall(){
    
        setLocation (getX(),getY()+ vSpeed);
            vSpeed = gravity;
            
    
    
        }}
