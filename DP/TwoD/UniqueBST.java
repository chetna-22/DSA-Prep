package DP.TwoD;

public class UniqueBST {
    public static int recurr(int n){
        if(n<=1){
            return 1;
        }
        int ans = 0;
        for(int i=1;i<=n;i++){
            ans += recurr(i-1)*recurr(n-i);
        }
        return ans;
    }
    public static void main(String[] args) {
        int n = 3;
        
        //recursion
        System.out.println(recurr(n));
    }
}
