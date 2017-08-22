/* Name: Susan Zhao
 * pennkey: suzhao
 * recitation: 216
 * 
 * Execution: Hides a text file message into a designated image file, either 
 * encrypted or not
 * 
 */

public class HideMessage {
    
    public static void main(String[] args) {
        String imagefile = args[0]; 
        String textfile = args[1]; 
        
        In inStream = new In(textfile);
        String message = inStream.readAll();
        
        if (message.length() > imagefile.length()) {
            throw new RuntimeException("ERROR: message too long for image");
        }
        // add the null character the terminate the message
        message = message + "\0";

        int[][] pixels = ImageData.load(imagefile);
        
        if (args.length == 2) {
            // embed the message without encrypting
            int[] encodedMessage = Codec.encode(message);
            // alter the LSB in the image to correspond to the message          
            int count = 0;
            for (int i = 0; i < pixels.length; i++) {
                for (int j = 0; j < pixels[i].length; j++) {
                    int x = pixels[i][j] % 2;
                    if (x != encodedMessage[count] && x == 0) {
                        pixels[i][j] += 1;
                    }
                    if (x != encodedMessage[count] && x == 1) {
                        pixels[i][j] -= 1;
                    }
                    if (count == encodedMessage.length - 1) { break; }
                    count++;
                }
            }
            ImageData.show(pixels);
        }
        
        if (args.length == 4) {
            // encrypt then embed the message into the image
            String seed = args[2];
            int tap = Integer.parseInt(args[3]); 
            int[] encodedMessage = Codec.encode(message);
            Codec.encrypt(encodedMessage, seed, tap);
            
            int count = 0;
            // alter the LSB of the pixels to correspond to the message
            for (int i = 0; i < pixels.length; i++) {
                for (int j = 0; j < pixels[i].length; j++) {
                    int x = pixels[i][j] % 2;
                    if (x != encodedMessage[count] && x == 0) {
                        pixels[i][j] += 1;
                    }
                    if (x != encodedMessage[count] && x == 1) {
                        pixels[i][j] -= 1;
                    }
                    if (count == encodedMessage.length - 1) { break; }
                    count++;
                }
            }
            ImageData.show(pixels);
        }
    }
}