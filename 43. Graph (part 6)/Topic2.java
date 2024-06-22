// TARJAN'S ALGORITHM
// To find all bridge
// undirected graph

import java.util.ArrayList;

public class Topic2 {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void creatGraph(ArrayList<Edge>[] graph, int[][] edges){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<edges.length; i++){
            graph[edges[i][0]].add(new Edge(edges[i][0], edges[i][1]));
            graph[edges[i][1]].add(new Edge(edges[i][1], edges[i][0]));
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, boolean vis[], int par, int curr, int[] dt, int[] low, int time){
        vis[curr]=true;
        dt[curr] = low[curr] = ++time;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);

            if(!vis[e.dest]){
                dfs(graph, vis, curr, e.dest, dt, low, time);

                low[curr] = Math.min(low[curr], low[e.dest]);

                if(dt[curr]<low[e.dest]){
                    // bridge
                    System.out.println(curr+"-"+e.dest);
                }
            }
            if(vis[e.dest] && e.dest != par){
                low[curr] = Math.min(low[curr], dt[e.dest]);
                // low[curr] = Math.min(low[curr], low[e.dest]); --> we also can do this
            }
        }
    }

    // time complexity is that of dfs()
    // O(v+E)
    public static void tarjanBridge(ArrayList<Edge>[] graph, int V){
        int time=0;
        int dt[]= new int[V];
        int low[]= new int[V];

        boolean vis[] = new boolean[V];

        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                dfs(graph, vis, -1, i, dt, low, time);
            }
        }
    }
    public static void main(String[] args) {
        int V = 13;
        int[][] edges = {{0,1}, {1,2}, {1,4}, {2,3}, {3,4}, {4,5}, {5,6}, {6,7}, {6,9}, {7,8}, {8,9}, {8,10}, {10,11}, {10,12}, {11,12}};

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        creatGraph(graph, edges);

        tarjanBridge(graph, V);
    }
}
