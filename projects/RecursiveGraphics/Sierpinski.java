/* 
 * Name: Susan
 * PennKey: suzhao
 * Recitation: 216
 * 
 * Execution: java Sierpinski
 * Description: Creates the Sierpinski triangle, drawing an order of depth-1
 * triangles above, to the left, and to the right of the center triangle using
 * recursion
 * 
 */
public class Sierpinski {
    public static void main(String[] args) {
        int numLevels = Integer.parseInt(args[0]);
        sierpinski(numLevels, 0.5, 0, 0.5);
    }
    
    /* Description: Draws a filled, downwards pointing equilateral triangle
     * Input: An x and y coordinate, and the length of the side of the triangle
     * Output: PennDraw drawing of a downwards pointing equilateral triangle 
     * with the xy coordinate as the bottom vertex
     */
    public static void triangle(double x, double y, double sidelength) {
        
        PennDraw.setPenColor(134, 239, 237);
        
        double x2 = x - (sidelength / 2);
        double y2 = y + (Math.sqrt(3) * sidelength / 2);
        double x3 = x + (sidelength / 2);
        double y3 = y + (Math.sqrt(3) * sidelength / 2);
    
        PennDraw.filledPolygon(x, y, x2, y2, x3, y3);
    }
    
    /* Description: Draws the Sierpinski triangle based on the depth
     * Input: a depth of the recursion, an intial x and y coordinate, and the 
     * length of the triangle in the center
     * Output: Sierpinski triangle, with the next order of triangles to the 
     * right, the left, and above the current triangle
     */
    public static void sierpinski(int numLevels, double x, double y,
                                  double size) {
        if (numLevels < 1) {
            return;
        }
        PennDraw.enableAnimation(30);
        
        triangle(x, y, size);
        triangle(x, y, size);
        triangle(x, y, size);
        
        sierpinski(numLevels - 1, x - (size / 2), y, size / 2);
        sierpinski(numLevels - 1, x + (size / 2), y, size / 2);
        sierpinski(numLevels - 1, x, y + (Math.sqrt(3) * size / 2), size / 2);
        
        PennDraw.advance();
    }
}