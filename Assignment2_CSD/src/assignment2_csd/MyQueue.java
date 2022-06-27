
package assignment2_csd;

import java.util.LinkedList;

public class MyQueue {
    LinkedList<Object> head;
    
    public MyQueue(){
        head = new LinkedList<>();
    }
    
    public boolean isEmpty(){
        return head.isEmpty();
    }
    
    public void clear(){
        head = null;
    }
    
    public void enqueue(Object obj){
        head.addLast(obj);
    }
    
    public Object dequeue(){
        if(isEmpty()) return null;
        return head.removeFirst();
    }
    
    public Object front(){
        if(isEmpty()) return null;
        return head.getFirst();
    }
}
