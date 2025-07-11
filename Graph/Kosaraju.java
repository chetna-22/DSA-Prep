package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class Kosaraju {
    static class Edge{
        int src;
        int dest;
        

        public Edge(int src,int dest){
            this.src = src;
            this.dest = dest;
           
        }
    }
    public static void topSort(ArrayList<Edge>graph[],int v,int curr,boolean[] vis,Stack<Integer> st){
        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topSort(graph, v, e.dest, vis, null);
            }
        }
        st.push(curr);
    } 
    public static void dfs(int current,ArrayList<Edge>graph[],boolean[] vis){
        vis[current] = true;
        System.out.print(current+" ");

        for(int i=0;i<graph[current].size();i++){
            Edge e = graph[current].get(i);
            if(!vis[e.dest]){
                dfs(e.dest,graph,vis);
            }
        }
    }
    public static void kosaraju(ArrayList<Edge>graph[],int v){

        //step1
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[v];

        for(int i=0;i<v;i++){
            if(!vis[i]){
                topSort(graph, v, i, vis, st);
            }
        }


        //step2
        ArrayList<Edge> transpose[] = new ArrayList[v];
        for(int i=0;i<graph.length;i++){
            vis[i] = false;
            transpose[i] = new ArrayList<Edge>();
        }

        for(int i=0;i<v;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        //step3
        while(!st.isEmpty()){
            int curr = st.pop();
            if(!vis[curr]){
                dfs(curr,graph,vis);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int v = 5;

        ArrayList<Edge>graph[] = new ArrayList[v];

        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
    }
}
