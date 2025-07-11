package Trees.Binary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ZigZag {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
           this.data = data;
           this.left =  this.right = null;
        }
    }
    public static void zigzag(Node root){
        if(root == null){
            return ;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        Stack<Integer> st = new Stack<>();

        q.add(root);
        int level = 1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Node curr = q.poll();

                if(level%2 == 0){
                    st.push(curr.data);
                }else{
                    ans.add(curr.data);
                }

                if(curr.left != null){ q.add(curr.left); }
                if(curr.right !=  null){ q.add(curr.right); }
            }
            while(!st.isEmpty()){
                ans.add(st.pop());
            }
            level++;
        }

        for(int val:ans){
            System.out.print(val+" ");
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

    zigzag(root);
    }
}
