import java.util.ArrayList;
import java.util.Scanner;

public class Freddy {
    public static final String reply = "Freddy: ";
    public static ArrayList<Task> todo = new ArrayList<>();

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
            String[] words = str.split(" ");
            switch (words[0]){

            case "mark":
                if (words.length != 2 || ! isAllDigits(words[1])){
                    System.out.println(reply+"Remember to add an index after mark");
                    break;
                }
                int index = Integer.parseInt(words[1]) - 1;
                if (index >= todo.size()){
                    System.out.println(reply+"Oops, we don't have so many task");
                    break;
                }
                todo.get(index).check();
                break;
            case "unmark":
                if (words.length != 2 || ! isAllDigits(words[1])){
                    System.out.println(reply+"Remember to add an index after unmark");
                    break;
                }
                int index1 = Integer.parseInt(words[1]) - 1;
                if (index1 >= todo.size()){
                    System.out.println(reply+"Oops, we don't have so many task");
                    break;
                }
                todo.get(index1).uncheck();
                break;
            case "list":
                if (words.length == 1) {
                    for (int i = 0; i < todo.size(); i++) {
                        System.out.println(String.valueOf(i + 1) + ". " + todo.get(i).get_detail());
                    }
                    break;
                }
            default:
                todo.add(new Task(str));
                System.out.println(reply+str+" is added for you");

            }
            printline();
            str = scan.nextLine();
        }
        scan.close();
        return str;
    }

    public static boolean isAllDigits(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char ch : str.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

}
