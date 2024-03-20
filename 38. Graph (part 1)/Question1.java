// has path

import java.util.ArrayList;

public class Question1 {
    static class Edge{
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
            graph[i]= new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));

    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean vit[]){
        if(src==dest){
            return true;
        }

        vit[src]=true;

        // try to find path for its neighbor
        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            if(!vit[e.dest] && hasPath(graph, e.dest, dest, vit)){
                return true;
            }
        }

        return false;
    }

    public static boolean hasPath2(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis){
        if(src==dest){
            return true;
        }
        // System.out.println(src);
        vis[src]=true;
        for(int i=0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            
            if(!vis[e.dest]){
                if(hasPath2(graph, e.dest, dest, vis))
                    return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
          /*
         *      1 --- 3
         *     /      | \
         *    0       |  5 -- 6
         *     \      | /
         *      2 --- 4
         */

        int v = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];
        creatGraph(graph);

        boolean ans;
        ans = hasPath2(graph, 0, 5, new boolean[v]);
        System.out.println(ans);
        
        ans = hasPath2(graph, 0, 7, new boolean[v]);
        System.out.println(ans);


    }
}
