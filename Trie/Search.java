package Trie;
public class Search {

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

    public static boolean searchInTrie(String key){
        Node curr = root;

        for(int i=0;i<key.length();i++){
            int index = key.charAt(i)-'a';

            if(curr.children[index] == null){
                return false;
            }
            if(curr.children[index].eow == false && i == key.length()-1){
                return false;
            }
            curr = curr.children[index];
        }
        return true;
    }
    public static void main(String[] args) {
        String[] words = {"there","a","their","any"};

        for(int i=0;i<words.length;i++){
            insertIntoTrie(words[i]);
        }

        System.out.println(searchInTrie("there"));
        System.out.println(searchInTrie("apple"));
        System.out.println(searchInTrie("any"));
    }
}
