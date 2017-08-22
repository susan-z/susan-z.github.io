/*Name: Susan Zhao
 * PennKey: suzhao
 * Recitation: 216
 * 
 * Execution: java Stamp Sketch
 * 
 * Randomly generates backgrounds and places images where the user places mouse
 */

public class StampSketch {
    public static void main(String[] args) {
        
        boolean firstTime = true;
        
        while (true) {
            
            if (firstTime == true) {
                
                // draw the background
                PennDraw.setPenColor(210, 255, 255);
                PennDraw.filledRectangle(0.5, 0.75, 0.5, 0.5);
                
                PennDraw.setPenColor(PennDraw.BLUE);
                PennDraw.filledRectangle(0.5, 0.125, 0.5, 0.25);
                
                // place the images randomly in the sky and on the water
                PennDraw.picture(Math.random(), Math.random() * (1 - .4) + .4, 
                                 "parrot (1).png", 80, 80);
                PennDraw.picture(Math.random(), 0.53, "pirate_ship.png", 180, 
                                 180); 
                
                firstTime = false;
                
            }
            // redraw background if key is typed
            if (PennDraw.hasNextKeyTyped()) {
                PennDraw.clear();
                
                PennDraw.setPenColor(210, 255, 255);
                PennDraw.filledRectangle(0.5, 0.75, 0.5, 0.5);
                
                PennDraw.setPenColor(PennDraw.BLUE);
                PennDraw.filledRectangle(0.5, 0.125, 0.5, 0.25);
                
                // place the images randomly in the sky and on the water
                PennDraw.picture(Math.random(), Math.random() * (1 - .4) + .4, 
                                 "parrot (1).png", 80, 80);
                PennDraw.picture(Math.random(), 0.53, "pirate_ship.png", 180, 
                                 180); 
                
                PennDraw.nextKeyTyped();
            }
            
            // if the mouse is clicked
            if (PennDraw.mousePressed()) {
                // coordinates of the mouse cursor
                double x = PennDraw.mouseX();
                double y = PennDraw.mouseY();
                
                // if clicked in the ocean, draw treasure
                // the farther from the horizon, the larger the image
                if (y <= 0.375) {
                    PennDraw.picture(x, y, "treasure.png", (y - 0.375) * 180, 
                                     -((y - 0.375) * 180));
                }
                // if clicked in the sky, draw a happy cloud
                else {
                    PennDraw.picture(x, y, "happycloud.png", (0.375 - y) * 180,
                                     -((0.375 - y) * 180));
                }
                
                
                
            }
        }
    }
}

            
      
