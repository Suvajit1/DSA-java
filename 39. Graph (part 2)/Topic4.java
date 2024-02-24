// undirected graph
// cycle detection

import java.util.ArrayList;

public class Topic4 {

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

        graph[0].add(new Edge(0, 1));

        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 3));
        graph[2].add(new Edge(2, 6));

        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 5));
        
        graph[6].add(new Edge(6, 4));

        graph[7].add(new Edge(7, 1));
        graph[7].add(new Edge(7, 8));

        graph[8].add(new Edge(8, 9));

        graph[9].add(new Edge(9, 7));
    }

    public static void dfs(ArrayList<Edge>[] graph){

        boolean vis[] = new boolean[graph.length];
        for(int i=0; i< vis.length; i++){
            if(!vis[i]){
                dfsUtil(graph,i,vis);
            }
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean vis[]){
        vis[curr]=true;
        System.out.print(curr+" ");

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);

            if(!vis[e.dest]){
                dfsUtil(graph, e.dest, vis);
            }
        }
    }
    public static void main(String[] args) {

        /*
                0 ----> 1 ----> 2 ----> 3 --> 4 ---> 5
                        ^       |             ^
                        |       |             |
                        |       -----> 6 ------ 
                        |
                        7 <------
                        |       |
                        |       |
                        V       |
                        8 ----> 9
         */         

        int v = 10;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];

        creatGraph(graph);
        dfs(graph);
        System.out.println();
    }
}
