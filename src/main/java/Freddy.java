import java.util.ArrayList;
import java.util.Scanner;

public class Freddy {
    public static final String reply = "Freddy: ";
    public static ArrayList<String> todo = new ArrayList<>();

    public static void main(String[] args) {
        greet();
        if (respond().equals("bye")){
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
        printline();
        System.out.println(reply+"Bye. Hope to see you again soon!");
        printline();
    }

    public static String respond(){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        while (!str.equals("bye")){
            printline();
            switch (str){
            case "list":
                for (int i = 0; i < todo.size(); i++){
                    System.out.println(String.valueOf(i+1)+". "+todo.get(i));
                }
                break;
            default:
                todo.add(str);
                System.out.println(reply+str+" is added for you");

            }
            printline();
            str = scan.nextLine();
        }
        scan.close();
        return str;
    }

}
