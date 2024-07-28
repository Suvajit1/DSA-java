public class LinkedList{
    static class Node{
        int data;
        Node next;

        public Node(int d){
            this.data = d;
            this.next = null;
        }
    }

    static Node head = null;
    static Node tail = null;
    static int size = 0;
    
    public void addfirst(int d){
        Node newNode = new Node(d);
        size++;

        if(head == null){
            head = tail = newNode;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(int d){
        Node newNode = new Node(d);
        size++;

        if(head == null){
            head = tail = newNode;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void printElement(){
        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data+"->");
            curr = curr.next;
        }

        System.out.print("null");
        System.out.println();
    }

    public void add(int idx, int d){
        if(idx == 0){
            addfirst(d);
            return;
        }

        Node newnNode = new Node(d);
        size++; 

        Node curr = head;
        for(int i=0; i<idx-1; i++){
            curr = curr.next;
        }

        newnNode.next = curr.next;
        curr.next = newnNode;
    }

    public int removeFirst(){
        if(size == 0){
            return Integer.MIN_VALUE;
        }

        int val = head.data;
        if(size == 1){
            head = tail = null;
            size = 0;
            return val;
        }

        Node curr = head;
        head = head.next;

        curr.next = null;
        size--;

        return val;
    }

    public int removeLast(){
        if(size == 0){
            return Integer.MIN_VALUE;
        }
        
        int val = tail.data;

        if(size == 1){
            head = tail = null;
            size = 0;
            return val;
        }
        
        Node curr = head;
        for(int i=0; i<size-2; i++){
            curr = curr.next;
        }

        tail = curr;
        curr.next = null;
        size--;

        return val;
    }

    public boolean search(int key){
        Node curr = head;
        int  idx = 0;
        while(curr != null ){
            if(curr.data == key){
                System.out.println("key present is at idx = "+idx);
                return true;
            }
            curr = curr.next;
            idx++;
        }

        return false;
    }

    public int searchRecursive(int key, Node head, int idx){
        if(head == null){
            return -1;
        }

        if(key == head.data){
            return idx;
        }

        return searchRecursive(key, head.next, idx+1);
    }
    
    public void reverse(){
        Node prev = null, next = null;
        Node curr = head;
        Node temp = head;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = tail;
        tail = temp;
    }

    // find and remove nth node from last
    // that is (size-n)th idx form first
    public int removeFromLastIndex(int n){
        if(n>size){
            return Integer.MIN_VALUE;
        }
        if (n==size) {
            return removeFirst();
        }

        Node curr = head;

        for(int i=0; i<size-n-1; i++){
            curr = curr.next;
        }

        Node temp = curr.next;
        curr.next = temp.next;
        temp.next = null;
        size--;

        return temp.data;
    }

    // check a ll is pellindrom or not
    public Node getMid(){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public boolean isPallindram(){
        if(head == null || head.next == null){
            return true;
        }

        // step 1 : find mid node
        Node mid = getMid();

        // step 2 : reverse 2nd half
        Node perv = null;
        Node curr = mid;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = perv;
            perv = curr;
            curr = next;
        }

        // step 3 : check condtition
        Node left = head;
        Node right = perv;

        while (right != null) {
            if(left.data == right.data){
                left = left.next;
                right = right.next;
            }else{
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // LinkedList ll = new LinkedList();

        // ll.printElement();

        // ll.addfirst(1);
        // ll.addfirst(2);
        // ll.addLast(3);
        // ll.addLast(4);
        // ll.add(2, 5);
        // ll.add(0, 6);

        // ll.printElement();
        // System.out.println(size);

        // System.out.println(ll.removeFirst());
        // ll.printElement();
        // System.out.println(size);

        // ll.removeLast();
        // ll.printElement();
        // System.out.println(size);

        // ll.removeLast();
        // ll.printElement();
        // System.out.println(size);

        // ll.removeLast();
        // ll.printElement();
        // System.out.println(size);

        // ll.removeLast();
        // ll.printElement();
        // System.out.println(size);

        // System.out.println(ll.removeLast());
        // ll.printElement();
        // System.out.println(size);

        // System.out.println(ll.removeLast());
        // ll.printElement();
        // System.out.println(size);

        // System.out.println(ll.search(3));
        // System.out.println(ll.search(7));
        // System.out.println(ll.searchRecursive(3,head,0));
        // System.out.println(ll.searchRecursive(8,head,0));

        // ll.printElement();
        // ll.reverse();
        // ll.printElement();
        // // System.out.println(tail.data);
        // System.out.println(ll.removeFromLastIndex(2));
        // ll.printElement();
        // System.out.println(ll.removeFromLastIndex(size));
        // ll.printElement();
        // System.out.println(ll.removeFromLastIndex(10));
        // ll.printElement();


        LinkedList ll1 = new LinkedList();
        ll1.addLast(1);
        ll1.addLast(2);
        ll1.addLast(3);
        ll1.addLast(2);
        ll1.addLast(1);
        ll1.printElement();

        System.out.println(ll1.isPallindram());
        ll1.addLast(3);
        System.out.println(ll1.isPallindram());


    }
}