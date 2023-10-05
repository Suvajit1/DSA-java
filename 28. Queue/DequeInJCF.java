// Deque

// import java.util.*;

import java.util.Deque;
import java.util.LinkedList;

public class DequeInJCF {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();

        deque.addFirst(1);
        deque.addFirst(2);

        System.out.println(deque); // 2 1

        deque.removeFirst();
        System.out.println(deque); // 1

        deque.addLast(3);
        deque.addLast(4);
        System.out.println(deque); // 1 3 4

        deque.removeLast();
        System.out.println(deque); // 1 3

        System.out.println(deque.getFirst()); // 1
        System.out.println(deque.getLast()); // 3

    }
}
