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

    public void removeFirst(){
        if(size==0 || size==1){
            head=tail=null;
            return;
        }

        Node temp= head.next;
        head.next=null;
        temp.prev=null;
        head=temp;
        size--;
    }

    public void printtDDL(){
        Node temp=head;
        while(temp != null){
            if(temp.next==null){
                System.out.print(temp.data);
            }else{
                System.out.print(temp.data+"<->");
            }
            temp=temp.next;
        }
        System.out.println();
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

        dll.removeFirst();
        dll.printtDDL();
        System.out.println(dll.head.data);
        System.out.println(dll.tail.data);

        dll.reverseDLL();
        dll.printtDDL();
        System.out.println(dll.head.data);
        System.out.println(dll.tail.data);
    }
}
