package Trees.Binary;

public class Diameter {
    static class Node{

        int data;
        Node left;
        Node right;

        public Node(int data){
           this.data = data;
           this.left =  this.right = null;
        }
    }
    public static int height(Node root){
       if(root == null){
          return 0;
       }

       return Math.max(height(root.left),height(root.right))+1;
    }
    public static int diameter(Node root){
        if(root == null){
            return 0;
        }
        int d1 = diameter(root.left);
        int d2 = diameter(root.right);
        int d3 = height(root.left)+height(root.right)+1;

        return Math.max(d1,Math.max(d2,d3));
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

    int ans = diameter(root);

    System.out.println(ans);

    }
}
