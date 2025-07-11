package Trees.Binary;

import java.util.ArrayList;

public class Boundary {
    static class Node{

        int data;
        Node left;
        Node right;

        public Node(int data){
           this.data = data;
           this.left =  this.right = null;
        }
    }
    public static void boundary(Node root){
        if(root == null){
            return;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(root.data);

        traverseLeft(root.left,ans);

        traverseLeaf(root.left,ans);
        traverseLeaf(root.right,ans);

        traverseRight(root.right,ans);

        for(int val:ans){
            System.out.print(val+" ");
        }
    }
    public static void traverseLeft(Node root,ArrayList<Integer> ans){
        if(root == null || (root.left == null && root.right == null)){
            return;
        }
        ans.add(root.data);

        if(root.left != null){
            traverseLeft(root.left,ans);
        }else{
            traverseLeft(root.right,ans);
        }
    }
    public static void traverseLeaf(Node root,ArrayList<Integer> ans){
        if(root == null ){
            return;
        }
        if(root.left == null && root.right == null){
            ans.add(root.data);
        }
        traverseLeaf(root.left,ans);
        traverseLeaf(root.right,ans);

    }
    public static void traverseRight(Node root,ArrayList<Integer> ans){
        if(root == null || (root.left == null && root.right == null)){
            return;
        }
       if(root.right != null){
            traverseRight(root.right,ans);
       }else{
            traverseRight(root.left,ans);
       }
       ans.add(root.data);
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

        boundary(root);
    }
}
