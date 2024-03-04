// All path form src to dest

import java.util.ArrayList;

public class Topic2 {
    static class Edge {
        int src, dest;
        
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void creatGraph(ArrayList<Edge>[] graph, int[][] arr){
        int v= graph.length;
        int e = arr.length;

        for(int i=0; i< v; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<e; i++){
            int s = arr[i][0];
            int d = arr[i][1];
            graph[s].add(new Edge(s, d));
        }

    }

    public static void allPath(ArrayList<Edge>[] graph, int src, int dest, String s){
        // boolean pathVis[] = new boolean[graph.length];
        // pathVis[src]=true;

        if(src == dest){
            System.out.println(s+src);
            return;
        }

        for(int i = 0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            String path = s+src;
            allPath(graph, e.dest, dest, path);
        }
        // pathVis[src]= false;
    }
    public static void main(String[] args) {
        int[][] arr = {{5,0}, {5,2}, {0,3}, {2,3}, {4,0}, {4,1}, {3,1}};

        int v = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];

        creatGraph(graph, arr);
        allPath(graph, 4, 1, "");
    }
}
