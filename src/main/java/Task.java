public class Task {
    private String description;
    private boolean done = false;

    public Task(String description){
        this.description = description;
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
        return box+description;
    }

    private void print_detail(){
        System.out.println(get_detail());
    }
}
