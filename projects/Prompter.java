import java.util.Scanner;

public class Prompter {
    
    static Scanner scanner = new Scanner(System.in);
    
    public static String prompt(String prefix) {
        System.out.print(prefix);
        String answer = scanner.nextLine();
        System.out.println();
        return answer;
    }
    
}