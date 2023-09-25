class CircularQueue {
    private int arr[];
    int size;
    int rear;
    int front;

    CircularQueue(int n) {
        arr = new int[n];
        size = n;
        rear = -1;
        front=-1;
    }

    public boolean isEmpty() {
        return rear == -1 && front == -1;
    }

    public boolean isFull(){
        return (rear+1)%size==front;
    }
    // enque
    public void add(int data) {
        if (isFull()){
            System.out.println("Queue is full");
            return;
        }

        if(front==-1){
            front=0;
        }
        rear = (rear + 1)%size;
        arr[rear] = data;
    }

    // dequeue
    public int remove() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return Integer.MIN_VALUE;
        }

        int data=arr[front];
        
        // last el delete
        if(front==rear){
            front=-1;
            rear=-1;
        }else{
            front=(front+1)%size;
        }
        return data;
    }

    // peek
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return Integer.MIN_VALUE;
        }
        return arr[front];
    }
}

public class CircularQueqeUsingArray {
    public static void main(String[] args) {
        CircularQueue q= new CircularQueue(3);

        q.add(1);
        q.add(2);
        q.add(3);

        q.remove();
        q.remove();
        q.remove();
        q.add(4);
        q.add(5);

        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
        System.out.println(q.remove());

    }
}
