/* Name: Susan
 * PennKey: suzhao
 * Recitation: 216
 * 
 * Execution: java Art
 * Description: This is a birthday cake drawn using recursion to celebrate 
 * people ages 1-28 (if you're any older it's time to grow up) with a placement
 * of candles in a spiral shape, balloons bordering the cake, and a happy 
 * birthday sign. The number of candles represent the person's age. The use of 
 * recursion symbolizes the memories and experiences back from age 0 to the 
 * current age.
 * The optimal ages (aesthetics-wise) are 18-22 years
 */

public class Art {
    public static void main(String[] args) {
        int age = Integer.parseInt(args[0]); 
        
        if (age <= 28) {
            PennDraw.picture(0.5, 0.5, "Caramel Cake.jpg", 512, 512);
            
            birthdayCake(age, 0.5, 0.5, 60, 0.1);
            bdayDecorations(age, 1.0, 0.3, 105, .15);
            
            PennDraw.picture(0.5, 0.10, "happybirthdaysign.png", 512, 120);
        }
    }
    
    /* Description: Draws balloons bordering the cake in a fractal pattern
     * Input: The person's age (depth), x and y coordinate, angle value, and
     * the length/distance the balloons are separated for each recursion
     * Output: A balloon is drawn
     */
    public static void bdayDecorations(int age, double x, double y, 
                                       double angle, double length) {
        if (age <= 0) return;
        
        double angleRad = Math.toRadians(angle);
        double x2 = x + length * (Math.cos(angleRad));
        double y2 = y + length * (Math.sin(angleRad));
        drawBalloons(x, y, angle, length);
        
        bdayDecorations(age - 2, x2, y2, angle - 15, length);
        bdayDecorations(age - 2, x2, y2, angle + 15, length);
    }
    
    /* Description: Draws the candles on the cake
     * Input: Age (depth), x and y coordinate for the candles, angle candles 
     * are apart, length/distance the candles are spaced
     * Output: Candles drawn in a spiral pattern, number of candles = age
     */
    public static void birthdayCake(int age, double x, double y, double angle,
                                    double length) {
        if (age == 0) return; 
        drawCandle(x, y, angle, length);
        
        birthdayCake(age - 1, x, y, angle + 30, length * 1.06);
    }
    
    /* Description: Draws each candle
     * Input: x and y coordinate, angle the candle will be displaced, and the
     * length/distance each candle will be from the other
     * Output: Red candle image on the cake in a spiral formation
     */
    public static void drawCandle(double x, double y, double angle, 
                                  double length) {
        double angleRad = Math.toRadians(angle);
        double x2 = x + (Math.cos(angleRad)) * length;
        double y2 = y + (Math.sin(angleRad)) * length;
        
        PennDraw.picture(x2, y2, "redcandle.png", 15, 50);
    }
    
    /* Description: Draws balloons, one of the six colors each time
     * Input: x and y coordinate, angle, and length value 
     * Output: Draws a balloon at the adjusted coordinate with one of the 
     * six colors
     */
    public static void drawBalloons(double x, double y, double angle, 
                                    double length) {  
        int balloon = (int) (Math.random() * 6 + 1);
        
        if (balloon == 1) {
            PennDraw.picture(x, y, "blueballoon.png", 40, 80);
        }
        if (balloon == 2) {
            PennDraw.picture(x, y, "yellowballoon.png", 40, 80);
        }
        if (balloon == 3) {
            PennDraw.picture(x, y, "purpleballoon.png", 40, 80);
        }
        if (balloon == 4) {
            PennDraw.picture(x, y, "purpleballoon.png", 40, 80);
        }
        if (balloon == 5) {
            PennDraw.picture(x, y, "greenballoon.png", 40, 80);
        }
        if (balloon == 6) {
            PennDraw.picture(x, y, "orangeballoon.png", 40, 80);
        }
    }
}
