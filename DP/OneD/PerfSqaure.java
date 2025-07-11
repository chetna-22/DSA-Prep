package DP.OneD;

import java.util.Arrays;

public class PerfSqaure {
    public static int recurr(int n){
        if(n==0) return 0;
        int ans = n;

        for(int i=1;i*i<n;i++){
            ans = Math.min(ans, 1+recurr(n-i*i));
        }
        return ans;
    }
    public static int mem(int n,int[] dp){
        if(n==0) return 0;

        if(dp[n] != -1){
            return dp[n];
        }

        int ans = n;

        for(int i=1;i*i<n;i++){
            ans = Math.min(ans, 1+mem(n-i*i,dp));
        }
        dp[n] = ans;
        return dp[n];
    }
    public static int tab(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);

        dp[0] = 0;

        for(int i=1;i<=n;i++){
            for(int j=i;j*j <=n;j++){
                if(i-(j*j) > 0){
                    dp[i] = Math.max(dp[i], 1+dp[i-(j*j)]);
                }
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n =5;

        //recursion
        System.out.println(recurr(n));

        //Memoisation
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(mem(n, dp));

        //Tabulation
        System.out.println(tab(n));
    }
}
