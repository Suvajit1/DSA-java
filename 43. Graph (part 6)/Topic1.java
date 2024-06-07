// Strongly Connected Component
// Kosaraju's Algorithm

// Approach
// 1. topo sort using Stack
// 2. reverse the graph
// 3. do dfs by poping out elements from stack on the reverse graph

import java.util.ArrayList;
import java.util.Stack;

public class Topic1 {
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

        for(int i = 0; i<edgeList.length; i++){
            int src = edgeList[i][0];
            int dest = edgeList[i][1];

            graph[src].add(new Edge(src, dest));
        }
    }

    public static void topoSort(ArrayList<Edge>[] graph, Stack<Integer> st, boolean vis[], int ver){
        vis[ver] = true;

        for(int i=0; i<graph[ver].size(); i++){
            Edge e = graph[ver].get(i);
            if(!vis[e.dest]){
                topoSort(graph, st, vis, e.dest);
            }
        }
        st.push(ver);
    }

    public static void kosarajuSCCs(ArrayList<Edge>[] graph){
        // step 1
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                topoSort(graph, st, vis, i);
            }
        }

        // step 2
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] transpose = new ArrayList[graph.length];

        for(int i=0; i<transpose.length; i++){
            transpose[i] = new ArrayList<>();
        }

        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].size(); j++){
                Edge e = graph[i].get(j);

                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        // step 3
        int scc = 0;
        boolean tvis[] = new boolean[transpose.length];

        while (!st.isEmpty()) {
            int curr = st.pop();
            if(!tvis[curr]){
                dfs(transpose, tvis, curr);
                scc++;
                System.out.println();
            }
        }

        System.out.println("Total no. of scc(s) is/are : "+scc);
    }

    public static void dfs(ArrayList<Edge>[] transpose, boolean tvis[], int ver){
        tvis[ver] = true;
        System.out.print(ver+" ");

        for(int i=0; i<transpose[ver].size(); i++){
            Edge e = transpose[ver].get(i);
            if(!tvis[e.dest]){
                dfs(transpose, tvis, e.dest);
            }
        }
    }

    public static void main(String[] args) {
        /*
                (0)<----(2)---->(3)---->(4)--->(7)
                 |      ^                | ~   ^
                 |      |                |  \  |
                 v      |                V   \ |
                (1)------               (5)-->(6)
         */

        int v = 8;
        int[][] edgeList = {{0,1}, {1,2}, {2,0}, {2,3}, {3,4}, {4,5}, {4,7}, {5,6}, {6,4}, {6,7}};

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];
        creatGraph(graph, edgeList);
        
        kosarajuSCCs(graph);
    }
}