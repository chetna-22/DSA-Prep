package DP.OneD;

import java.util.Arrays;

public class NonAdjacent {
    public static int recurr(int[] arr,int n){
        if(n<0) return 0;
        if(n == 0) return arr[0];

        int incl = recurr(arr, n-2)+arr[n];
        int excl = recurr(arr, n-1);

        return Math.max(incl,excl);
    }
    public static int mem(int[] arr,int n,int[] dp){
        if(n<0) return 0;
        if(n == 0) return arr[0];

        if(dp[n] != -1){
            return dp[n];
        }

        int incl = recurr(arr, n-2)+arr[n];
        int excl = recurr(arr, n-1);

        dp[n] = Math.max(incl,excl);

        return dp[n];
    }
    public static int tab(int[] arr,int n){
        int[] dp = new int[n];
        Arrays.fill(dp,0);

        dp[0] = arr[0];

        for(int i=1;i<arr.length;i++){    
            int incl = arr[i]+dp[i-2];
            int excl = dp[i-1];
            dp[i] = Math.max(incl, excl);
        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        int[] arr = {9,9,8,2};
        int n = arr.length;

        //recursion
        int ans = recurr(arr,n-1);
        System.out.println(ans);

        //Memoisation
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int ans2 = mem(arr,n-1,dp);
        System.out.println(ans2);

        //tabulation
        System.out.println(tab(arr, arr.length));
    }
}
