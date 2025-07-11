package Graph;

import java.util.ArrayList;

//Undirected graph
public class Cycle2 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int v = 5;
        
        for(int i=0;i<=v;i++){
            list.add(new ArrayList<>());
        }

        list.get(0).add(1);
        list.get(0).add(2);
        list.get(0).add(3);
    }
}
