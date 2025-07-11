package Graph;

import java.util.ArrayList;

import java.util.PriorityQueue;

//Directed weighted graph
public class Dijkstra {
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
        int dist;

        public Pair(int node,int dist){
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair o) {
            // TODO Auto-generated method stub
            return this.dist-o.dist;
        }
        
    }
    public static int[] DijkstraAlgoForShortestDistance(int v, ArrayList<ArrayList<Edge>> list,int source){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] d = new int[v];

        for(int i=0;i<v;i++){
            if(i!=source){
                d[i] = Integer.MAX_VALUE;
            }
        }
        boolean[] vis = new boolean[v];

        pq.add(new Pair(0, 0));

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.node]){
                vis[curr.node] = true;
            }
            for(int i=0;i<list.get(curr.node).size();i++){
                Edge e = list.get(curr.node).get(i);
                int u = e.src;
                int v1 = e.dest;
                if(d[u]+e.wt < d[v1]){
                    d[v1] = d[u]+e.wt;
                }
            }
        }
        return d;
    }
    public static void main(String[] args) {
       int v = 4;

       ArrayList<ArrayList<Edge>> list = new ArrayList<>();

       for(int i=0;i<=v;i++){
        list.add(new ArrayList<Edge>());
       }

       list.get(0).add(new Edge(0,2,3));
       list.get(1).add(new Edge(1, 0,2));
       list.get(2).add(new Edge(2, 3,6));
       list.get(3).add(new Edge(3, 0,2));
    }
}
