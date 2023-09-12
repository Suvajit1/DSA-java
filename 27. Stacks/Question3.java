// reverse a stack 
import java.util.Stack;

public class Question3 {

    public static void pushAtBottom(int data, Stack<Integer> s){
        // base case
        if(s.isEmpty()){
            s.push(data);
            return;
        }

        int top = s.pop();
        pushAtBottom(data, s);
        s.push(top);
    }

    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }

        int top =s.pop();
        reverseStack(s);
        pushAtBottom(top, s);
    }
    public static void main(String[] args) {
        Stack<Integer> s=new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        // while(!s.isEmpty()){
        //     System.out.println(s.peek());
        //     s.pop();
        // }

        reverseStack(s);
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }

    }
}
