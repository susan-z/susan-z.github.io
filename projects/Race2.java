public class Race2 {    
    public static void main(String[] args) {
        boolean pennWins = false;       // has Penn won the race?
        boolean princetonWins = false;  // has Princeton won the race?

        // the width of 1 pixel in window coordinates,
        // assuming you do NOT call PennDraw.setXscale()
        double ONE_PIXEL = 1.2 / 512;   

        // TODO - define any variables you need here
        double pennX = 0.15;
        double princetonX = 0.15;
        double dx = 0.1;
        double finish = 0.95;

        // TODO - set the pennant locations before the starting line
    

        // enable animation at 10 frames/second
        // TODO - you may change the frame rate to be any speed you like
        PennDraw.enableAnimation(10);

        while (!pennWins && !princetonWins) {
             
            //clear the screen
            PennDraw.clear(255, 255, 255); 
            
            // start line and finish line
            PennDraw.text(0.3, 0.96, "Start");
            PennDraw.line(0.3, 0, 0.3, 0.95);
            
            PennDraw.text(0.9, 0.96, "Finish");
            PennDraw.line(0.9, 0, 0.9, 0.95);
            
            // draw both pennants
            //PennDraw.picture(0.15, .7, "penn.png");
            
            //PennDraw.picture(0.15, .3, "princeton.png");
            PennDraw.setPenColor(PennDraw.BLUE);
            PennDraw.filledCircle(pennX, 0.3, 0.1);
            PennDraw.filledCircle(princetonX, 0.7, 0.1);
            
            if (pennX >= finish || princetonX >= finish){
                break;
            }
            else {
                if (Math.random() <= 0.5){
                    pennX += dx;
                }
                    else {
                        princetonX += dx;
                    }
                }
            
                    
            /* TODO the following
             * 1. clear the screen
             * 2. draw the start line
             * 3. draw the finish line
             * 4. draw the Penn and Princeton pennants
             * 5. based on current positions, determine if anyone has won. 
             * 6. determine whether the Penn pennant position changes 
             * 7. determine whether the Princeton pennant position changes 
             */

            PennDraw.advance(); // show this frame and go on to the next one
        }

        PennDraw.disableAnimation(); // the race is over so turn off animation
        // TODO - draw text containing a victory message in the sketch
        if (pennX >= finish){
            PennDraw.text(0.5, 0.5, "Penn Wins!");
        }
        else {
            PennDraw.text(0.5, 0.5, "Princeton Wins!");
        }
    }
}