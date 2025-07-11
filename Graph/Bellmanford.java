package Graph;

import java.util.ArrayList;

///works for negative weights
public class Bellmanford {
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
    public static void bellmanford(ArrayList<Edge> graph[],int src,int V){
        int[] dist = new int[V];
        for(int i=0;i<V;i++){
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        for(int k=0;k<V-1;k++){
            for(int i=0;i<V;i++){
                for(int j=0;j<graph[i].size();i++){
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int v = e.dest;

                    if(dist[u] != Integer.MAX_VALUE && dist[u]+e.wt < dist[v]){
                        dist[v] = e.wt+dist[u];
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        int v = 4;

       ArrayList<ArrayList<Edge>> list = new ArrayList<>();

       for(int i=0;i<=v;i++){
        list.add(new ArrayList<Edge>());
       }

       list.get(0).add(new Edge(0,2,3));
       list.get(1).add(new Edge(1, 0,-2));
       list.get(2).add(new Edge(2, 3,6));
       list.get(3).add(new Edge(3, 0,-2));
    }
}
