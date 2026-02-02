public class Deadline extends Task{
    private String type = "[D]";
    private String date;
    //private String description;

    public Deadline(String description, String ddl){
        super(description,"[D]");
        date = ddl;
    }

    public String get_detail(){
        String s = super.get_detail();
        return s+" (by: "+date+")";
    }

    public void print_detail(){
        System.out.println(get_detail());
    }
}
