package DP.TwoD;

public class EditDistance {
    public static int recurr(String word1,String word2,int i,int j){
        if(i == word1.length()){
            return word2.length()-j;
        }
        if(j == word2.length()){
            return word1.length()-i;
        }
        int ans = 0;

        if(word1.charAt(i) == word2.charAt(j)){
            return recurr(word1, word2, i+1, j+1);
        }else{
            int insert = 1+recurr(word1, word2, i, j+1);
            int delete = 1+ recurr(word1, word2, i+1, j);
            int replace = 1+ recurr(word1, word2, i+1, j+1);

            ans = Math.min(insert, Math.min(delete, replace));
        }
        return ans;
    }
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";

        //recursion
        System.out.println(recurr(word1,word2,0,0));
    }
}
