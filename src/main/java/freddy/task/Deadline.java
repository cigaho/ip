package freddy.task;

/**
 * class deadline extends task, it specific a by time
 */
public class Deadline extends Task {
    private String type = "[D]";
    private String date;
    //private String description;

    /**
     * create a deadline
     * @param description, description of deadline
     * @param ddl, due time
     */
    public Deadline(String description, String ddl){
        super(description,"[D]");
        date = ddl;
    }

    /**
     * create a deadline specifying if it's done
     * @param description, description of deadline
     * @param ddl, due time
     * @param isDone, true stands for finished
     */
    public Deadline(String description, String ddl, boolean isDone){
        super(description,"[D]",isDone);
        date = ddl;
    }

    /**
     * overwrite Task's get_detail
     * @return detail of deadline
     */
    public String get_detail(){
        String s = super.get_detail();
        return s+" (by: "+date+")";
    }

    /**
     * prints out detail of deadline
     */
    public void print_detail(){
        System.out.println(get_detail());
    }

    /**
     * write detail into storage file
     * @return detail content in String
     */
    public String write_detail(){
        String s = super.write_detail();
        String split = " | ";
        return s + split + date;
    }
}
