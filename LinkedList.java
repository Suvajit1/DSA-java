// Day 25
public class LinkedList {

    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    // public static Node head;
    // public static Node tail;

    public Node head;
    public Node tail;
    public int size=0;
    
    public void addFirst(int data){     // O(1)

        // step 1 creat a new node
        Node newNode=new Node(data);
        size++;
        
        // for empty LL
        if(head==null){
            head=tail=newNode;
            return;
        }

        // spet 2 newNode next = head
        newNode.next=head;  // linking

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
    public static void main(String[] args) {
        LinkedList ll=new LinkedList();
        //ll.printList();
        ll.addFirst(2);
        //ll.printList();
        ll.addFirst(1);
        ll.printList();
        ll.addLast(3);
        //ll.printList();
        ll.addLast(4);
        ll.printList();

        ll.add(2, 9);
        ll.printList();
        System.out.println(ll.size);

        System.out.println(ll.removeFirst());
        // System.out.println(ll.removeFirst());
        // System.out.println(ll.removeFirst());
        // System.out.println(ll.removeFirst());
        // System.out.println(ll.removeFirst());
        // System.out.println(ll.removeFirst());
        // System.out.println(ll.removeFirst());

        ll.printList();
        System.out.println(ll.size);

        System.out.println(ll.removeLast());
        ll.printList();
        System.out.println(ll.size);

        System.out.println(ll.remove(1));
        ll.printList();
        System.out.println(ll.size);

        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
        ll.printList();
        System.out.println(ll.size);

        System.out.println(ll.searchIterative(3));
        System.out.println(ll.searchIterative(10));

        System.out.println(ll.searchRecursion(3, ll.head, 0));
        System.out.println(ll.searchRecursion(10, ll.head, 0));

        ll.reversePrinting(ll.head);


    }
}
