package freddy.task;

import freddy.task.Task;

/**
 * class todo records task
 */
public class Todo extends Task {
    private final String type = "[T]";

    /**
     * creates todo instance
     * @param description, description of data
     */
    public Todo(String description){
        super(description,"[T]");
    }

    /**
     * creates todo instance specifying is done
     * @param description, description of task
     * @param done, is done
     */
    public Todo(String description, boolean isDone){super(description, "[T]", isDone);}
}
