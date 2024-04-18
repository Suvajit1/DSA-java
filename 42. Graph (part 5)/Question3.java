// Connectiong Cities with minimum cost 
// way 2

import java.util.PriorityQueue;

public class Question3 {
    static class Edge implements Comparable<Edge> {
        int dest;
        int cost;

        public Edge(int d, int c){
            this.dest = d;
            this.cost = c;
        }

        @Override
        public int compareTo(Edge e2){
            return this.cost - e2.cost;
        }
    }

    public static int connectCities(int cities[][]){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0));

        int finalCost = 0;
        boolean vis[] = new boolean[cities.length];

        while (!pq.isEmpty()) {
            Edge curr = pq.remove();

            if(!vis[curr.dest]){
                vis[curr.dest] = true;

                finalCost+=curr.cost;

                for(int i=0; i<cities[curr.dest].length; i++){
                    // neighbor
                    if(cities[curr.dest][i] != 0){
                        pq.add(new Edge(i, cities[curr.dest][i]));
                    }
                }
            }
        }

        return finalCost;
    }
    public static void main(String[] args) {
        int cities[][] = { {0,1,2,3,4},
                           {1,0,5,0,7},
                           {2,5,0,6,0},
                           {3,0,6,0,0},
                           {4,7,0,0,0} };

        int cost = connectCities(cities);
        System.out.println(cost);
    }
}
