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
    private int amountZombie = 20;
    private int currZombie = amountZombie;
    private int spawnZombie = 0;
    private int powerUp;
    Player player = new Player();
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        addObject(player, getWidth()/2,getHeight()/2);
       
        
    }
    public void act(){
        showText("Remaining Zombie : "+currZombie,3,8);
        showText("Health : " + player.getPlayerHealth(),300,8);
        time++;
        if(spawnZombie<amountZombie){
            powerUp = Greenfoot.getRandomNumber(30000);
            if(powerUp<(1+amountZombie)){
                generatePowerUp();
            }
            if(time>150){
            generateZombie();
            time=0;
            }
        }
        
        
    }
    private void generatePowerUp(){
        PowerUp pow = new PowerUp();
        addObject(pow, Greenfoot.getRandomNumber(getWidth()-10)+10,Greenfoot.getRandomNumber(getHeight()-10)+10);
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
        spawnZombie++;
        
    }
    public void killedZombie(){
        this.currZombie--;
    }
}
