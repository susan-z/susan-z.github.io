/*Name: Susan Zhao
 * PennKey: suzhao
 * Recitation: 216
 * 
 * Execution: java Race
 * 
 * Races a Penn pennant with a Princeton pennant
 */


public class Race {    
    
    public static void main(String[] args) {
        
        boolean pennWins = false;       
        boolean princetonWins = false;  
        
        // the width of 1 pixel 
        double ONE_PIXEL = 1.2 / 512;   
        
        // location of pennants before starting line
        double pennX = 0.15;
        double princetonX = 0.15;
        // increment
        double dx = 0.05; 
        // finish line value
        double finish = 0.95;
        
        // animation at 30 frames/second
        PennDraw.enableAnimation(20);
        
        while (!pennWins && !princetonWins) {
            
            //clear screen
            PennDraw.clear(); 
            
            // start line and finish line
            PennDraw.text(0.3, 0.96, "Start");
            PennDraw.line(0.3, 0, 0.3, 0.95);
            
            PennDraw.text(0.9, 0.96, "Finish");
            PennDraw.line(0.9, 0, 0.9, 0.95);
            
            // draw both pennants
            PennDraw.picture(pennX, .7, "penn.png");
            
            PennDraw.picture(princetonX, .3, "princeton.png");
            
            // check if any crossed the finish line
            if (pennX >= finish || princetonX >= finish) {
                break;
            }
            // randomly increment penn or princeton
            else {
                if (Math.random() <= 0.5) {
                    pennX += dx;
                }
                else {
                    princetonX += dx;
                }
            }
            
            PennDraw.advance(); 
        }
        
        PennDraw.disableAnimation(); // turn off animation
        // Victory message
        if (pennX >= finish) {
            PennDraw.text(0.5, 0.5, "Penn Wins!");
        }
        else {
            PennDraw.text(0.5, 0.5, "Princeton Wins!");
        }
    }
}