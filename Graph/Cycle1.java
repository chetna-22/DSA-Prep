package Graph;

import java.util.ArrayList;

//directed graph
public class Cycle1 {
    public static boolean checkCycle( ArrayList<ArrayList<Integer>> list,boolean[] vis,boolean[] recurr,int v,int curr){
        vis[curr] = true;
        recurr[curr] = true;

        for(int i=0;i<list.get(curr).size();i++){
            int e = list.get(curr).get(i);
            if(recurr[e] == true){
                return true;
            }
            if(vis[e] == false){
                if(checkCycle(list, vis, recurr, v, e)){
                    return true;
                }
            }
        }
        recurr[curr]= false;
        return false;
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

        boolean[] vis = new boolean[v];
        boolean[] recurr = new boolean[v];

        for(int i=0;i<v;i++){
            if(!vis[i]){
                System.out.println(checkCycle(list,vis,recurr,v,i));
            }
        }

    }
}
