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
            String remain = remove_first(str);
            switch (words[0].toLowerCase()){
            case "mark":
                if (words.length != 2 || ! isAllDigits(words[1])){//Check if input follows requirement
                    System.out.println(reply+"Remember to add an index after mark");
                    break;
                }
                int index = Integer.parseInt(words[1]) - 1;
                if (index >= todo.size()){ //Check if task is beyond limit
                    System.out.println(reply+"Oops, we don't have so many task");
                    break;
                }
                todo.get(index).check();
                break;
            case "unmark":
                if (words.length != 2 || ! isAllDigits(words[1])){ //Check if input follows requirement
                    System.out.println(reply+"Remember to add an index after unmark");
                    break;
                }
                int index1 = Integer.parseInt(words[1]) - 1;
                if (index1 >= todo.size()){ //Check if task is beyond limit
                    System.out.println(reply+"Oops, we don't have so many task");
                    break;
                }
                todo.get(index1).uncheck();
                break;
            case "list":
            case "l":
                if (words.length == 1) {
                    for (int i = 0; i < todo.size(); i++) {
                        System.out.println(String.valueOf(i + 1) + ". " + todo.get(i).get_detail());
                    }
                    break;
                }
            case "todo":
            case "t":
                todo.add(new Todo(remain));
                adding(remain);
                break;
            case "deadline":
            case "ddl":
                String[] temp = remain.split(" /by ");
                if (temp.length == 1){ //Check if input follows requirement
                    System.out.println(reply+"Please include a /by in your deadline");
                    break;
                }
                todo.add(new Deadline(temp[0],temp[1]));
                adding(temp[0]);
                break;
            case "event":
            case "e":
                String[] temp1 = remain.split(" /from ");
                if (temp1.length == 1){ //Check if input follows requirement
                    System.out.println(reply+"Please include a /from in your event");
                    break;
                }
                String[] temp2 = temp1[1].split("/to");
                if (temp2.length == 1){ //Check if input follows requirement
                    System.out.println(reply+"Please include a /to in your event");
                    break;
                }
                todo.add(new Event(temp1[0],temp2[0],temp2[1]));
                adding(temp1[0]);
                break;
            default:
                System.out.println(reply+" Please start your sentence with commands.");
                System.out.println(reply+"Commands avaiable: list, mark, unmark, todo, event, deadline, bye");
            }
            printline();
            str = scan.nextLine();
        }
        scan.close();
        return str;
    }

    //Function used to check user input validity
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

    public static void adding(String str){
        System.out.println(reply+str+" is added for you");
        todo.get(todo.size()-1).print_detail();
        System.out.println(reply+"You have "+String.valueOf(todo.size())+" tasks in the list now");
    }

    public static String remove_first(String s){
        s = s.trim();
        boolean blank = false;
        for (int i=1; i<s.length(); i++){
            if (s.charAt(i)==' '){blank = true;}
            else if(blank){
                s=s.substring(i);
                break;
            }
        }
        return s;
    }

}
