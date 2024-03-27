// bellman ford algorithem
import java.util.ArrayList;

public class Question1 {
    static class Edge {
        int src;
        int dest;
        int wt;
        
        public Edge(int s, int d, int w){
            this.src =s;
            this.dest =d;
            this.wt =w;
        }
    }

    public static ArrayList<Edge>[] creatGraph(int[][] g, int v){
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<g.length; i++){
            int vertex = g[i][0];
            graph[vertex].add(new Edge(g[i][0], g[i][1], g[i][2]));
        }

        return graph;
    }

    public static void bellmanFord(ArrayList<Edge>[] graph, int src){   // O(VE)
        int V = graph.length;
        int dist[] = new int[V];

        for(int i=0; i<V; i++){
            if(src != i){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        // O(V)
        for(int i=0; i<V-1; i++){
            // graph edges traversal O(E)
            for(int j=0; j<graph.length; j++){
                for(int k=0; k<graph[j].size(); k++){
                    Edge e = graph[j].get(k);

                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    // relaxation
                    if(dist[u] != Integer.MAX_VALUE && dist[u]+wt<dist[v]){
                        dist[v] = dist[u]+wt;
                    }
                }
            }
        }

        for(int i=0; i<dist.length; i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // src, dest, wt
        int g [][] = {{0,1,2}, {0,2,4}, {1,2,-4}, {2,3,2}, {3,4,4}, {4,1,-1}};

        ArrayList<Edge>[] graph = creatGraph(g,5);

        bellmanFord(graph, 0);
    }  
}
