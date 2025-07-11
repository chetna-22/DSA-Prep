package Trees.Binary;

import java.util.ArrayList;

public class LeftView {
    static class Node{

        int data;
        Node left;
        Node right;

        public Node(int data){
           this.data = data;
           this.left =  this.right = null;
        }
    }
static int max_level = 0;
    public static void  leftView(Node root){
        ArrayList<Node> ans = new ArrayList<>();
        printView(root,ans,1);

        for(Node val:ans){
            System.out.print(val.data+" ");
        }
    }
    public static void printView(Node root,ArrayList<Node> ans,int level){
        if(root == null){
            return;
        }
        if(max_level <level){
            ans.add(root);
            max_level = level;
        }
        printView(root.left,ans,level+1);
        printView(root.right,ans,level+1);

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

        leftView(root);
    }
}
