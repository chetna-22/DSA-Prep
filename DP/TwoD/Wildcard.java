package DP.TwoD;

public class Wildcard {
    public static boolean recurr(String a, String b,int i,int j){
        if(i <0 && j < 0){
            return true;
        }
        if(i>=0 && j < 0){
            return false;
        }
        if(i< 0 && j>0){
            for(int k=0;k<b.length();k++){
                if(b.charAt(k) == '*'){
                    return true;
                }
            }
            return false;
        }

        if(a.charAt(i) == b.charAt(j) || b.charAt(j) == '?'){
            return recurr(a, b, i-1, j-1);
        }else if(b.charAt(j) == '*'){
            return (recurr(a, b, i-1, j))||(recurr(a, b, i, j-1));
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        String word = "abcde";
        String pattern = "a*c?e";
        
        System.out.println(recurr(word, pattern,word.length()-1 , pattern.length()-1));
    }
}
