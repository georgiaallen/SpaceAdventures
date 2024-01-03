import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Astronaut here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Astronaut extends Actor
{
    
    boolean touchingMeteor = false;
    boolean touchingStar = false;
    boolean TenStarsCollected = false;
    private int speed = 7;
    private int vSpeed = 0;
    private int gravity = 2;
    
    // time an astronout has to move away from metor before health reduces again
    private final int COLLISION_TIMEOUT = 100;
    public int collisionTimer = 0;
    
    private MyWorld myworld;
  
    //NOTE: not needed
    //private healthBar healthBar;
    
    public Astronaut(MyWorld myworld) {
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
        hitStar();
        Mission2();
          if (onGround()) {
          Greenfoot.setWorld(new GameOver());
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

    

 public void hitMeteor() {
    //healthBar healthbar2 = myworld.getheHealthBar();
    //healthbar2.loseHealth();
    
    Actor meteor = getOneIntersectingObject(Meteor.class);
    
    
    // astronaut is overlapping with a meteor
    if (meteor != null) {
        if (this.collisionTimer == 0) {
            // decrease health on the world healthbar
            myworld.healthbar.loseHealth();
        
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
public void hitStar() {
    //healthBar healthbar2 = myworld.getheHealthBar();
    //healthbar2.loseHealth();
    
    Actor star = getOneIntersectingObject(Star.class);
    
    // astronaut is overlapping with a meteor
    if (star != null) {
        
            // decrease health on the world healthbar
            myworld.counter.addScore();
        getWorld().removeObject(star);
        if(myworld.counter.getScore()>=10 && TenStarsCollected==false)
        {
            getWorld().addObject(new Rocket(), 2936, 366);
            TenStarsCollected = true;
        }
    }
    }
            
     public void Mission2(){
         Actor rocket = getOneIntersectingObject(Rocket.class);
    
    if (rocket != null) {
        
        Greenfoot.setWorld(new Mission2());
        
     }
       
    }
public void fall(){
    
        setLocation (getX(),getY()+ vSpeed);
            vSpeed = gravity;
            
    
    
        }}


    