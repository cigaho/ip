public class Event extends Task{
    private final String type = "[E]";
    private String start;
    private String end;

    public Event(String description, String start,String end){
        super(description,"[E]");
        this.start = start;
        this.end = end;
    }

    public String get_detail(){
        return super.get_detail()+" (from: "+start +" to: "+end+")";
    }
    public void print_detail(){
        System.out.println(get_detail());
    }
}
