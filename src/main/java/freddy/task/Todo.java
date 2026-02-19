package freddy.task;

import freddy.task.Task;

public class Todo extends Task {
    private final String type = "[T]";

    public String getType(){
        return type;
    }

    public Todo(String desciption){
        super(desciption,"[T]");
    }

    public Todo(String desciption, boolean done){super(desciption, "[T]", done);}
}
