/*  Name: Susan Zhao
 *  PennKey: suzhao
 *  Recitation: 216
 *
 *  Execution: A modified version of the game 20 Questions, this program will
 * ask the user a series of questions to ultimately determine which animal they
 * are thinking of
 *
 */
public class GuessingGame {

    private static String[]   questions;
    private static String[][] answers;

    /* Description: Reads the file and populates the questions and answers 
     * array with data
     * Input: filename
     * Output: void
     */
    public static void readData(String filename) {
        In inStream = new In(filename);
        int animalIndex = inStream.readInt();
        int questionIndex = inStream.readInt();
        inStream.readLine();    
        
        questions = new String[questionIndex];
        answers = new String[animalIndex][questionIndex + 1];
        
        for (int i = 0; i < questionIndex; i++) {
            questions[i] = inStream.readLine();
        }
        for (int i = 0; i < animalIndex; i++) {
            for (int j = 0; j < questionIndex + 1; j++) {
                answers[i][j] = inStream.readString();
            }
        }
    }

    /* Description: Prints the number of questions, the number of answers, each
     * respective animal and the data set corresponding to each
     * Input: None
     * Output: Prints out the appropriate data
     */
    public static void print() {
        System.out.println(answers.length);
        System.out.println(questions.length);
        
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
        }
        
        for (int i = 0; i < answers.length; i++) {
            System.out.print(answers[i][0] + "\t");
            for (int j = 1; j < questions.length + 1; j++) {
                System.out.print(answers[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    /* Description: Sorts the entire data set according to the answers data
     * Input: None
     * Output: Sorted arrays, but void output
     */
    public static void sort() {
        sort(0, answers.length, 1); 
    }
  
    /* Description: Sorts the data set within a range starting with the first 
     * index given
     * Input: int first animal, int last animal, int the starting question 
     * asked
     * Output: None, but the arrays are sorted
     */
    public static void sort(int startingAnimalIdx, int endingAnimalIdx, 
                            int startingQuestionIdx) {
        if (startingQuestionIdx == answers.length || startingAnimalIdx == 
            endingAnimalIdx - 1) return;
        sortRange(startingAnimalIdx, endingAnimalIdx, startingQuestionIdx);
        int split = findSplit(startingAnimalIdx, endingAnimalIdx, 
                              startingQuestionIdx);
        if (split == -1) sort(startingAnimalIdx, endingAnimalIdx, 
                              startingQuestionIdx + 1);
        else {
            sort(startingAnimalIdx, split, startingQuestionIdx + 1);
            sort(split, endingAnimalIdx, startingQuestionIdx + 1);  
        }
    }

    /* Description: Sorts the rows within a range using insertion sort and 
     * based on the question asked
     * Input:int first animal, int last animal, int question asked
     * Output: Void output, but rows are swapped accordingly and sorted
     */
    public static void sortRange(int startingAnimalIdx, int endingAnimalIdx, 
                                 int questionIdx) {
        for (int row = startingAnimalIdx + 1; row < endingAnimalIdx; row++) {
            for (int insertion = row; insertion > 0; insertion--) {
                if (answers[insertion][questionIdx].compareTo(
                        answers[insertion - 1][questionIdx]) < 0) {
                    exch(insertion);
                } 
            }
        }
    }
    public static void exch(int row) {
        String[] swap = answers[row - 1];
        answers[row - 1] = answers[row];
        answers[row] = swap;
    }
    
    /* Description: Finds the index in a sorted column where the first answer 
     * "y" appears, and calls the program to proceed to the next column if only
     * all "n"'s and "y"'s are present
     * Input: int first animal, int last animal, int question asked
     * Output: integer regarding the index of the first "y"
     */
    public static int findSplit(int startingAnimalIdx, int endingAnimalIdx,
                                int questionIdx) {
        if (endingAnimalIdx <= startingAnimalIdx) return -1;    
        
        String key = "y";
        int mid = startingAnimalIdx + (endingAnimalIdx - startingAnimalIdx) / 2;
        int compare = answers[mid][questionIdx].compareTo(key);
        
        if (compare < 0) {
            if (mid == endingAnimalIdx - 1) return mid + 1;
            int secondComp = answers[mid + 1][questionIdx].compareTo(key);
            if (secondComp == 0) return mid + 1;
            return findSplit(mid + 1, endingAnimalIdx, questionIdx);
        }
        else return findSplit(startingAnimalIdx, mid, questionIdx);
    } 
    
    /* Description: Searches through the answers data set
     * Input: None
     * Output: String which is the name of the animal the person is thinking of
     */
    
    public static String search() {
        if (answers.length > 0) return search(0, answers.length, 1);
        return null; // only one line! finish the helper function first
    }
    

    /* Description: Searches through the answers within a range, starting at 
     * the question asked
     * Input: int first animal, int last animal, int first question asked
     * Output: String which spells the animal the user is thinking of
     */
    
    public static String search(int startingAnimalIdx, int endingAnimalIdx,
                                int questionIdx) {
        if (startingAnimalIdx == endingAnimalIdx - 1 || questionIdx == 
            answers.length) return answers[startingAnimalIdx][0];
        
        int split = findSplit(startingAnimalIdx, endingAnimalIdx, questionIdx);
        System.out.println(questions[questionIdx - 1]);
        String userAnswer = Prompter.prompt("> ");
        
        if (userAnswer.equals("n")) return search(startingAnimalIdx, split, 
                                                  questionIdx + 1);
        else if (userAnswer.equals("y")) return search(split, endingAnimalIdx, 
                                                       questionIdx + 1);
        else return null;
    }
    

    
    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("Usage:  java GuessingGame <FILENAME>");
            System.exit(1);
        }

        readData(args[0]);
        sort();
        //print();
        //System.out.println(search());
    }
}