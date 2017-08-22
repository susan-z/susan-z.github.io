public class CaesarTestalilbit {
    /*      
        str = str.toUpperCase();
        stringToSymbolArray(str);
        int[] symbol = {2, 14, 13, 18, 20, 11};
        symbolArrayToString(symbol);        
        int key = 1;        
        shift(symbol, key);        
        unshift(symbol, key);
        */
    public static void main(String[] args) {
        int[] symbol = {1};
        int key = 1;
        shift(symbol, key);
    }
            
    public static int shifttwo(int i, int key){
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
            if (symbol[i] < 26){
            shiftedSym[i] = shifttwo(symbol[i], key);
            }
            else{
                shiftedSym[i] = symbol[i];
            }
        }
        System.out.print(shiftedSym);
        
        return shiftedSym;
        }

    }