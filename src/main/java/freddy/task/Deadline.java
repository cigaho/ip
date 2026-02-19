package freddy.task;

public class Deadline extends Task {
    private String type = "[D]";
    private String date;
    //private String description;

    public Deadline(String description, String ddl){
        super(description,"[D]");
        date = ddl;
    }

    public Deadline(String description, String ddl, boolean done){
        super(description,"[D]",done);
        date = ddl;
    }

    public String get_detail(){
        String s = super.get_detail();
        return s+" (by: "+date+")";
    }

    public void print_detail(){
        System.out.println(get_detail());
    }

    public String write_detail(){
        String s = super.write_detail();
        String split = " | ";
        return s + split + date;
    }
}
