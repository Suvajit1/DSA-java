// reverse a Queue

import java.util.*;
import java.util.Queue;
import java.util.Stack;

public class Question6 {

    public static void reverse(Queue<Integer> org){
        Stack<Integer> temp= new Stack<>();
        while(! org.isEmpty()){
            temp.push(org.remove());
        }
        while(!temp.isEmpty()){
            org.add(temp.pop());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> org = new LinkedList<>();
        
        org.add(1);
        org.add(2);
        org.add(3);
        org.add(4);
        org.add(5);

        reverse(org);
        System.out.println(org);
        while(! org.isEmpty()){
            System.out.println(org.remove());
        }

    }
}
