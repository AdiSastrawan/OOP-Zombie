import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Bullet(){
        
    }
    private int damage = 1;
    private int bulletSpeed = 20;
    public void act()
    {
        move(bulletSpeed);
        hitZombie();
    }
    private void hitZombie(){
        if(isTouching(Zombie.class)){
            Zombie zombie = (Zombie)getOneIntersectingObject(Zombie.class);
            zombie.setHealth(damage);
            getWorld().removeObject(this);
        }else if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }
    
}
