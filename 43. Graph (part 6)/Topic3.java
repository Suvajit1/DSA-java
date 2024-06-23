// Articulation Point
// TARJAN'S ALGORITHM

import java.util.ArrayList;

public class Topic3 {
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
            graph[edgeList[i][0]].add(new Edge(edgeList[i][0], edgeList[i][1]));
            graph[edgeList[i][1]].add(new Edge(edgeList[i][1], edgeList[i][0]));
        }
    }

    public static void APtarjan(ArrayList<Edge>[]graph, int V){
        boolean vis[] = new boolean[V];
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;

        // a modification
        boolean AP[] = new boolean[V];

        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfs(graph, vis, AP, i, -1, time, dt, low);
            }
        }

        for(int i=0; i<AP.length; i++){
            if(AP[i]){
                System.out.println("AP : "+i);
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, boolean vis[], boolean AP[], int curr, int par, int time, int[] dt, int[] low){
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;

        int children = 0;
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            int neigh = e.dest;

            if(neigh == par){
                continue;
            }else if(vis[neigh]){
                low[curr] = Math.min(low[curr], dt[neigh]);
            }else{
                // not visited - children
                dfs(graph, vis, AP, neigh, curr, time, dt, low);
                low[curr] = Math.min(low[curr], low[neigh]);

                // cond 2 and 3:
                if(par != -1 && dt[curr] <= low[neigh]){ // single edge (no backedge) + cucle
                    // System.out.println("AP : "+curr);
                    AP[curr] = true;
                }
                children++;
            }
        }
        // cond 1 :
        if(par == -1 && children>1){
            // System.out.println("AP : "+curr);
            AP[curr] = true;
        }
    }

    public static void main(String[] args) {
        int V1 = 7;
        int[][] edgeList1 = {{0,1}, {0,2}, {0,3}, {2,4}, {2,5}, {4,6}, {5,6}};
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph1 = new ArrayList[V1];
        creatGraph(graph1, edgeList1);

        int V2 = 5;
        int[][] edgeList2 = {{0,1}, {0,2}, {0,3}, {1,2}, {3,4}};
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph2 = new ArrayList[V1];
        creatGraph(graph2, edgeList2);

        int V3 = 5;
        int[][] edgeList3 = {{0,1}, {0,3}, {1,2}, {1,3}, {1,4}, {2,4}};
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph3 = new ArrayList[V1];
        creatGraph(graph3, edgeList3);

        System.out.println("Graph 1 -------");
        APtarjan(graph1, V1);

        System.out.println("Graph 2 -------");
        APtarjan(graph2, V2);

        System.out.println("Graph 3 -------");
        APtarjan(graph3, V3);

    }
}
