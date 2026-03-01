package freddy.task;

/**
 * class event extends class task
 * it specify duration of event
 */
public class Event extends Task {
    private final String type = "[E]";
    private String start;
    private String end;

    /**
     * create event instance with duration
     * @param description, description of event
     * @param start, start time of event
     * @param end, end time of event
     */
    public Event(String description, String start,String end){
        super(description,"[E]");
        this.start = start;
        this.end = end;
    }

    /**
     * create event instance with done parameter
     * @param description, description of event
     * @param start, start time
     * @param end, end time
     * @param done, is done
     */
    public Event(String description, String start,String end, boolean isDone){
        super(description,"[E]",isDone);
        this.start = start;
        this.end = end;
    }

    /**
     * get detail for written data
     * @return detail in String
     */
    public String write_detail(){
        String s = super.write_detail();
        String split = " | ";
        return s + split + start + split + end;
    }

    /**
     * get print detail
     * @return print detail in String
     */
    public String get_detail(){
        return super.get_detail()+" (from: "+start +" to: "+end+")";
    }

    /**
     * print out the detail for reference
     */
    public void print_detail(){
        System.out.println(get_detail());
    }
}
