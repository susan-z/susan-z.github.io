/**
 * Interface for game objects
 */
interface GameObject {
    public double getXLeft();
    public double getXRight();
    public double getTop();
    public double getBottom();
    public void draw();
    public void move();
    public boolean detectCollision(Chopper copter) ;
    public boolean isOffScreen(); 
    }
