package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
    static int j=0;
    public static int[] createBfs(ArrayList<ArrayList<Integer>> list,int v){
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[list.size()];
        int[] ans = new int[list.size()];

        q.add(0);
        while(!q.isEmpty()){
            int curr = q.poll();
            if(vis[curr] == false){
                ans[j++] = curr;
                vis[curr] = true;
                for(int i=0;i<list.get(curr).size();i++){
                    int e = list.get(curr).get(i);
                    q.add(e);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        for(int i=0;i<=v;i++){
            list.add(new ArrayList<>());
        }
        list.get(0).add(1);
        list.get(0).add(2);
        list.get(0).add(3);

        list.get(2).add(4);

        int[] res = new int[v];
        res = createBfs(list,v);

        for(int i=0;i<v;i++){
            System.out.print(res[i]);
        }

    }
}
