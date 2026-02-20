package freddy;


import freddy.exception.FreddyException;
import freddy.storage.Storage;
import freddy.ui.UI;
import freddy.tasklist.Tasklist;

public class Freddy {
    public static final String reply = "Freddy: ";
    public static Storage io = new Storage();
    public static UI ui = new UI();
    //public static ArrayList<Task> todo = new ArrayList<>();

    public static Tasklist todo = new Tasklist();

    public static void main(String[] args) {
        ui.greet();
        todo.update(io.readAll());
        while (true){
            try{
                if (ui.respond().equals("bye")){
                    ui.bye();
                    break;
                }
            }catch (FreddyException e){
                System.out.println(e.getMessage());
                ui.printline();
            }
        }
        io.writeAll(todo.getList());
    }


}
