/* Name: Susan Zhao
 * pennkey: suzhao
 * recitation: 216
 * 
 * Execution: Creates a library to encode, decode, encrypt and decrypt messages
 * and bits
 * 
 */

public class Codec {
    private static int[] binary;
    private static String originalMessage = "";
    private static int[] randomBits;
    
    /* Description: encodes the string of letters into binary 
     * Input: String of characters
     * Output: Binary representation of the string of letters
     */
    public static int[] encode(String str) {
        binary = new int[str.length() * 7];
        if (str.length() == 0) {
            throw new RuntimeException("ERROR: String is null");
        }
        for (int i = 0; i < str.length(); i++) {
            int x = (int) str.charAt(i);
            int last = binary.length - 1;
            for (int j = 0; j < 7; j++) {
                if (x % 2 == 1) binary[last - j] = 1;
                else binary[last - j] = 0;
                x = x / 2;
            }
            if (i == str.length() - 1) return binary;
            for (int j = 7; j < binary.length; j++) {
                binary[j - 7] = binary[j];
            }
        }
        return binary;
    }      
    
    /* Description: decodes a list of binary bits into a string of letters
     * Input: integer array of bits
     * Output: String of letters
     */
    public static String decode(int[] bits) {
        int x = 0;
        int count = 0;
        for (int i = 0; i < bits.length; i++) {
            count++;
            if (bits[i] == 1) { 
                x += (int) Math.pow(2 , 6 - (count - 1));
            }
            if (count == 7) {
                char letter = (char) x;
                originalMessage = originalMessage + letter;
                x = 0;
                count = 0;
            }
        }
        return originalMessage;
    }
    
     /* Description: encrypts a message of 1's and 0's using LFSR 
     * Input: integer array of the message, a String of bits called the seed, 
     * and integer value for the tap position
     * Output: void, but updates the integer array 
     */
    public static void encrypt(int[] message, String seed, int tapPosition) {
        LFSR lfsr = new LFSR(seed, tapPosition);
        randomBits = new int[message.length];
        for (int i = 0; i < message.length; i++) {
            int bit = lfsr.nextBit();
            randomBits[i] = bit;
        }
        for (int j = 0; j < message.length; j++) {
            message[j] = randomBits[j] ^ message[j];
        }
    }
    
    /* Description: decrypts a cipher using a seed and tap position
     * Input: integer array of the cipher, a String of bits (seed) and an 
     * integer value of the tap position
     * Output: void, but updates the integer array
     */
    public static void decrypt(int[] cipher, String seed, int tapPosition) {
        encrypt(cipher, seed, tapPosition);
        decode(cipher);
    }
}

        

