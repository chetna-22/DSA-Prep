package DP.OneD;

import java.util.Arrays;

public class Climbing {
    public static int minCost(int[] cost,int n){

        //Using recursion
        // int ans = Math.min(recurr(cost,n-1), recurr(cost,n-2));
        // return ans;

        //using memoisation
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        int ans = Math.min(mem(cost, n-1, dp),mem(cost, n-2, dp));
        return ans;
    }
    public static int recurr(int[] cost,int n){
        if(n==0){
            return cost[0];
        }
        if(n==1){
            return cost[1];
        }

        int ans = cost[n]+Math.min(recurr(cost, n-1),recurr(cost, n-2));

        return ans;
    }
    public static int mem(int[] cost,int n,int[] dp){
        if(n==0){
            return cost[0];
        }
        if(n==1){
            return cost[1];
        }

        if(dp[n] != -1){
            return dp[n];
        }

        dp[n] = cost[n]+Math.min(recurr(cost, n-1),recurr(cost, n-2));

        return dp[n];
    }
    public static int tab(int[] cost,int n){
        int[] dp = new int[n+1];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i=2;i<n-1;i++){
            dp[i] = cost[n]+Math.min(dp[i-1],dp[i-2]);
        }
        return Math.min(dp[n-1],dp[n-2]);
    }
    public static void main(String[] args) {
        int[] cost = {10,15,20};
        int ans = minCost(cost,cost.length);
        System.out.println(ans);
    }
}
