public class CommandLineArguments {
    public static void main(String[] args) {
        System.out.println(args.length);
        System.out.println(args[0]);
        System.out.println(Double.parseDouble(args[1]));
        System.out.println(Integer.parseInt(args[2]));
    }
}
    