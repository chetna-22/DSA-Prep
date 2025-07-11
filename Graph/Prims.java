package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int src,int dest,int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    static class Pair implements Comparable<Pair>{
        int node;
        int cost;

        public Pair(int node,int cost){
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair o) {
            // TODO Auto-generated method stub
            return this.cost-o.cost;
        }
        
    }
    public static void prims(ArrayList<Edge> graph[],int v){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] vis = new boolean[v];
        int mstCost = 0;

        pq.add(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.node]){
                vis[curr.node] = true;
                mstCost += curr.cost;

                for(int i=0;i<graph[curr.node].size();i++){
                    Edge e = graph[curr.node].get(i);
                    if(!vis[curr.node]){
                        pq.add(new Pair(e.dest, e.wt));
                    }
                }
            }
        }
        System.out.println(mstCost);
    }
    public static void main(String[] args) {
        int v = 4;

        ArrayList<Edge>graph[] = new ArrayList[v];

        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 30));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }
    
}
