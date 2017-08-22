public class Sketch {
    public static void main(String[] args) {
        PennDraw.setPenColor(210, 255, 255);
        PennDraw.filledRectangle(0.5, 0.75, 0.5, 0.5);
        
        PennDraw.setPenColor(PennDraw.BLUE);
        PennDraw.filledRectangle(0.5, 0.125, 0.5, 0.25);
        
        PennDraw.picture(Math.random(), Math.random() * (1 - .4) + .4, "parrot.png", 80, 80);
        PennDraw.picture(Math.random(), 0.53, "pirate_ship.png", 180, 180);
    }
}