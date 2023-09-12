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

    // using loop
    public void pushBottom(int data){
        Node newNode= new Node(data);

        if(isEmpty()){
            head=newNode;
            return; 
        }

        Node temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        
        temp.next=newNode;
    }

    // using recursion
    public void pushBottomRecursion(int data){
        // base
        if(isEmpty()){
            push(data);
            return;
        }
        int top=pop();
        pushBottomRecursion(data);
        push(top);
    }

}


public class PushAtBottom{
    public static void main(String[] args) {
        Stack s= new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        // s.pushBottom(4);

        // while(!s.isEmpty()){
        //     System.out.println(s.peak());
        //     s.pop();
        // }

        s.pushBottomRecursion(4);

        while(!s.isEmpty()){
            System.out.println(s.peak());
            s.pop();
        }
    }
}
