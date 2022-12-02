import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    int time=0;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        Player player = new Player();
        addObject(player, getWidth()/2,getHeight()/2);
        Zombie zombie = new Zombie();
        addObject(zombie, Greenfoot.getRandomNumber(getHeight()),getWidth());
        
    }
    public void act(){
        time++;
        if(time>180){
            generateZombie();
            time=0;
        }
        
    }
    private void generateZombie(){
        Zombie zombie = new Zombie();
        int pos = Greenfoot.getRandomNumber(3);
        if(pos==0){
            addObject(zombie, getWidth(),getHeight());
        }else if(pos==1){
            addObject(zombie,getWidth()*0, getHeight()*0);
        }else if(pos==2){
            addObject(zombie,getWidth(), getHeight()*0);
        }else{
            addObject(zombie,getWidth()*0, getHeight());
        }
        
    }
}
