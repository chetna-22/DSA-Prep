package Trees.Binary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Vertical {
    static class Node{

        int data;
        Node left;
        Node right;

        public Node(int data){
           this.data = data;
           this.left =  this.right = null;
        }
    }
    static  class Pair{
        int hd;
        Node val;

        public Pair(int hd,Node val){
            this.hd = hd;
            this.val  = val;
        }
    }
    public static void vertical(Node root){
        if(root == null){
            return;
        }
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();

        q.add(new Pair(0,root));
        System.out.println("start");

        while(!q.isEmpty()){
            Pair curr = q.poll();

            if(map.containsKey(curr.hd)){
                map.get(curr.hd).add(curr.val.data);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(curr.val.data);
                map.put(curr.hd,list);
            }

            if(root.left != null){
                q.add(new Pair(curr.hd-1,root.left));
            }
            if(root.right != null){
                q.add(new Pair(curr.hd+1,root.right));
            }
            System.out.println("mid");
        }

        System.out.println("end");

        for(Entry<Integer,ArrayList<Integer>> entry : map.entrySet()){
            System.out.print(entry.getValue()+" ");
        }

    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(10);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.left.right = new Node(25);
        root.left.right.right = new Node(45);
        root.right.left = new Node(30);
        root.right.right = new Node(35);

        vertical(root);
    }
}
