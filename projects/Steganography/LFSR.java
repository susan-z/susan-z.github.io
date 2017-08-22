/* Name: Susan Zhao
 * pennkey: suzhao
 * recitation: 216
 * 
 * Execution: creates a linear feedback shift register
 * 
 */

public class LFSR {
    private static int[] register; 
    private static String bitSequence;
    private static int tapPositionIndex;
    
    /* Description: Takes a String parameter and integer parameter that will 
     * fill a register with 1's and 0's corresponding to letters
     * Input: String of 0's and 1's, and an integer representing the position 
     * in the register to use as the tap
     * Output: none, but full integer register of the same 0's and 1's string 
     * seed 
     */
    public LFSR(String seed, int tapPosition) {
        register = new int[seed.length()];
        
        // send error if string is null
        if (seed.length() == 0) {
            throw new RuntimeException("ERROR: seed is null");
        }    
        // send error if string does not contain 0's or 1's
        for (int i = 0; i < seed.length(); i++) {
            if (seed.charAt(i) != '0' && seed.charAt(i) != '1') {
                throw new RuntimeException("ERROR: seed contains an invalid " + 
                                           "bit");
            }
            // fill array with int values of 1's and 0's
            register[i] = seed.charAt(i) - '0';
        }
        // send error if position of tap is not in array
        if (tapPosition < 0 || tapPosition > register.length) {
            throw new RuntimeException("ERROR: position of tap not possible" + 
                                       "in register");
        }
        tapPositionIndex = tapPosition;
    }
    
    /* Description: Returns the bit sequence in the shift register
     * Input: none
     * Output: String of the bits in the register
     */
    public String toString() {
        bitSequence = "";
        for (int i = 0; i < register.length; i++) {
            int x = register[i];
            bitSequence = bitSequence + x;
        }
        return bitSequence;
    }
    
    /* Description: returns the tap position
     * Input: none
     * Output: integer representing the tap position for the register
     */
    public int getTapPosition() {
        return tapPositionIndex;
    }
    
    /* Description: performs one step of the LFSR, by shifting each bit and 
     * XOR-ing the most significant bit and the bit at the tap position
     * Input: none
     * Output: returns the value of the least significant bit 
     */
    public int nextBit() {
        int tap = (register.length - 1) - tapPositionIndex;
        int temp = register[0] ^ register[tap];
        
        for (int i = 1; i < 11; i++) {
            register[i - 1] = register[i];
        }
        
        register[register.length - 1] = temp;
        
        return register[register.length - 1];
    }
}