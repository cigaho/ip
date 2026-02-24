package freddy.task;

import freddy.Freddy;

public class Task {
    private String description;
    private String type;
    private boolean done = false;

    public Task(String description, String type){
        this.description = description;
        this.type = type;
    }

    public Task(String description){
        this.description = description;
        type = "[ ]";
    }

    public Task(String description, String type, boolean done){
        this.description = description;
        this.type = type;
        this.done = done;
    }

    public void check(){
        if (done){
            System.out.println(Freddy.reply+"Seems that it has already been checked!");
            return ;
        }
        done = true;
        System.out.println(Freddy.reply+"Sure, this task is checked for you");
        print_detail();
    }

    public void uncheck(){
        if (!done){
            System.out.println(Freddy.reply+"Seems that it hasn't been checked yet!");
            return ;
        }
        done = false;
        System.out.println(Freddy.reply+"OK, remember to do it later");
        print_detail();
    }

    public String get_detail(){
        String box = "[ ] ";
        if (done){
            box = "[X] ";
        }
        return type+box+description;
    }

    public void print_detail(){
        System.out.println(get_detail());
    }

    public String write_detail(){
        String split = " | ";
        String status = "0";
        if (done){
            status = "1";
        }
        return type.charAt(1)+split+status+split+description;
    }

    public String getDescription(){
        return description;
    }
}
