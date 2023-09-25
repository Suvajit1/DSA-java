// Interleave 2 half of Queue (even  Length)

import java.util.*;
import java.util.Queue;

public class Question5 {
    public static void interleave(Queue<Integer> org){
        int size =org.size();

        Queue<Integer> first = new LinkedList<>();
        for(int i=0;i<size/2; i++){
            first.add(org.remove());
        }

        while(!first.isEmpty()){
            org.add(first.remove());
            org.add(org.remove());
        }

    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        interleave(q);
        while (!q.isEmpty()) {
            System.out.print(q.remove()+" ");
        }
        System.out.println();
    }
}
