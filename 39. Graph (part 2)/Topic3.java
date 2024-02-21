// Bi-partite graph or not

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Topic3 {

    static class Edge {
        int src;
        int dest;
        
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void creatGraph(ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){
            graph[i]= new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 1));
        // graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        // graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
    }

    // time O(v+e)
    // space O(v)
    public static boolean isBipartite(ArrayList<Edge>[] graph){
        int col[] = new int[graph.length];

        for(int i=0; i<col.length; i++){
            col[i]=-1;
        }

        for(int i=0; i<col.length; i++){
            if(col[i]==-1){
                if(isBipartiteUtil(graph, col, i)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isBipartiteUtil(ArrayList<Edge>[] graph, int col[], int vertex){
        col[vertex]=0;
        Queue<Integer> q = new LinkedList<>();
        q.add(vertex);

        while (!q.isEmpty()) {
            int curr = q.remove();
            for(int i=0; i<graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                // case 1
                if(col[e.dest] != -1 && col[e.dest] == col[vertex]){
                    return false;
                }
                // case 2 --> has color but diff --> then continue

                // case 3
                else if(col[e.dest]== -1){
                    col[e.dest]=(col[vertex]+1)%2;
                    q.add(e.dest);
                }
            }   
        }

        return true ;
    }
    public static void main(String[] args) {
        /*
                0-----3           
              /       |
            1         |
              \       |
                2---- 4
         */

        int v = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];
        creatGraph(graph);

        System.out.println(isBipartite(graph));
    }
}
