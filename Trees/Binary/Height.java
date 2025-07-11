package Trees.Binary;

public class Height {
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
    public static void main(String[] args) {
    Node root = new Node(5);
    root.left = new Node(10);
    root.right = new Node(15);
    root.left.left = new Node(20);
    root.left.right = new Node(25);
    root.left.right.right = new Node(45);
    root.right.left = new Node(30);
    root.right.right = new Node(35);

    int ans = height(root);

    System.out.println(ans);
    }
}
