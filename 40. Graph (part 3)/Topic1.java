import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Topic1 {

    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void creatGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));
    }

    public static void calInDeg(ArrayList<Edge>[] graph, int[] inDeg){
        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].size(); j++){
                Edge e = graph[i].get(j);
                inDeg[e.dest]++;
            }
        }
    }

    public static void topSortBFS(ArrayList<Edge>[] graph){
        int inDeg[] = new int[graph.length];
        calInDeg(graph, inDeg);

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<graph.length; i++){
            if(inDeg[i]==0){
                q.add(i);
            }
        }

        // BFS
        while(!q.isEmpty()){
            int curr=q.remove();
            System.out.print(curr+" ");

            for(int i=0; i<graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                inDeg[e.dest]--;
                if(inDeg[e.dest]==0){
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        /*
            5 ------> 0 <------ 4 ----
            |                         |
            |                         |
            --> 2 ----> 3 -----> 1 <--
         */

        int v = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];

        creatGraph(graph);
        topSortBFS(graph);
        System.out.println();
    }
}