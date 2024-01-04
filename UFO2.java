import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * UFO2 class represents the UFO in Mission 2.
 * 
 * @author (Georgia) 
 * 
 */
public class UFO2 extends Actor
{
    // Check if UFO2 is currently colliding with a meteor
    boolean touchingMeteor = false;
    
    // Variables for UFO2 movement and gravity
    private int speed = 7;
    private int vSpeed = 0;
    private int gravity = 2;
    
    // Time UFO2 has to move away from the meteor before health reduces again
    private final int COLLISION_TIMEOUT = 100;
    public int collisionTimer = 0;
    
    // Reference to MyWorld2 where UFO2 exists
    private MyWorld2 myworld2;

    /**
     * Constructor for UFO2 class.
     * The world in which UFO2 exists.
     */
    public UFO2(MyWorld2 myworld2) {
        this.myworld2 = myworld2;
    }

    /**
     
     */
    public void act() {
        move();
        fall();
        hitMeteor();
        hitAstronaut2();
        
        // Check if UFO2 has hit the ground
        if (onGround()) {
            Greenfoot.setWorld(new GameOver2());
            Greenfoot.stop();
        }
    }

    /**
     * Check if UFO2 is on the ground.
     * 
     */
    public boolean onGround() {
        Actor under = getOneObjectAtOffset(0, getImage().getHeight() / 16, Ground.class);
        return under != null;
    }
    
    /**
     * Move UFO2 based on user input - W, A, S, D
     */
    public void move() {
        if(Greenfoot.isKeyDown("s")) {
            setRotation(90);
            move(1);
            setRotation(0);
        }
        
        if(Greenfoot.isKeyDown("w")) {
            setRotation(270);
            move(3);
            setRotation(0);
        }
        
        if(Greenfoot.isKeyDown("d")) {
            move(2);
        }
        
        if(Greenfoot.isKeyDown("a")) {
            setRotation(180);
            move(2);
            setRotation(0);
        }
    }

    /**
     * Check for collision with meteors and handle health reduction.
     */
    public void hitMeteor() {
        Actor meteor = getOneIntersectingObject(Meteor.class);
        
        // Check if UFO2 is overlapping with a meteor
        if (meteor != null) {
            if (this.collisionTimer == 0) {
                // Decrease health on healthbar2
                myworld2.healthbar2.loseHealth();
                
                if (myworld2.healthbar2.getHealth() <= 0) {
                    // Game over if health reaches zero
                    Greenfoot.setWorld(new GameOver2());
                    Greenfoot.stop();
                }
                
                // Reset collision timer
                this.collisionTimer = COLLISION_TIMEOUT;
            } else {
                // Decrease timer by 1
                this.collisionTimer = this.collisionTimer - 1;
            }
        } else {
            this.collisionTimer = COLLISION_TIMEOUT;
        }
    }

    /**
     * Check for collision with astronaut and trigger a win screen.
     */
    public void hitAstronaut2() {
        Actor astronaut2 = getOneIntersectingObject(Astronaut2.class);
        if (astronaut2 != null) {
            // You win if the UFO collides with an astronaut
            Greenfoot.setWorld(new YouWin2());
            Greenfoot.stop();
        }
    }

    /**
     * Create gravity effect by making the UFO fall.
     */
    public void fall() {
        setLocation(getX(), getY() + vSpeed);
        vSpeed = gravity;
    }
}
    
    
        }}

