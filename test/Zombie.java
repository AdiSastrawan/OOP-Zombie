import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * 
 */
public class Zombie extends Actor
{

    public int health=2;
    public void act()
    {
        
        if(health==0){
            getWorld().removeObject(this);
        }else{
            chase(3);
        }
        

    }
    private void chase(int speed){
        List players = getWorld().getObjects(Player.class);
        if(!players.isEmpty()){
           Actor player = (Actor)players.get(0);
            turnTowards(player.getX(), player.getY());
            move(speed); 
        }
        
    }
    public void setHealth(int damage){
        health=health-damage;
    }

}
