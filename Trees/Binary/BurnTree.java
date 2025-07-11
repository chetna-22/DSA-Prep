package Trees.Binary;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BurnTree {
    static class Node{

        int data;
        Node left;
        Node right;

        public Node(int data){
           this.data = data;
           this.left =  this.right = null;
        }
    }
    public static int minTime(Node root,int target){
        HashMap<Node,Node> nodeToParent = new HashMap<>();
        Node targetNode = createMapping(root,target,nodeToParent);
        //System.out.println(targetNode.data);

        return burnTree(root,targetNode,nodeToParent);
    }
    public static Node createMapping(Node root,int target,HashMap<Node,Node> nodeToParent){
        Node res = null;
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        nodeToParent.put(root, null);

        while(!q.isEmpty()){
            Node curr = q.poll();

            if(curr.data == target){
                res = curr;
            }
            if(curr.left != null){
                q.add(curr.left);
                nodeToParent.put(curr.left, curr);
            }
            if(curr.right != null){
                q.add(curr.right);
                nodeToParent.put(curr.right, curr);
            }
        }
        
        return res;
    }
    public static int burnTree(Node root,Node target,HashMap<Node,Node> nodeToParent){
         
         HashMap<Node,Boolean> visited = new HashMap<>();
         Queue<Node> q = new LinkedList<>();

         q.add(root);
         visited.put(root,true);
         int ans = 0;

         while(!q.isEmpty()){
            boolean flag = false;
            int size = q.size();
            for(int i=0;i<size;i++){
                Node curr = q.poll();
                if(curr.left != null && !visited.get(curr)){
                    visited.put(curr.left,true);
                    q.add(curr.left);
                    flag = true;
                }
                if(curr.right != null && !visited.get(curr)){
                    visited.put(curr.left,true);
                    q.add(curr.left);
                    flag = true;
                }
                if(nodeToParent.get(curr)!=null && !visited.get(nodeToParent.get(curr)) ){
                    visited.put(nodeToParent.get(curr),true);
                    q.add(nodeToParent.get(curr));
                    flag = true;
                }
            }
            if(flag == true){
                ans++;
            }
            
         }
         System.out.println("within burn tree"+ans);
         return ans;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(8);
        root.right.right = new Node(3);
        root.right.right.right = new Node(6);
        root.right.right.right.right = new Node(9);
        root.right.right.right.right.right = new Node(10);

        System.out.println(minTime(root,8));

    }
}
