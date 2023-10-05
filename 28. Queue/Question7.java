// implements Stack and Queue using Deque

import java.util.*;

class Stack{
    private Deque<Integer> d = new LinkedList<>();

    public void push(int data){
        d.addLast(data);
    }

    public int pop(){
        return d.removeLast();
    }

    public int peek(){
        return d.getLast();
    }

    public boolean isEmpty(){
        return d.isEmpty();
    }
}

class Queue{
    private Deque<Integer> d = new LinkedList<>();

    public void add(int data){
        d.addLast(data);
    }

    public int remove(){
        return d.removeFirst();
    }

    public int peek(){
        return d.getFirst();
    }

    public boolean isEmpty(){
        return d.isEmpty();
    }
}

public class Question7 {
    public static void main(String[] args) {
        Stack s= new Stack();
        s.push(1);                
        s.push(2);
        s.push(3);
        s.push(4);

        System.out.println("Stack : ");
        while(!s.isEmpty()){
            System.out.print(s.peek()+" ");
            s.pop();
        }

        Queue q= new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println("\nQueue : ");
        while(!q.isEmpty()){
            System.out.print(q.peek()+" ");
            q.remove();
        }

    }
}
