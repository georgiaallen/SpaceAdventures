import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UFO here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UFO extends Actor
{
    boolean touchingMeteor = false;
    
    private int speed = 7;
    private int vSpeed = 0;
    private int gravity = 2;
    
    // time an astronout has to move away from metor before health reduces again
    private final int COLLISION_TIMEOUT = 100;
    public int collisionTimer = 0;
    
    private MyWorld myworld;
  
    //NOTE: not needed
    //private healthBar healthBar;
    
    public UFO(MyWorld myworld) {
        this.myworld = myworld;
    }

//NOTE: Don't have two Astronaut() constructors
//public Astronaut(healthBar healthBar) {
//        this.healthBar = healthBar;
//    }

    public void act() {
        move();
        fall();
        hitMeteor();
        hitAstronaut();
          if (onGround()) {
          Greenfoot.setWorld(new GameOver2());
                Greenfoot.stop();
        }
    }
//NOTE: not needed, doesn't accomplish anything
//     public void setMyWorld(MyWorld world) {
//        myworld = world;  
//    }
  

    public boolean onGround() {
        Actor under = getOneObjectAtOffset(0, getImage().getHeight() / 16, Ground.class);
        return under != null;
        
           }
    
  public void move()
    {
        
    {
        if(Greenfoot.isKeyDown("s"))
        {
            setRotation(90);
            move(1);
            setRotation(0);
        }
        
        if(Greenfoot.isKeyDown("w"))
        {
            setRotation(270);
            move(3);
            setRotation(0);
        }
        
        if(Greenfoot.isKeyDown("d"))
        {
            move(2);
        }
        
        if(Greenfoot.isKeyDown("a"))
        {
            setRotation(180);
            move(2);
            setRotation(0);
        }
    }
}

    

 public void hitMeteor() {
    //healthBar healthbar2 = myworld.getheHealthBar();
    //healthbar2.loseHealth();
    
    Actor meteor = getOneIntersectingObject(Meteor.class);
    
    
    // astronaut is overlapping with a meteor
    if (meteor != null) {
        if (this.collisionTimer == 0) {
            // decrease health on the world healthbar
            myworld.healthbar2.loseHealth();
        
            if (myworld.healthbar2.getHealth() <= 0) {
                
                Greenfoot.setWorld(new GameOver2());
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
      
    
    /*
    if (!touchingMeteor) {
        if (healthBar != null) {
            myworld.healthbar.loseHealth();
        
            touchingMeteor = true;
            if (healthbar2.getHealth() <= 0) {
                System.out.println("Game Over!");
                Greenfoot.stop();
            }
        }
    } else {
        touchingMeteor = false;
    }
    */
}
public void hitAstronaut(){
    Actor astronaut = getOneIntersectingObject(Astronaut.class);
        if (astronaut != null) {
        
        Greenfoot.setWorld(new YouWin2());
        Greenfoot.stop();
     }
    }

            

public void fall(){
    
        setLocation (getX(),getY()+ vSpeed);
            vSpeed = gravity;
            
    
    
        }}


    