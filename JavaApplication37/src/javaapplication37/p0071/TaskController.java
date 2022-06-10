package j1.s.p0071;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class TaskController {

    private ArrayList<Task> list = new ArrayList<Task>();

    public ArrayList<Task> getList() {
        return list;
    }
 
    public int getLastTaskID(){
        if(list.isEmpty()){
            return 1;
        }
        int lastID = list.get(list.size() - 1).getID();
        int newID = lastID + 1;
        return newID;
    }
    
    public void addTask(int taskTypeID, String requirementName, Date date, float planFrom, float planTo, String assignee, String expert) {
        int newID = getLastTaskID();
        list.add(new Task(newID, taskTypeID, date, requirementName, assignee, planFrom, planTo, expert));
    }

    public void deleteTask(String ID) {
        boolean found = false;
        
        Iterator<Task> iterator = list.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (ID.equals(Integer.toString(task.getID()))) {
                found = true;
                iterator.remove();
                System.out.println("Task has been deleted!");
                break;
            }
        }
        
        if(!found){
            System.out.println("This ID does not exist!");
        }
    }
   
}
