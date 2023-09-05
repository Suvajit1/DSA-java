class DoubleLL{

    class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }

    Node head;
    Node tail;
    int size=0;

    public void addFirst(int data){
        Node temp = new Node(data);

        if(head==null){
            head=tail=temp;
            return;
        }
        head.prev=temp;
        temp.next=head;
        head=temp;
        size++;
    }

    public int removeFirst(){
        if(size==0){
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        }

        int val =head.data;

        if(size==1){
            head=tail=null;
            return val;
        }

        Node temp= head.next;
        head.next=null;
        temp.prev=null;
        head=temp;
        size--;

        return val;
    }

    public void printtDDL(){
        Node temp=head;
        while(temp != null){
            System.out.print(temp.data+"<->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public void reverseDLL(){
        Node prev=null;
        Node curr= head;
        Node next=null;

        while(curr != null){
            next=curr.next;

            curr.next=prev;
            curr.prev=next;

            prev=curr;
            curr=next;
        }

        Node temp=head;
        head=prev;
        tail=temp;
    }

}

public class Day26_DoublyLinkedList {
    public static void main(String[] args) {
        DoubleLL dll=new DoubleLL();
        dll.addFirst(4);
        dll.addFirst(3);        
        dll.addFirst(2);            
        dll.addFirst(1);
        dll.addFirst(0);

        dll.printtDDL();
        System.out.println(dll.head.data);
        System.out.println(dll.tail.data);

        System.out.println(dll.removeFirst());
        dll.printtDDL();
        System.out.println(dll.head.data);
        System.out.println(dll.tail.data);

        dll.reverseDLL();
        dll.printtDDL();
        System.out.println(dll.head.data);
        System.out.println(dll.tail.data);
    }
}
