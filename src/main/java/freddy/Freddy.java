package freddy;

import freddy.exception.FreddyException;
import freddy.storage.Storage;
import freddy.ui.UI;
import freddy.tasklist.Tasklist;

/**
 * The main program of the app
 */
public class Freddy {

    /**
     * Standard template for reply
     */
    public static final String reply = "Freddy: ";


    private Storage io;
    private UI ui;

    /**
     * create a tasklist for task handling
     */
    public static Tasklist todo = new Tasklist();

    /**
     * Creates a new freddy instance
     */
    public Freddy(){
        io = new Storage();
        ui = new UI();
    }

    /**
     * get the IO instance to read/write data file
     * @return a Storage instance
     */
    public Storage getIO(){
        return io;
    }

    /**
     * get the UI instance to interact with user
     * @return a UI instance
     */
    public UI getUI(){
        return ui;
    }


    /**
     *  Main function of program, maintain the flow of app
     */
    public static void main(String[] args) {
        Freddy freddy = new Freddy();
        freddy.ui.greet();
        freddy.todo.update(freddy.io.readAll());
        while (true){
            try{
                if (freddy.ui.respond(freddy).equals("bye")){
                    freddy.ui.bye();
                    break;
                }
            }catch (FreddyException e){
                System.out.println(e.getMessage());
                freddy.ui.printline();
            }
        }
        freddy.io.writeAll(freddy.todo.getList());
    }
}
