// creating a graph
// neighbours of a vertex 
// BFS
// DFS
import java.util.*;
public class Topic1 {

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
    public static void bfs(ArrayList<Edge>[] graph){    // O(v+2e)
        Queue<Integer> q = new LinkedList<>();
        boolean visit[] = new boolean[graph.length];    // initially all idx is initialised by false value
        // for(int i=0; i<visit.length; i++){
        //     visit[i]=false;
        // }

        q.add(0);
        while (!q.isEmpty()) {
            int curr = q.remove();

            if(!visit[curr]){ // not visited

                visit[curr]=true;
                // print
                System.out.print(curr+ " ");
                // add
                for(int i=0; i<graph[curr].size(); i++){
                    Edge e =graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean visit[]){ // O(v+2e)
        System.out.print(curr+" ");
        visit[curr]=true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visit[e.dest]){
                dfs(graph, e.dest, visit);
            }
        }
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
        ArrayList<Edge>[] graph = new ArrayList[v];
        creatGraph(graph);

        // neighbours of vertex 4
        for(int i=0; i<graph[4].size(); i++){
            Edge e = graph[4].get(i);
            System.out.println(e.dest);
        }

        bfs(graph);
        System.out.println();

        dfs(graph, 0, new boolean[graph.length]);
        System.out.println();
    }
}
