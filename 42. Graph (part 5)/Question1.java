// Cheapest path from src to dest with atmost k stops

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Question1 {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w){
            this.src = s; 
            this.dest = d;
            this.wt = w;
        }
    }
    public static void creatGraph(int n, int flights[][], ArrayList<Edge>[] graph){
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<flights.length; i++){
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            graph[src].add(new Edge(src, dest, wt));
        }
    }

    static class Info {
        int ver;
        int cost;
        int stops;
        

        public Info(int v, int c, int st){
            this.ver = v;
            this.cost = c;
            this.stops = st;
        }
    }

    public static int cheapestFlight(int n, int flights[][], int src, int dest, int k){
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[n];

        creatGraph(n, flights, graph);

        int dist[] = new int[n];
        for(int i=0; i<dist.length; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0)); 

        while (!q.isEmpty()) {
            Info curr = q.remove();

            if(curr.stops > k){
                break;
            }

            for(int i=0; i<graph[curr.ver].size(); i++){
                Edge e = graph[curr.ver].get(i);

                // int u = e.src;   // we dont need this for modified DK
                int v = e.dest;
                int wt = e.wt;

                //relaxation
                if(curr.cost + wt < dist[v]){
                    dist[v] = curr.cost + wt; // little changes
                    // add in queue
                    q.add(new Info(v, curr.cost + wt, curr.stops+1));
                }
            }
        }

        if(dist[dest] == Integer.MAX_VALUE){
            return -1;
        }else {
            return dist[dest];
        }

    }
    public static void main(String[] args) {
        int n = 6;
        // src, dest, cost
        int flights[][] = {{0,1,5}, {0,4,2}, {1,2,5}, {1,5,1}, {4,1,2}, {2,3,2}, {5,3,1}};

        int src = 0;
        int dest = 3;
        int k = 2;

        int cost = cheapestFlight(n, flights, src, dest, k) ;    
        System.out.println("Cost = "+cost);   
    }
}
