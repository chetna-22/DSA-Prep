package Graph;

import java.util.ArrayList;

public class Dfs {
    public static void dfs(ArrayList<ArrayList<Integer>> list,int v,boolean[] vis,int current){
        System.out.print(current);
        vis[current] = true;

        for(int i=0;i<list.get(current).size();i++){
            int e = list.get(current).get(i);
            if(!vis[e]){
                dfs(list,v,vis,e);
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int v = 5;
        
        for(int i=0;i<=v;i++){
            list.add(new ArrayList<>());
        }

        list.get(0).add(1);
        list.get(0).add(2);
        list.get(0).add(3);

        list.get(2).add(4);

        boolean[] vis = new boolean[v];

        for(int i=0;i<v;i++){
            if(!vis[i]){
                dfs(list,v,vis,i);
            }
        }
    }
}
