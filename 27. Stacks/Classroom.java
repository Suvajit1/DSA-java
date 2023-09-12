// implementation of stack using ArrayList
import java.util.ArrayList;

class Stack{
    private ArrayList<Integer> list=new ArrayList<>();

    public boolean isEmpty(){
        return list.size()==0;
    }

    // push
    public void push(int data){
        list.add(data);
    }

    //pop
    public int pop(){

        if(!isEmpty()){
            int top=list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }
        return Integer.MIN_VALUE;
    }

    //peak
    public int peak(){
        int top= list.get(list.size()-1);
        return top;
    }

    public int sizeOfStack(){
        return list.size();
    }
}
public class Classroom {
    public static void main(String[] args) {
        Stack s=new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        
        // System.out.println(s.pop());
        // System.out.println(s.pop());
        // System.out.println(s.pop());
        // System.out.println(s.pop());
        // System.out.println(s.pop());

        while(!s.isEmpty()){
            System.out.println(s.peak());
            s.pop();
        }

    }
}
