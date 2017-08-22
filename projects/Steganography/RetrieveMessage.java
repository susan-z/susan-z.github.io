/* Name: Susan Zhao
 * pennkey: suzhao
 * recitation: 216
 * 
 * Execution: etracts the cipher from the image and prints out the decrypted, 
 * or the embedded message
 * 
 */

public class RetrieveMessage {
    private static int[] bits;
    private static int[] fixedBits;
    private static int extraPixels;
    
    public static void main(String[] args) {
        String filename = args[0]; 
        
        int[][] pixels = ImageData.load(filename);
        bits = new int[pixels.length * pixels[0].length];
        int count = 0;
        // take the LSB of each pixel and put it in an array
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                if (pixels[i][j] % 2 == 1) { bits[count] = 1; }
                else {
                bits[count] = 0;
                }
                count++;
            }
        }
        // delete the extra pixels at the end, so the number of pixels in the 
        // image is a multiple of 7
        int numPixels = pixels.length * pixels[0].length;
        extraPixels = numPixels % 7;
        fixedBits = new int[bits.length - extraPixels];
        
        for (int i = 0; i < bits.length - extraPixels; i++) {
            fixedBits[i] = bits[i];
        }
        
        if (args.length == 1) {
            // retrieve message and print without decrypting
            String text = Codec.decode(fixedBits);
            int stopAtNull = text.indexOf('\0');
            // only print characters up to the null character
            System.out.print(text.substring(0, stopAtNull));
        }
        
        if (args.length == 3) {
            // retrieve, decrypt, then print the message
            String seed = args[1];
            int tap = Integer.parseInt(args[2]); 
            
            Codec.decrypt(fixedBits, seed, tap);
            String text = Codec.decode(fixedBits);
            int stopAtNull = text.indexOf('\0');
            // only print characters up to the null character
            System.out.print(text.substring(0, stopAtNull));
            
        }
}
}
    