public class Cc {
    public static void main(String[] args) {
        int[] symbol= {21, -33, 15, 1, 25, 17, -33, 6, 1, -33, 14, 7, 4, 11, 
            -33, 15, 13, 17, 5, 13, 4, -33, 0, 1, 6};
        //int key = 0;

        double[] freq = new double[26];
        freq = findFrequencies(symbol);
        
        
        
        String engtext = args[0];
        double[] engfreq = new double[26];
        engfreq = getDictionaryFrequencies(engtext);
        
        double score = scoreFrequencies(freq, engfreq);
        
        System.out.print(score);


    }
    public static double[] findFrequencies(int[] cipherText){
        int alphabet = 26;
        double[] cipherFreq = new double[alphabet];
        int charCount = 0;
        for (int i = 0; i < cipherText.length; i++){
            cipherText[i] = Math.abs(cipherText[i]);
            int k = cipherText[i];
            if (k < alphabet && k >=0){
                charCount++ ;
                cipherFreq[k]++ ;
            }
            else{
                charCount = charCount + 0;
            }
        }
        for (int i = 0; i < alphabet; i++){
            cipherFreq[i] = (double) cipherFreq[i] / (double) charCount; 
            System.out.print(cipherFreq[i] + ", ");
        }

        return cipherFreq;
    }

    public static double[] getDictionaryFrequencies(String filename){
        In inStream = new In(filename);
        int alphabet = 26;
        
        double[] englishFreq = new double[alphabet];
        for (int i = 0; i < alphabet; i++) {
            englishFreq[i] = inStream.readDouble();
            System.out.print(englishFreq[i] + ", ");
        }
        return englishFreq;
    }
    public static double scoreFrequencies(double[] freqs, 
                                          double[] englishFreqs){
        int alphabet = 26;
        double scoreFreqs = 0;
        for (int i = 0; i < alphabet; i++){
            scoreFreqs += Math.abs(freqs[i] - englishFreqs[i]);
        }
        return scoreFreqs;
    }
}
