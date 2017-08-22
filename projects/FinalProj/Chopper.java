/*
Partner 1 Name: Susan Zhao
Partner 1 PennKey: suzhao
Partner 1 Recitation #: 216

Partner 2 Name: Tong Pow
Partner 2 PennKey: tpow
Partner 2 Recitation #: 202
 * 
 * Execution: Creates all methods for the helicopter
 * 
*/
class Chopper {
    private double x;
    private double y;
    private double vy = 0.02;
    private double size = 0.08;
    public static final double GET_PIXEL_SIZE = 550;
    
    /* Description: constructor 
     * Input: double x and double y 
     * Output: determines the x and y values
    */
    public Chopper(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    /* Description: setter for the y position when restarting the game
     * Input: none
     * Output: none, positions the helicopter back at center of y axis
    */
    public void setY() {
        y = 0.5;
    }
    
    /* Description: gets y position of the top of the helicopter
     * Input: none
     * Output: double value
    */
    public double getTop() {
        return y + size / 2;
    }
    
    /* Description: gets y position of the bottom of the helicopter
     * Input: none
     * Output: double value
    */
    public double getBottom() {
        return y - size / 2;
    }
    
    /* Description: gets the x position for the front of the helicopter
     * Input: none
     * Output: double value
    */
    public double getFront() {
        return x + size / 2; 
    }
    
    /* Description: gets the x position for the back of the helicopter
     * Input: none
     * Output: double value
    */
    public double getBack() {
        return x - size / 2;
    }
    
    /* Description: when the left mouse key is pressed, the helicopter flies up
     * Input: none
     * Output: none, changes the y position by adding positive velocity
    */
    public void fly() {
        y += vy * 2;
    }
    
    /* Description: draws the helicopter
     * Input: none
     * Output: none, draws the helicopter on the screen
    */
    public void draw() {
        PennDraw.picture(x, y, "copter.png", size * GET_PIXEL_SIZE, 
                         size * GET_PIXEL_SIZE);
    }
    
    /* Description: moves the helicopter by giving it a constant falling force
     * Input: none
     * Output: none
    */    
    public void move() {
        y -= vy;
    }
}
