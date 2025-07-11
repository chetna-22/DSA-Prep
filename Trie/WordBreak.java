package Trie;

public class WordBreak {
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

    public static boolean wordBreak(String key){
        if(key.length() == 0){
            return true;
        }

        for(int i=1;i<=key.length();i++){
            String first = key.substring(0, i);
            String second = key.substring(i);

            if(searchInTrie(first) && wordBreak(second)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] words = {"i","like","samsung"};

        for(int i=0;i<words.length;i++){
            insertIntoTrie(words[i]);
        }

        System.out.println(wordBreak("ilike"));
    }
}
