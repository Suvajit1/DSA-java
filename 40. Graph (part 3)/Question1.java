// leadcode 240 
// course schedule;

import java.util.*;
public class Question1 {
    static class Edge{
        int sc, dest;

        public Edge(int s, int d){
            this.sc = s;
            this.dest = d;
        }
    }

    public static void creatGraph(int[][] prerequisites, ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){
            graph[i]= new ArrayList<>();
        }

        for(int i=0;i<prerequisites.length;i++){
            graph[prerequisites[i][1]].add( new Edge(prerequisites[i][1], prerequisites[i][0]) );
        }
    }

    public static boolean containCycle(ArrayList<Edge>[] graph){

        boolean vis[] = new boolean[graph.length];
        boolean pathVis[] = new boolean[vis.length];

        for(int i=0; i<vis.length;i++){
            if(!vis[i]){
                if(containCycleUtil(graph, i, vis, pathVis)){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean containCycleUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, boolean pathVis[]){
        
        vis[curr]=true;
        pathVis[curr]=true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            // case1
            if(!vis[e.dest]){
                containCycleUtil(graph, e.dest, vis, pathVis);
            }
            // case2
            // path visited and e.dest = par --> so do nothing

            // case3
            // path visited but e.dest != par --> cycle exist
            if(pathVis[e.dest] == true && curr != e.dest){
                return true;
            }
        }

        pathVis[curr]=false;
        return false;
    }

    public static int[] findIndeg(ArrayList<Edge>[] graph){
        int indeg[] = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            for(int j=0; j<graph[i].size(); j++){
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
            
        }
        return indeg;
    }

    
    public static int[] findOrder(int numCourses, int[][] prerequisites, ArrayList<Edge>[] graph) {

        if(containCycle(graph)){
            int[] order = {};
            return order ;
        }

        // int indeg[] = findIndeg(graph);
        // int flag = 1;
        // for(int i=0;i<graph.length; i++){
        //     if(indeg[i]==0){
        //         flag =0;
        //     }
        // }
        // if(flag==1){
        //     int[] order = {};
        //     return order ;
        // }


        int[] order = new int[numCourses];

        Queue<Integer> q = new LinkedList<>();

        for(int i =0; i<graph.length; i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }

        int idx =0;
        while (!q.isEmpty()) {
            int curr =q.remove();
            order[idx] =curr;
            idx++;

            for(int i =0; i<graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if (indeg[e.dest]==0) {
                    q.add(e.dest);
                }
            }
        }

        return order;
    }
    public static void main(String[] args) {
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};

        int v = prerequisites.length;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];

        creatGraph(prerequisites, graph);

        int order[] = findOrder(v, prerequisites, graph);
        for(int i =0 ; i<order.length; i++){
            System.out.print(order[i]+" ");
        }

        System.out.println();
    }
}
