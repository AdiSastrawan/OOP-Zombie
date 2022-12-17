import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean shooting;
    private int firespeed=15;
    private int delay = 0;
    private int health = 3;
    public Player(){
    }
    public void getHit(){
        health--;
    }
    public void fireUp(){
        firespeed-=3;
    }
    public int getPlayerHealth(){
        return health;
    }
    public void act()
    {
        if(health>0){
            playerMove(5);
            turnToCursor();
            shootBullet();
            delay++;    
        }else{
            Death();
        }
        
        

    }
    private void Death(){
        getWorld().removeObject(this);
    }
    private void playerMove(int speed){
        if(Greenfoot.isKeyDown("a")){
            setLocation(getX()-speed,getY());
        }
        if(Greenfoot.isKeyDown("d")){
            setLocation(getX()+speed,getY());
        }
        if(Greenfoot.isKeyDown("w")){
            setLocation(getX(),getY()-speed);
        }
        if(Greenfoot.isKeyDown("s")){
            setLocation(getX(),getY()+speed);
        }
        
    }
    private void turnToCursor(){
        if(Greenfoot.getMouseInfo()!= null){
            turnTowards(Greenfoot.getMouseInfo().getX(),Greenfoot.getMouseInfo().getY());    
        }
        
    }
    private void shootBullet(){
        if (shooting && (Greenfoot.mouseDragEnded(null) || Greenfoot.mouseClicked(null))) shooting = false;
        if (!shooting && Greenfoot.mousePressed(null)) shooting = true;
        if(shooting==true&&delay>firespeed){
            Bullet bullet = new Bullet();
            getWorld().addObject(bullet,getX(),getY()); 
            bullet.setRotation(getRotation());
            delay=0;
        }
        
    }
}
