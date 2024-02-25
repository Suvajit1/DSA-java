// topological sort

import java.util.ArrayList;
import java.util.Stack;

public class Topic5 {

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
            graph[i] = new ArrayList<>();
        }

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));
    }

    public static void topSort(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<vis.length; i++){
            if(!vis[i]){
                topSortUtil(graph, i, vis, s);
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop()+" ");
        }
        System.out.println();
    }

    public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> s){
        vis[curr] =true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topSortUtil(graph, e.dest, vis, s);
            }
        }

        s.push(curr);
    }


    public static void main(String[] args) {
        /*
                5 ------> 0 <------ 4 ----
                |                        |
                |                        |
                --> 2 ----> 3 -----> 1 <--
         */

        int v = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];

        creatGraph(graph);

        topSort(graph);
    }
}
