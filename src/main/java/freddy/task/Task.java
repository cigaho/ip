package freddy.task;

import freddy.Freddy;

/**
 * the parent class of all tasks
 */
public class Task {
    private String description;
    private String type;
    private boolean isDone = false;

    /**
     * Create a task instance based on description and type
     * @param description, the content of task
     * @param type, represented by d, t, e
     */
    public Task(String description, String type){
        this.description = description;
        this.type = type;
    }

    /**
     * Create a task instance without specify type
     * @param description, the content of task
     */
    public Task(String description){
        this.description = description;
        type = "[ ]";
    }

    /**
     * Create task instance including type and status
     * @param description, content of task
     * @param type, type of task
     * @param isDone, true if it is done
     */
    public Task(String description, String type, boolean done){
        this.description = description;
        this.type = type;
        this.isDone = done;
    }

    /**
     * Set the task's status to done
     */
    public void check(){
        if (isDone){
            System.out.println(Freddy.reply+"Seems that it has already been checked!");
            return ;
        }
        isDone = true;
        System.out.println(Freddy.reply+"Sure, this task is checked for you");
        print_detail();
    }

    /**
     * Set the task's status to not done
     */
    public void uncheck(){
        if (!isDone){
            System.out.println(Freddy.reply+"Seems that it hasn't been checked yet!");
            return ;
        }
        isDone = false;
        System.out.println(Freddy.reply+"OK, remember to do it later");
        print_detail();
    }

    /**
     * Get the detail of task
     * @return detail of task in String
     */
    public String get_detail(){
        String box = "[ ] ";
        if (isDone){
            box = "[X] ";
        }
        return type+box+description;
    }

    /**
     * function used to print detail
     */
    public void print_detail(){
        System.out.println(get_detail());
    }

    /**
     * convert all tasks into Strings for written data
     * @return converted string
     */
    public String write_detail(){
        String split = " | ";
        String status = "0";
        if (isDone){
            status = "1";
        }
        return type.charAt(1)+split+status+split+description;
    }

    /**
     * obtain description of task
     * @return description in String
     */
    public String getDescription(){
        return description;
    }
}
