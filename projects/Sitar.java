/* Name: Susan Zhao
 * PennKey: suzhao
 * Recitation: 216
 * 
 * Execution: Creates a 37-string Sitar using digital audio
 * 
 */

public class Sitar {
    
    private static String NOTE_MAPPING = 
        "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    private static double frequency = 440.0;
    private static int notePlayed;
    private static SitarString[] notesToPluck = new
        SitarString[NOTE_MAPPING.length()];
    
    public static void main(String[] args) {
        
        for (int i = 0; i < notesToPluck.length; i++) {
            notesToPluck[i] = new SitarString(frequency * Math.pow(2, 
                                                          (i - 24.0) / 12.0));
        }

        // infinite loop to check if a key is pressed
        // and play the associated note
        while (true) {
            // check if the user has typed a key; if so, process it
            if (PennDraw.hasNextKeyTyped()) {
                char key = PennDraw.nextKeyTyped();  // which key was pressed?
                notePlayed = NOTE_MAPPING.indexOf(key);
                if (notePlayed != -1) {
                notesToPluck[notePlayed].pluck();
            }
        }

            // compute the combined sound of all sitar strings
            double sample = 0;
            for (int i = 0; i < notesToPluck.length; i++) {
                sample += notesToPluck[i].sample();
            }

            // play the sample on standard audio
            StdAudio.play(sample);

            // advance the simulation of each sitar string by one step
            for (int i = 0; i < notesToPluck.length; i++) {
            notesToPluck[i].tic();
        }
    }
}
}