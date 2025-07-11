package Trees.Binary;

public class LCA {
    static class Node{

        int data;
        Node left;
        Node right;

        public Node(int data){
           this.data = data;
           this.left =  this.right = null;
        }
    }
    public static Node lca(Node root,Node n1,Node n2){
        if(root == null){
            return null;
        }
        if(root == n1 || root == n2){
            return root;
        }
        Node leftAns = lca(root.left,n1,n2);
        Node rightAns = lca(root.right,n1,n2);

        if(leftAns != null && rightAns != null){
            return root;
        } 
        if(leftAns != null && rightAns == null){
            return leftAns;
        }
        if(leftAns == null && rightAns != null){
            return rightAns;
        }
        return null;
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

        Node ans = lca(root, root.left.left,root.left.right);

        System.out.println(ans.data);

    }
}
