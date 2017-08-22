public class AnimationDemo{
    public static void main(String[] args){
      
        PennDraw.setCanvasSize(500, 500);
        
        PennDraw.enableAnimation(30);
        PennDraw.setPenColor(255, 0, 0);
        
        while (true) {
            //my code to draw frame of animation goes here
            
            PennDraw.setPenColor((int)(Math.random()*255), 0, 0)
            double x = PennDraw.mouseX();
            double y = PennDraw.mouseY();
            PennDraw.filledCircle(0.5, 0.5, 0.1);
            
            PennDraw.advance();
        }
        
    }
}
        