class Node{
    int data;
    Node next;

    public Node(int data){
        this.data=data;
        next=null;
    }
}

class Queue{
    Node front=null;
    Node rear=null;

    public boolean isEmpty(){
        return front==null && rear==null;
    }

    // add
    public void enQueue(int data){
        Node newNode=new Node(data);
        
        if(isEmpty()){
            front=rear=newNode;
            return;
        }
        rear.next=newNode;
        rear=newNode;
    }

    // remove
    public int deQueue(){
        if(this.isEmpty()){
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        Node temp=front;
        // single el
        if(rear==front){
            rear= null;
        }
        front=front.next;
        temp.next=null;
        return temp.data;
    }

    public int peak(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        return front.data;
    }
}
public class QueueUsingLL {
    public static void main(String[] args) {
        Queue q= new Queue();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);

        while(!q.isEmpty()){
            System.out.println(q.peak());
            q.deQueue();
        }
        System.out.println(q.isEmpty());
    }
}
