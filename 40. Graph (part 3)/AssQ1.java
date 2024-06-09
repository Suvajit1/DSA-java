// cycle detecttion using bfa 

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AssQ1 {

    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    public static void creatGraph(ArrayList<Edge>[] graph, int[][] edgeList){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<edgeList.length; i++){
            int u = edgeList[i][0];
            int v = edgeList[i][1];

            graph[u].add(new Edge(u, v));
            graph[v].add(new Edge(v, u));
        }
    }

    static class Pair {
        int ver;
        int par;

        public Pair(int v, int p){
            this.ver = v;
            this.par = p;
        }
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];

        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                if(detectCycleUtil(graph, vis, i)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean[] vis, int src){
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(src, -1));
        vis[src] = true;

        while (!q.isEmpty()) {
            Pair curr = q.remove();
            int node = curr.ver;
            int par = curr.par;

            for(int i=0; i<graph[node].size(); i++){
                Edge e = graph[node].get(i);
                if(!vis[e.dest]){
                    vis[e.dest] = true;
                    q.add(new Pair(e.dest, node));
                }
                else if(par != e.dest){    // e.dest is already visited
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int edgeList[][] = {{0,1}, {0,2}, {1,4}, {2,3}, {2,5}, {4,6}, {5,6}};
        int V = 7;
        
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        creatGraph(graph, edgeList);

        System.out.println(detectCycleUtil(graph, new boolean[V], 0));
    }
}
