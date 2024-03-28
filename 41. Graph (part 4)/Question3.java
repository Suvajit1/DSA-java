// Primes Algorithm
// minimum Spaning tree print the mst

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Question3 {
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

    public static void creatGraph(ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));

    }
    static class Triplet implements Comparable<Triplet> {
        int par;
        int v;
        int cost;
        
        public Triplet(int p, int v, int c){
            this.par = p;
            this.v = v;
            this.cost = c;
        }

        @Override
        public int compareTo(Triplet t2){
            return this.cost - t2.cost;
        }

        public String toString(){
            return "("+par+", "+v+", "+cost+")";
            
        }
    }

    static class Node{
        int v;
        int cost;
        
        public Node(int v, int c){
            this.v = v;
            this.cost = c;
        }
    }

    public static void prims(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Triplet> pq = new PriorityQueue<>();

        pq.add(new Triplet(-1, 0, 0));

        int finalCost = 0;
        ArrayList<Triplet> mst = new ArrayList<>();

        while(!pq.isEmpty()){
            Triplet curr = pq.remove();
            if(!vis[curr.v]){
                vis[curr.v] = true;
                finalCost += curr.cost;
                if(curr.par != -1){
                    mst.add(new Triplet(curr.par, curr.v, curr.cost));
                }
                // neighbor
                for(int i=0; i<graph[curr.v].size(); i++){
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Triplet(e.src, e.dest, e.wt));
                }
            }
        }

        System.out.println("Cost of mst = "+finalCost);
        System.out.println(mst);
    } 

    public static void main(String[] args) {
        /*
                 (0)
             10 / |  \15
               /  |   \
             (1)  |30  (2)
              \   |   /
             40\  |  /50
                 (3)
         */

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[4];
        creatGraph(graph);

        prims(graph);
    }    
}