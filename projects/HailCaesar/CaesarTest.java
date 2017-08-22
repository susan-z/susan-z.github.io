/*Name: Susan Zhao
 * PennKey: suzhao
 * Recitation: 216
 * 
 * Execution: java Casesar
 * 
 * Encrypts, decrypts, and cracks a Caesar cipher
 */

public class Caesar {
    public static void main(String[] args) {
        //take in command line string
        /*String message = args[0];
        String shiftkey = args[1];
        
        message = message.toUpperCase();
        
        char movekey = shiftkey.charAt(0);
        int key = (int) (movekey - 'A');
        */
        

    }
    
    /* Description: Takes a message and excrypts it using an integer value of a
     * letter to shift each element of the message
     * Input: String message and the integer value of the key 
     * Output: Encrypted message
     */
    public static String encrypt(String message, int key){
        int[] messageSym = new int[message.length()];
        int[] shiftedMessage = new int[messageSym.length];

        messageSym = stringToSymbolArray(message);
        shiftedMessage = shift(messageSym, key);
        String encryptedMessage = symbolArrayToString(shiftedMessage);
                
        //System.out.println(encryptedMessage);
        return encryptedMessage;
    }
    /* Description: Takes an encrypted message and decrypts it using a key 
     * provided
     * Input: Encrypting string message and the integer value of the key
     * Output: Decrypted message 
     */
    public static String decrypt(String cipher, int key) {
        int[] cipherSym = new int[cipher.length()];
        int[] unshiftedCipher = new int[cipherSym.length];
        
        cipherSym = stringToSymbolArray(cipher);
        unshiftedCipher = unshift(cipherSym, key);
        String decryptedMessage = symbolArrayToString(unshiftedCipher);
        
        //System.out.println(decryptedMessage);
        return decryptedMessage;
    }
         
    /* Description: convert string to a symbol array
     * Input: message text to convert
     * Output: array of integers encoding the message
     */
    public static int[] stringToSymbolArray(String str){
        int[] symbol = new int[str.length()];
        
        for (int i = 0 ; i < str.length();  i++){
            char letter = str.charAt(i);
            symbol[i] = (int) (letter - 'A');   
        }
        return symbol;

    }
    /* Description: convert symbol array to string
     * Input: array of integers
     * Output: message text
     */
    
    public static String symbolArrayToString(int[] symbol){
        char[] letter = new char[symbol.length];

        for (int i =0; i < symbol.length; i++){
            letter[i] = (char) (symbol[i] + 'A');
        }
        String str = new String (letter);
        return str;
    }
    /* Description: Part 1 of 2 for shift, takes into account the wrap-around
     * and adds the integer value of the key to the encrypted integer value
     * Input: encrypted integer value
     * Output: shifted integer value
     */
    public static int shift(int i, int key){
        int shiftedNum = 0;
        if (i + key > 25){
            shiftedNum = (i + key) % 26;
        }
        else{
            shiftedNum = i + key;
        }
        return shiftedNum;      
    }
    
    /* Description: Part 2 of 2 for shift, shifts each element of the encrypted
     * code by a select key and stores it into a new array 
     * Input: integer array of symbols and integer value of key 
     * Output: shifted integer array 
     */
    public static int[] shift(int[] symbol, int key){
        int[] shiftedSym = new int[symbol.length];
        for (int i = 0; i < symbol.length; i++){
            if ( symbol[i] < 26 && symbol[i] >= 0 ){
            shiftedSym[i] = shift(symbol[i], key);
            }
            else{
                shiftedSym[i] = symbol[i];
            }
        }
        return shiftedSym;
        }
    /* Description: Overload for unshift function, takes the key and subtracts
     * it from the symbol
     * Input: Integer symbol and key
     * Output: Integer value of unshifted symbol
     */
    public static int unshift(int x, int key){
        int unshiftedNum = 0;
        if (x - key < 0){
            unshiftedNum = 26 - (key - x);
        }
        else{
            unshiftedNum = x - key;
        }
        return unshiftedNum;
    }
    
    /* Description: Takes the shifted encrypted cipher and reverts it back to 
     * its original encryption form
     * Input: Integer array corresponding to symbols and an integer key 
     * Output: Original integer array 
     */
    public static int[] unshift(int[] symbol, int key){
        int[] unshiftedSym = new int[symbol.length];
        for (int i = 0; i < symbol.length; i++){
            if (symbol[i] < 26 && symbol[i] >= 0){
                unshiftedSym[i] = unshift(symbol[i], key);
            }
            else{
                unshiftedSym[i] = symbol[i];
            } 
        }
        return unshiftedSym;
    }
}
    