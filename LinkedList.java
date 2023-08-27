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

    }
}
