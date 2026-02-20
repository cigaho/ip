package freddy.tasklist;

import java.util.ArrayList;
import freddy.task.Task;

public class Tasklist {
    private ArrayList<Task> todo = new ArrayList<Task>();
    private int size;

    public Tasklist(){
        size = 0;
    }
    public void update(ArrayList<Task> td){
        if (!td.isEmpty()){
            todo = td;
        }
        size = todo.size();
    }

    public void clear(){
        todo = new ArrayList<Task>();
    }

    public ArrayList<Task> getList(){
        return todo;
    }

    public Task get(int i){
        return todo.get(i);
    }

    public int getSize(){
        return size;
    }

    public void addElement(Task s){
        todo.add(s);
        size++;
    }

    public void removeIndex(int i){
        todo.remove(i);
        size-=1;
    }
}
