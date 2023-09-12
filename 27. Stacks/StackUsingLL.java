class Node{
    int data;
    Node next;

    public Node(int data){
        this.data=data;
        this.next=null;
    }
}

class Stack{
    Node head = null;

    public boolean isEmpty(){
        return (head==null);
    }

    //push
    public void push(int data){
        Node temp=new Node(data);
        temp.next=head;
        head=temp;
    }

    //pop
    public int pop(){
        if(isEmpty()){
            return Integer.MIN_VALUE;
        }
        int top=head.data;
        head=head.next;
        return top;

    }

    //peak
    public int peak(){
        if(isEmpty()){
            return Integer.MIN_VALUE;
        }
        return head.data;
    }
}
public class StackUsingLL {
    public static void main(String[] args) {
        Stack s= new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        // while(!s.isEmpty()){
        //     System.out.println(s.peak());
        //     s.pop();
        // }

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());

    }
}
