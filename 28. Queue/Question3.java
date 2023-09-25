// Stack using Two Queue
import java.util.Queue;
import java.util.*;

class Stack{
    Queue<Integer> q1= new LinkedList<>();
    Queue<Integer> q2= new LinkedList<>();

    public boolean isEmpty(){
        return q1.isEmpty() && q2.isEmpty();
    }

    // push - O(1)
    public void push(int data){
        if(! q1.isEmpty()){
            q1.add(data);
        }else{
            q2.add(data);
        }
    }

    // pop - O(n)
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        }

        int top=-1;
        // case 1
        if(!q1.isEmpty()){
            while (! q1.isEmpty()) {
                top =q1.remove();
                if(q1.isEmpty()){
                    break;
                }
                q2.add(top);
            }
        }else{  // case 2
            while(!q2.isEmpty()){
                top=q2.remove();
                if(q2.isEmpty()){
                    break;
                }
                q1.add(top);
            }
        }

        return top;
    }

    // peak - O(n)
    public int peak(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return Integer.MIN_VALUE;
        }
        
        int top =-1;
        if(! q1.isEmpty()){
            while(!q1.isEmpty()){
                top= q1.remove();
                q2.add(top);
            }
        }else{
            while (!q2.isEmpty()) {
                top = q2.remove();
                q1.add(top);
            }
        }

        return top;
    }
}
public class Question3 {
    public static void main(String[] args) {
        Stack s= new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty()){
            System.out.println(s.peak());
            s.pop();
        }

        System.out.println(s.peak());
    }
}
