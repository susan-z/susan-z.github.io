/*
Partner 1 Name: Susan Zhao
Partner 1 PennKey: suzhao
Partner 1 Recitation #: 216

Partner 2 Name: Tong Pow
Partner 2 PennKey: tpow
Partner 2 Recitation #: 202
 * 
 * Execution: Creates all functions for the birds
 * 
*/
class Birds implements GameObject {
    
    private double x;
    private double y;
    private double size = 0.06;
    private double getPixelSize = 550;
    private double chooseBird;
    public static final double BIRD_VELOCITY = 0.02;
    public static final double MAX_HEIGHT = 1;
    public static final double MIN_HEIGHT = 0.3;
    public static final double BIRD_PROBABILITY = 0.022;

    /* Description: constructor
     * Input: two doubles
     * Output: none
    */
    public Birds(double x, double y) {
        this.x = x;
        this.y = y;
        
        chooseBird = Math.random();
    }
    
    /* Description: gets the x position of the leftmost side of the bird
     * Input: none
     * Output: double value
    */
    public double getXLeft() {
        return x - size / 2;
    }
    
    /* Description: gets the x position of the rightmost side of the bird
     * Input: none
     * Output: double value
    */
    public double getXRight() {
        return x + size / 2;
    }
    
    /* Description: gets the y position of the top of the bird
     * Input: none
     * Output: double value
    */
    public double getTop() {
        return y + size / 2;
    }
    
    /* Description: gets the y position of the bottom of the bird
     * Input: none
     * Output: double value
    */
    public double getBottom() {
        return y - size / 2;
    }
    
    /* Description: generates a random value (in a range) for the height of the
     * bird
     * Input: none
     * Output: double value
    */
    public static double randHeight() {
        return MIN_HEIGHT + (Math.random() * (MAX_HEIGHT - MIN_HEIGHT));
    }
    
    /* Description: draws the bird, but each kind of bird has a 1/3 chance of
     * being drawn
     * Input: none
     * Output: none
    */
    public void draw() {
        if (chooseBird > 0.66) {
        PennDraw.picture(x, y, "bird.png", size * getPixelSize, 
                         size * getPixelSize);
        }
        else if (chooseBird <= 0.66 && chooseBird > 0.33){
            PennDraw.picture(x, y, "bird2.png", size * getPixelSize, 
                         size * getPixelSize);
        }
        else {
            PennDraw.picture(x, y, "bird3.png", size * getPixelSize, 
                             size * getPixelSize);
        }
    }
    
    /* Description: moves the bird to the left
     * Input: none
     * Output: none
    */
    public void move() {
        x -= BIRD_VELOCITY;
    }
    
    /* Description: detects a collision between the helicopter and any bird
     * Input: none
     * Output: boolean
    */
    public boolean detectCollision(Chopper helicopter) {

        return helicopter.getFront() >= x - size / 2 
            && helicopter.getBack() <= x + size / 2
            && helicopter.getTop() >= y - size / 2
            && helicopter.getBottom() <= y + size / 2;
        }
    
    /* Description: checks if the bird if off the left side of the screen
     * Input: none
     * Output: boolean
    */
    public boolean isOffScreen() {
        return (x + size < 0);
    }
    
}