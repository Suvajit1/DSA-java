class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;
    Node tail;
    int size = 0;

    public void addFirst(int data) { // O(1)

        // step 1 creat a new node
        Node newNode = new Node(data);
        size++;

        // for empty LL
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // spet 2 newNode next = head
        newNode.next = head; // linking

        // step 3
        head = newNode;
    }

    public void addLast(int data){  // O(1)
        Node newNode= new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }

    public void printList(){    // O(n)
        Node temp = head;
        if(head==null){
            System.out.println("Empty Linked List");
            return;
        }
        while(temp != null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public void add(int index, int data){
        if(index==0){
            addFirst(data);
            return;
        }

        Node newNode= new Node(data);
        size++;
        Node temp=head;
        int i=0;

        while(i<index-1){
            temp=temp.next;
            i++;
        }

        // i=index-1  temp->prev
        newNode.next=temp.next;
        temp.next=newNode;
    }

    public int removeFirst(){   // O(1)
        // empty LL size = 0
        if(head==null){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE ;
        }
        // LL with 1 node
        if(size==1){
            int val=head.data;
            head=tail=null;
            size--; // size=0
            return val;
        }

        Node temp=head;
        int val=head.data;
        head=head.next;
        temp.next=null; // temp is prev head
        size--;

        return val;
    }

    public int removeLast(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        if(size==1){
            int val= tail.data;
            head =tail =null;
            size=0;
            return val;
        }
        int val=tail.data;
        Node temp= head;
        for(int i=0; i<size-2; i++){
            temp=temp.next;
        }
        tail=temp;
        temp.next=null;
        size--;
        return val;
    }

    public int remove(int idx){     // O(n)
        if(idx==0){
            return removeFirst();
        }
        if(idx==size-1){
            return removeLast();
        }
        Node temp= head;
        for(int i=0;i<idx-1;i++){
            temp=temp.next;
        }
        Node targetNode=temp.next;
        int val= targetNode.data;

        temp.next=temp.next.next;

        targetNode.next=null;
        size--;
        return val;

    }

    public int searchIterative(int key){    // O(n)
        Node temp = head;
        int i=0;

        while(temp != null){
            if(temp.data==key){
                return i;
            }
            temp=temp.next;
            i++;
        }

        return -1;
    }

    public int searchRecursion(int key, Node head, int i){
        // base
        if(head==null){
            return -1;
        }
        // work
        if(head.data==key){
            return i;
        }
        // recursion
        return searchRecursion(key, head.next, i+1);
    }

    // printing in reverse order O(n)
    public void reversePrinting(Node head){
        if(head == null){
            return;
        }
        reversePrinting(head.next);
        System.out.print(head.data+" ");
    }

    public void reverseLinkedList(){    // O(n)
        Node prev=null, curr= head, next=null;

        while(curr != null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        tail=head;
        head=prev;
    }

    public int removeNthNodeFromLast(int N){
        return remove(size-N);
    }

    // slow fast approach
    public Node findMid(Node head){
        Node slow=head;
        Node fast=head;

        while( fast != null && fast.next != null ){
            slow=slow.next;     // +1
            fast=(fast.next).next; // +2
        }
        return slow;
    }

   public boolean checkPalindrome(){

        if(head==null || head.next == null){
            return true;
        }
        // step1 - find mid
        Node modNode= findMid(head);

        // step2 - reverse 2nd half
        Node prev = null;
        Node curr = modNode;
        Node next = null;

        while(curr != null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        Node right=prev;    // head of right half
        Node left = head;

        // step3 - check left half & right half
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }

        return true;
    }

    public void copyLL(LinkedList ll){
        this.head=ll.head;
        this.tail=ll.tail;
        this.size=ll.size;
    }

    public void makeCycle(int idx){
        Node temp= head;
        for(int i=0;i<idx;i++){
            temp=temp.next;
        }
        
        tail.next=temp;
    }

    // Floid's cycle finding algorithm
    public boolean checkCycle(){
        Node slow=head;
        Node fast= head;
        
        while (fast !=null && fast.next != null) {
            slow=slow.next;
            fast=fast.next.next;

            if(fast==slow){     // cycle exist
                return true;
            }
        }

        return false;   // cycle doesn't exist
    }

    public void removeCycle(){
        // check cycle
        Node slow=head;
        Node fast =head;
        int flag=0;

        while (fast != null && fast.next != null) {
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast){     // cycle present
                flag=1;
                break;
            }
        }

        if(flag==0){
            System.out.println("No Cycle present");
            return;
        }

        System.out.println("Cycle prestnt");

        // detect point of cycle creation
        slow=head;
        Node prev=null;
        while(slow != fast){
            prev=fast;
            slow=slow.next;
            fast=fast.next;
        }

        // break cycle
        prev.next=null;

        System.out.println("Cycle removed");
    }


    private Node getMid(Node head){
        Node slow=head;
        Node fast=head.next;

        while (fast != null && fast.next != null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    private Node merge( Node lHead, Node rHead){
        Node mergeLL = new Node(-1);
        Node temp =mergeLL;

        while(lHead != null && rHead != null){
            if(lHead.data < rHead.data){
                temp.next=lHead;
                lHead=lHead.next;
                temp=temp.next;
            }else{
                temp.next=rHead;
                rHead=rHead.next;
                temp=temp.next;
            }
        }

        if(lHead != null){
            temp.next=lHead;
        }
        if (rHead != null) {
            temp.next=rHead;
        }

        return mergeLL.next;
    }

    // merge sort
    public Node mergeSort(Node head){

        if(head==null || head.next==null){
            return head;
        }
        // find mid
        Node mid= getMid(head);
        // left & right MS
        Node rightHead =mid.next;
        mid.next=null;
        Node newLeftHead = mergeSort(head);
        Node newRightHead = mergeSort(rightHead);
        // merge
        return merge(newLeftHead,newRightHead);
    }

    // Zig-Zag Linked list
    // 1->2->3->4->5->6 --->  1->6->2->5->3->4
    public void zig_zagList(){
        Node lHead=head;
        Node mid =this.getMid(head);

        // reverse 2nd half
        Node prev=null;
        Node curr= mid.next;
        Node next = null;

        while(curr != null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        Node rHead= prev;
        mid.next=null;

        // zig-zag merge
        Node nextLH, nextRH, temp=lHead;
        while(lHead !=null && rHead != null){
            nextLH=lHead.next;
            nextRH=rHead.next;

            lHead.next=rHead;
            lHead=nextLH;
            rHead.next=lHead;
            rHead=nextRH;
        }
        this.head=temp;
    }
}

public class Day26_Linkedkist {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
        ll.add(2, 3);

        ll.printList();

        LinkedList ll2= new LinkedList();
        ll2.addFirst(1);
        ll2.addLast(2);
        ll2.addLast(3);
        ll2.addLast(2);
        ll2.addLast(1);

        System.out.println(ll2.checkPalindrome());
        ll2.printList();

        LinkedList ll1=new LinkedList();
        ll1.copyLL(ll);
        ll1.addLast(6);
        ll1.printList();
        ll.printList();
        System.out.println(ll1.size);        
        System.out.println(ll.size);

        LinkedList ll3 =new LinkedList();
        ll3.addLast(1);
        ll3.addLast(2);
        ll3.addLast(3);
        ll3.addLast(4);
        ll3.addLast(5);
        ll3.addLast(6);
        ll3.addLast(7);
        ll3.addLast(8);
        System.out.println(ll3.checkCycle());
        ll3.printList();    // 1->2->3->4->5->6->7->8
        ll3.makeCycle(2);
        System.out.println(ll3.checkCycle());
        // ll3.printList();  // 1->2->3->4->5->6->7->8->3->4->5->6->7->8->3->4->5->6->7->8->3->4->5->6->7->8->3->4->5-> ...

        ll3.removeCycle();
        ll3.printList();
        ll3.removeCycle();
        ll3.printList();

        LinkedList ll4= new LinkedList();
        ll4.addLast(3);
        ll4.addLast(1);
        ll4.addLast(11);
        ll4.addLast(7);
        ll4.addLast(5);
        ll4.addLast(10);

        ll4.printList();
        ll4.head= ll4.mergeSort(ll4.head);
        ll4.printList();
        System.out.println(ll4.tail.data);  // 10 tail is not getting updated

        LinkedList ll5=new LinkedList();
        ll5.addLast(1);
        ll5.addLast(2);
        ll5.addLast(3);
        ll5.addLast(4);
        ll5.addLast(5);
        ll5.addLast(6);        
        ll5.addLast(7);

        ll5.printList();
        ll5.zig_zagList();
        ll5.printList();

    }
}
