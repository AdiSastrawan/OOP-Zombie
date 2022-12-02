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
    int firespeed=0;
    public Player(){
    }
    public void act()
    {
        playerMove(5);
        turnToCursor();
        shootBullet();
        firespeed++;
        

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
        if(shooting==true&&firespeed>30){
            Bullet bullet = new Bullet();
            getWorld().addObject(bullet,getX(),getY()); 
            bullet.setRotation(getRotation());
            firespeed=0;
        }
        
    }
}
