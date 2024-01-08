// comnnect n ropes and find min cost

import java.util.PriorityQueue;

public class Question2 {
    public static void main(String[] args) {
        int ropes[]= {2,3,3,4,6};

        PriorityQueue<Integer> pq =new PriorityQueue<>();
        for(int i=0;i<ropes.length;i++){
            pq.add(ropes[i]);
        }

        int cost =0;
        while (pq.size() > 1) {
            int rope=pq.remove()+pq.remove();
            pq.add(rope);
            cost=cost+rope;
        }
        System.out.println(cost);
    }
}
