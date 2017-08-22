/*
Partner 1 Name: Susan Zhao
Partner 1 PennKey: suzhao
Partner 1 Recitation #: 216

Partner 2 Name: Tong Pow
Partner 2 PennKey: tpow
Partner 2 Recitation #: 202
 * 
 * Execution: Runs the Helicopter game
 * 
*/
public class Helicopter {
    
    private static Chopper helicopter;
    private static GameObject building = null;
    private static GameObject bird = null;
    private static int livesRemaining = 3;
    private static double score = 0;
    public static final double BOUNDARY_Y = 0.05;
    
    public static void main(String[] args) {
        helicopter = new Chopper(0.15, 0.5);
        // implements the linked list for objects birds and buildings
        LinkedList<GameObject> buildings = new LinkedList<GameObject>();
        LinkedList<GameObject> birds = new LinkedList<GameObject>();
        boolean running = false;
        boolean start = true;
        PennDraw.enableAnimation(60);
        
        while(true) {
            while(start) {
                // draw start menu          
                PennDraw.clear(182, 235, 252);
                PennDraw.setFontSize(44);
                PennDraw.setPenColor(PennDraw.WHITE);
                PennDraw.text(0.5, 0.75, "HELICOPTER GAME");
                PennDraw.setFontSize(36);
                PennDraw.text(0.5, 0.5, "PRESS ANY KEY TO START");
                PennDraw.setFontSize(25);
                PennDraw.text(0.5, 0.25, "Hold left mouse button to fly!");
                PennDraw.text(0.5, 0.15, "Lives:" + livesRemaining);
                if (PennDraw.hasNextKeyTyped()){
                    running = true;
                    PennDraw.nextKeyTyped();
                }
                
                // run helicopter game
                if (running) {
                    PennDraw.clear(160, 227, 250);
                    PennDraw.setPenColor(PennDraw.GREEN);
                    PennDraw.filledRectangle(0.5, 0, 1, BOUNDARY_Y);
                    PennDraw.setPenColor(PennDraw.BLACK);
                    
                    helicopter.draw();
                    helicopter.move(); 
                    
                    //user inputs to fly
                    if (PennDraw.mousePressed()) {
                        helicopter.fly();
                    }
                    
                    if (building == null){
                        // add building from the rightmost edge
                        building = new Building(1, BOUNDARY_Y, 
                                  Building.randWidth(), Building.randHeight());
                        buildings.add(building);
                    }
                    // add buildings if there is enough space
                    int canBuildingBeAdded = 0;
                    for (int i = buildings.size(); i > 0; i--) { 
                        if (buildings.get(i).getXRight() <= Building.FREQUENCY){
                            canBuildingBeAdded++; 
                        }
                    }
                    if (canBuildingBeAdded == buildings.size()){
                        // add building from the rightmost edge
                        building = new Building(1, BOUNDARY_Y, 
                                  Building.randWidth(), Building.randHeight());
                        buildings.add(building);
                    }
                    
                    if (bird == null){
                    bird = new Birds(1, Birds.randHeight());
                    birds.add(bird);
                    }
                    if (bird != null) {
                        //if probability greater than random, generate new bird
                        if (Math.random() < Birds.BIRD_PROBABILITY) {
                            bird = new Birds(1, Birds.randHeight());
                            birds.add(bird);
                        }
                    }                    
                    
                    //remove birds that move past the screen
                    for (int i = birds.size(); i > 0; i--) {
                        if (birds.get(i).isOffScreen()) {
                            birds.remove(i);
                        }
                        // move the birds
                        else {
                            birds.get(i).move();
                        }
                    }
                    
                    // draw all birds
                    for (int i = birds.size(); i > 0; i--) {
                        birds.get(i).draw();
                    }  
                    
                    // remove buildings that pass the screen 
                    for (int i = buildings.size(); i > 0; i--) {
                        if (buildings.get(i).isOffScreen()) {
                            buildings.remove(i);
                        }
                        // move the buildings
                        else {
                            buildings.get(i).move();
                        }
                    }
                    
                    // draw all buildings
                    for (int i = buildings.size(); i > 0; i--) {
                        buildings.get(i).draw();
                    } 
                    
                    //detect collisions with birds and buildings
                    boolean collided = false;
                    for (int i = buildings.size(); i > 0; i--) {
                        if (buildings.get(i).detectCollision(helicopter)){
                            collided = true;
                        }
                    }
                    for (int i = birds.size(); i > 0; i--) {
                        if (birds.get(i).detectCollision(helicopter)){
                            collided = true;
                        }
                    }
                    if (collided) {
                        start = false;
                        livesRemaining--;
                    }
                    
                    // helicopter crashes if it hits the ground or goes off top
                    // of screen 
                    if (helicopter.getBottom() <= BOUNDARY_Y || 
                        helicopter.getBottom() >= 1.1) {
                        start = false;
                        livesRemaining--;
                    }
                    
                    //creates the scorebox on the left corner of the screen
                    PennDraw.setPenColor(PennDraw.WHITE);
                    PennDraw.filledRectangle(0.1, 0, 0.1, 0.02);
                    PennDraw.setPenColor(PennDraw.BLACK);
                    PennDraw.setFontSize(12);
                    PennDraw.text(0.1, 0, "Score:" + (int)score);
                    score += 0.1;
                    PennDraw.advance();
                }
                PennDraw.advance();
            }
            // if all lives are lost, then Game Over
            if (livesRemaining == 0){
                PennDraw.clear(PennDraw.RED);
                PennDraw.setFontSize(45);
                PennDraw.setPenColor(PennDraw.BLACK);
                PennDraw.text(0.5, 0.6, "Game Over");
                PennDraw.text(0.5, 0.4, "Final Score: " + (int)score);
                PennDraw.advance();
            }
            // the player can try again and continue the game if lives remain
            else{
            PennDraw.clear(PennDraw.BLACK);
            PennDraw.setFontSize(36);
            PennDraw.setPenColor(PennDraw.RED);
            PennDraw.text(0.5, 0.75, "Ouch... you crashed!");
            PennDraw.setPenColor(PennDraw.RED);
            PennDraw.text(0.5, 0.5, "TRY AGAIN?");
            PennDraw.text(0.5, 0.3, "Lives Remaining:" + livesRemaining);
            PennDraw.text(0.5, 0.1, "Score: " + (int)score);
            PennDraw.setFontSize(25);
            PennDraw.text(0.5, 0.25, "Press any key to continue");
            
            if (PennDraw.hasNextKeyTyped()){
                start = true;
                PennDraw.nextKeyTyped();
                
                for (int i = buildings.size(); i > 0; i--) {
                    buildings.remove(i);
                }
                for (int i = birds.size(); i > 0; i--) {
                    birds.remove(i);
                }
                helicopter.setY();
            }
            PennDraw.advance();
        }
        }
        
    }
}