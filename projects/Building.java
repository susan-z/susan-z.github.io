/*
Partner 1 Name: Susan Zhao
Partner 1 PennKey: suzhao
Partner 1 Recitation #: 216

Partner 2 Name: Tong Pow
Partner 2 PennKey: tpow
Partner 2 Recitation #: 202
 * 
 * Execution: Creates all the methods for the buildings
 * 
*/
class Building implements GameObject {
    
    private double x;
    private double y;
    private double width;
    private double height;
    private double getPixelSize = 550;
    public static final double MAX_WIDTH = 0.25;
    public static final double MIN_WIDTH = 0.2;
    public static final double MAX_LENGTH = 0.75;
    public static final double MIN_LENGTH = 0.1;
    public static final double VELOCITY = 0.01;
    public static final double FREQUENCY = 0.70;
    
    /* Description: constructor
     * Input: none
     * Output: none
    */
    public Building(double x, double y, double width, double height) {
        if (width <= 0) {
            throw new IllegalArgumentException("width must be > 0");
        }
        if (height <= 0) {
            throw new IllegalArgumentException("height must be > 0");
        }
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    /* Description: gets x position of the left wall of the building
     * Input: none
     * Output: double value
    */
    public double getXLeft() {
        return x;
    }
    
    /* Description: gets the x position of the right wall of the building
     * Input: none
     * Output: double value
    */
    public double getXRight() {
        return x + width; 
    }
    
    /* Description: gets the y position of the top of the helicopter
     * Input: none
     * Output: double value
    */
    public double getTop() {
        return y + height;
    }
    
    /* Description: gets the y position of the bottom of the helicopter
     * Input: none
     * Output: double value
    */
    public double getBottom() {
        return y;
    }
    
    /* Description: generates a random width (within a range) for the building
     * Input: none
     * Output: double value
    */
    public static double randWidth() {
        return MIN_WIDTH + (Math.random() * (MAX_WIDTH - MIN_WIDTH));
    }
    
    /* Description: generates a random height (within a range) for the building
     * Input: double value
    */
    public static double randHeight() {
        return MIN_LENGTH + (Math.random() * (MAX_LENGTH - MIN_LENGTH));
    }
    
    /* Description: draws the building, but the image changes depending on the
     * height 
     * Input: none
     * Output: none, draws the building on the screen
    */
    public void draw() {
        if (height >= 0.6) {
            PennDraw.picture(x + width / 2, y + height / 2, 
           "Office_Building.png", width * getPixelSize, height * getPixelSize);
        }
        else if (height < 0.6 && height >= 0.5) {
            PennDraw.picture(x + width / 2, y + height / 2, 
           "Science_Museum.png", width * getPixelSize, height * getPixelSize);
        }
        else if (height < 0.5 && height >= 0.4) {
            PennDraw.picture(x + width / 2, y + height / 2, "Laundromat.png", 
                             width * getPixelSize, height * getPixelSize);
        }
        else if (height < 0.4 && height >= 0.3) {
            PennDraw.picture(x + width / 2, y + height / 2, "bakery.png", 
                             width * getPixelSize, height * getPixelSize);
        }
        else if (height < 0.3 && height >= 0.2) {
            PennDraw.picture(x + width / 2, y + height / 2, 
         "Employment_Office.png", width * getPixelSize, height * getPixelSize);
        }
        else {
            PennDraw.picture(x + width / 2, y + height / 2, 
         "Aquarium_Building.png", width * getPixelSize, height * getPixelSize);
        }
    }
    
    /* Description: moves the building to the left
     * Input: none
     * Output: none
    */
    public void move() {
        x -= VELOCITY;
    }
    
    /* Description: detects if a collision occurred between the helicopter and
     * the building
     * Input: none
     * Output: boolean 
    */
    public boolean detectCollision(Chopper helicopter) {
        
        return helicopter.getFront() >= x && helicopter.getFront() <= x + width
            && helicopter.getBottom() >= y && helicopter.getBottom() <= y + height;
        
        
    }
    
    /* Description: checks if the building is off the left side of the screen
     * Input: none
     * Output: boolean
    */
    public boolean isOffScreen() {
        return (x + width < 0);
    }
}
