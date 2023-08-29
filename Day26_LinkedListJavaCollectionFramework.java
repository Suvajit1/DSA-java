import java.util.LinkedList;    // JCF

public class Day26_LinkedListJavaCollectionFramework {
    public static void main(String[] args) {
        // creat
        LinkedList<Integer> ll = new LinkedList<>();

        // add
        ll.addLast(1);
        ll.addLast(2);
        ll.add(0, 4);
        ll.addFirst(3);

        // print
        System.out.println(ll);

        // remove
        ll.removeLast();
        ll.removeFirst();        
        System.out.println(ll);

    }    
}
