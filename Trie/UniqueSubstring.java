package Trie;

public class UniqueSubstring {
    static class Node{
        Node[] children;
        boolean eow;

        public Node(){
            children = new Node[26];
            for(int i=0;i<26;i++){
                children[i] = null;
            }

            eow = false;
        }
    }

    static Node root = new Node();

    public static void insertIntoTrie(String word){
        Node curr = root;
        
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';

            if(curr.children[index] == null){
                curr.children[index] = new Node();
            }
            if(i == word.length()-1){
                curr.children[index].eow = true;
            }

            curr = curr.children[index];
        }
    }
    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }
        int count = 0;

        for(int i=0;i<26;i++){
            if(root.children[i] != null){
                count += countNodes(root.children[i]);
            }
        }
        return count+1;
    }
    public static void main(String[] args) {
       String str = "apple";

       for(int i=0;i<str.length();i++){
          String suffix = str.substring(i);
          insertIntoTrie(suffix);
       }

       System.out.println(countNodes(root));
    }
}
