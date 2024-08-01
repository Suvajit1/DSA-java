class LinkedList {
    static class Node {
        int data;
        Node next;

        public Node(int d) {
            this.data = d;
            this.next = null;
        }

    }

    public Node head = null;
    public Node tail = null;
    int size = 0;

    public void addfirst(int d) {
        Node newNode = new Node(d);
        size++;

        if (head == null) {
            head = tail = newNode;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(int d) {
        Node newNode = new Node(d);
        size++;

        if (head == null) {
            head = tail = newNode;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void printElement() {
        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }

        System.out.print("null");
        System.out.println();
    }

    public void add(int idx, int d) {
        if (idx == 0) {
            addfirst(d);
            return;
        }

        Node newnNode = new Node(d);
        size++;

        Node curr = head;
        for (int i = 0; i < idx - 1; i++) {
            curr = curr.next;
        }

        newnNode.next = curr.next;
        curr.next = newnNode;
    }

    public int removeFirst() {
        if (size == 0) {
            return Integer.MIN_VALUE;
        }

        int val = head.data;
        if (size == 1) {
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

    public int removeLast() {
        if (size == 0) {
            return Integer.MIN_VALUE;
        }

        int val = tail.data;

        if (size == 1) {
            head = tail = null;
            size = 0;
            return val;
        }

        Node curr = head;
        for (int i = 0; i < size - 2; i++) {
            curr = curr.next;
        }

        tail = curr;
        curr.next = null;
        size--;

        return val;
    }

    public boolean search(int key) {
        Node curr = head;
        int idx = 0;
        while (curr != null) {
            if (curr.data == key) {
                System.out.println("key present is at idx = " + idx);
                return true;
            }
            curr = curr.next;
            idx++;
        }

        return false;
    }

    public int searchRecursive(int key, Node head, int idx) {
        if (head == null) {
            return -1;
        }

        if (key == head.data) {
            return idx;
        }

        return searchRecursive(key, head.next, idx + 1);
    }

    public void reverse() {
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
    public int removeFromLastIndex(int n) {
        if (n > size) {
            return Integer.MIN_VALUE;
        }
        if (n == size) {
            return removeFirst();
        }

        Node curr = head;

        for (int i = 0; i < size - n - 1; i++) {
            curr = curr.next;
        }

        Node temp = curr.next;
        curr.next = temp.next;
        temp.next = null;
        size--;

        return temp.data;
    }

    // check a ll is pellindrom or not
    public Node getMid() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public boolean isPallindram() {
        if (head == null || head.next == null) {
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
            if (left.data == right.data) {
                left = left.next;
                right = right.next;
            } else {
                return false;
            }
        }

        return true;
    }

    // Floid Cycle finding Algo
    // sow fast approach
    public boolean detectCycle(){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public void makeCycle(){
        tail.next = head.next.next;
        tail = null;
    }

    // remove cycle from linked list
    public void removeCycle(){
        // step 1 check there is any cycle or not
        Node slow = head;
        Node fast = head;
        boolean cycle = false; 

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                cycle = true;
                break;
            }
        }

        if(cycle == false){
            return;
        }

        // find meating point
        Node prev = null;
        slow = head;

        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next; 
        }

        prev.next = null;
        tail = prev;
    }

    // merge Sort

    // merge mid
    public Node midNode(Node head){
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node leftH = head;
        Node mid = midNode(head);
        Node rightH = mid.next;
        mid.next = null;

        Node newLeftHead = mergeSort(leftH);
        Node newRightHead = mergeSort(rightH);

        return merge(newLeftHead, newRightHead);
    }

    public Node merge(Node leftH, Node rightH){

        Node mergeLL = new Node(-1); // head of merge ll
        Node temp = mergeLL;

        while (leftH != null && rightH != null) {
            if(leftH.data < rightH.data){
                temp.next = leftH;
                leftH = leftH.next;
                temp = temp.next;
            }else{
                temp.next = rightH;
                rightH = rightH.next;
                temp = temp.next;
            }
        }

        if(leftH != null){
            temp.next = leftH;
        }

        if(rightH != null){
            temp.next = rightH;
        }

        Node mHead = mergeLL.next;
        mergeLL.next = null;

        return mHead;
    }

    // zig zag Linked List
    public void zigZagLinkedList(){
        Node mid = midNode(this.head);
        reverseRightHalf(mid.next);
        mid.next = null;

        Node leftHead = head;
        Node rightHead = tail;

        while (leftHead != null && rightHead != null) {
            Node nextLeftHead = leftHead.next;
            Node nextRightHead = rightHead.next;

            leftHead.next = rightHead;
            rightHead.next = nextLeftHead;

            leftHead = nextLeftHead;
            rightHead = nextRightHead;
        }

    }

    public void reverseRightHalf(Node right){

        Node prev = null;
        Node curr = right;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
}

public class TopicLL2 {
    
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(0);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);
        ll.addLast(8);

        System.out.println(ll.detectCycle());

        ll.makeCycle();
        System.out.println(ll.detectCycle());

        // ll.printElement();
        ll.removeCycle();
        ll.printElement();

        LinkedList ll1 = new LinkedList();
        ll1.addLast(11);
        ll1.addLast(9);
        ll1.addLast(8);
        ll1.addLast(5);
        ll1.addLast(3);

        ll1.printElement();
        ll1.head = ll1.mergeSort(ll1.head);
        ll1.printElement();

        ll.printElement();
        ll.add(1, 1);
        ll.printElement();
        ll.zigZagLinkedList();
        ll.printElement();

    }
}
