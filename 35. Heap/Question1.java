// Print nearest k Cars

import java.util.PriorityQueue;

public class Queestion1 {

    static class Car implements Comparable<Car> {
        int x,y,d;

        Car(int x, int y){
            this.x=x;
            this.y=y;

            d = x*x + y*y ;
        }

        @Override
        public int compareTo(Car c2){
            return this.d-c2.d;
        }
    }
    public static void main(String[] args) {
        int pts[][]={{3,3}, {5,-1},{-2,4}};
        int k= 2;

        PriorityQueue<Car> pq = new PriorityQueue<>();
        for(int i =0;i<pts.length; i++){
            pq.add(new Car(pts[i][0], pts[i][1]));
        }

        for(int i= 0 ;i<k;i++){
            System.out.println(pq.peek().x+","+pq.peek().y);
            pq.remove();
        }
    }
}
