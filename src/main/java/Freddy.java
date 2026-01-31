import java.util.Scanner;

public class Freddy {
    public static final String reply = "Freddy: ";
    public static void main(String[] args) {
        greet();
        if (echo().equals("bye")){
            bye();
        }
    }

    public static void greet(){
        String logo = ""+
                "  _____   _____   ______  ____    ____   __   __\n" +
                " |  ___| |  __ \\ |  ____||  _  \\ |  _  \\ \\ \\ / /\n" +
                " | |__   | |__) || |__   | | | | | | | |  \\ V /\n" +
                " |  __|  |  _  / |  __|  | | | | | | | |   | |\n" +
                " | |     | | \\ \\ | |____ | |_| | | |_| |   | |\n" +
                " |_|     |_|  \\_\\|______||____/  |____/    |_|\n";
        printline();
        System.out.println("Hello from\n" + logo);
        System.out.println("What can I do for you?");
        printline();
    }

    public static void printline(){
        System.out.println("-----------------------------------------------");
    }

    public static void bye(){
        System.out.println(reply+"Bye. Hope to see you again soon!");
        printline();
    }

    public static String echo(){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        while (!str.equals("bye")){
            printline();
            System.out.println(reply+str);
            printline();
            str = scan.nextLine();
        }
        printline();
        scan.close();
        return str;
    }

}
