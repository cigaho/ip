package freddy.tasklist;

import java.util.ArrayList;
import freddy.task.Task;

/**
 * the Tasklist class is used to manage the tasks in todo list
 */
public class Tasklist {
    private ArrayList<Task> todos = new ArrayList<Task>();
    private int size;

    /**
     * create a new empty tasklist
     */
    public Tasklist(){
        size = 0;
    }

    /**
     * update current tasklist with recorded data
     * @param td, data read from file
     */
    public void update(ArrayList<Task> td){
        if (!td.isEmpty()){
            todos = td;
        }
        size = todos.size();
    }

    /**
     * Clean the app's data
     */
    public void clear(){
        todos = new ArrayList<Task>();
    }

    /**
     * get the current todo list
     * @return list of tasks
     */
    public ArrayList<Task> getList(){
        return todos;
    }

    /**
     * get specific task from list
     * @param i, the index of task
     * @return corresponding task
     */
    public Task get(int i){
        return todos.get(i);
    }

    /**
     * get the size of current tasks
     * @return size of list
     */
    public int getSize(){
        return size;
    }

    /**
     * add a task in list
     * @param s, new task to be added
     */
    public void addElement(Task s){
        todos.add(s);
        size++;
    }

    /**
     * remove certain task according to index
     * @param i, the index of task to be removed
     */
    public void removeIndex(int i){
        todos.remove(i);
        size-=1;
    }

    /**
     * find task according to keyword search
     * @param keyword, the user input keyword
     * @return list of tasks that contains keyword
     */
    public ArrayList<Task> find(String keyword){
        ArrayList<Task> temp = new ArrayList<>();
        for (Task t: todos){
            if (t.getDescription().contains(keyword)){
                temp.add(t);
            }
        }
        return temp;
    }
}
