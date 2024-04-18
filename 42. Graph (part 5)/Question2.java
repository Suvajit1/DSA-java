// Connectiong Cities with minimum cost 

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Question2 {
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

    public static void creatGraph(int cities[][], ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<cities.length; i++){
            for(int j=0; j<cities[i].length; j++){
                int c = cities[i][j];
                if(c > 0){
                    graph[i].add(new Edge(j, c));
                }
            }
        }
    }

    public static int connectCities(int cities[][]){
        int n = cities.length;

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[n];
        creatGraph(cities, graph);

        // Prime's Algo
        boolean vis[] = new boolean[n]; 
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0));

        int finalCost = 0;
        while (! pq.isEmpty()) {
            Edge curr = pq.remove();
            if(! vis[curr.dest]){
                vis[curr.dest] = true;
                finalCost+=curr.cost;

                for(int i=0; i<graph[curr.dest].size(); i++){
                    // neighbor
                    Edge e = graph[curr.dest].get(i);
                    pq.add(new Edge(e.dest, e.cost));
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
