/*************************************************************************
 *  Compilation:  javac StudentsFileProcessor.java
 *  Execution:    java StudentsFileProcessor students.txt
 *  Dependencies: In.java
 *  Sample data:  http://introcs.cs.princeton.edu/15inout/students.txt
 *
 *  Reads in the integer N from a file, then a list
 *  of N student records, where each record consists of four
 *  fields, separated by whitespace:
 *      - first name
 *      - last name
 *      - email address
 *      - which recitation they're in
 *
 *  Then, print out a list of email address of students in recitation 4 and 5.
 *
 *  % 130
 *  Sarah Wang twang 7
 *  Austin Taylor actaylor 1
 *  David Rosner drosner 4
 *  Rebecca Allen rebeccaa 7
 *  Rajiv Ayyangar ayyangar 7
 *  Daniel Barrett drbarret 8
 *  Nic Byrd nbyrd 7
 *  Emily Capra ecapra 8
 *  Johnny Clore jclore 7
 *  ...
 *
 * % Section 4
 *  ---------
 *  drosner
 *  jcharles
 *  jph
 *  mlampert
 *  ...
 *
 *  Section 5
 *  ---------
 *  giwank
 *  agrozdan
 *  ajh
 *  akornell
 *  ...
 *
 *************************************************************************/


public class StudentsFileProcessor {
    public static void main(String[] args) { 
        
        // error check the argument
        if (args.length != 1) {
            System.err.println("Usage:  java StudentsFileProcessor <filename>");
            System.exit(1);
        }
        
        // open the file for reading
        String filename = args[0];
        In inStream = new In(filename);

        // read the number of students from the file
        int N = inStream.readInt();

        // initialize four parallel arrays
        String[] first   = new String[N];
        String[] last    = new String[N];
        String[] email   = new String[N];
        int[] recitation = new int[N];

        // read in the data from the file
        for (int i = 0; i < N; i++) {
            first[i]      = inStream.readString();
            last[i]       = inStream.readString();
            email[i]      = inStream.readString();
            recitation[i] = inStream.readInt();
        }

        // print email addresses of all students in recitation 4
        System.out.println("Recitation 4");
        System.out.println("------------");
        for (int i = 0; i < N; i++) {
            if (recitation[i] == 4) {
                System.out.println(email[i]);
            }
        }
        System.out.println();

        // print email addresses of all students in recitation 5
        System.out.println("Recitation 5");
        System.out.println("------------");
        for (int i = 0; i < N; i++) {
            if (recitation[i] == 5) {
                System.out.println(email[i]);
            }
        }

    }

}
