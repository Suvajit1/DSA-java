// Implements a Queue using two Stacks
import java.util.Stack;

class Queue{
    Stack<Integer> s1=new Stack<>();
    Stack<Integer> s2=new Stack<>();

    public boolean isEmpty(){
        return s1.isEmpty();
    }
    
    //add - O(n)
    public void add(int data){
    
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }

        s1.push(data);

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    // remove - O(1)
    public int remove(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        return s1.pop();
    }

    // peak - O(1)
    public int peak(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        return s1.peek();
    }
}
public class Question2 {
    public static void main(String[] args) {
        Queue q=new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()){
            System.out.println(q.peak());
            q.remove();
        }

        // System.out.println(q.peak());
    }
}
