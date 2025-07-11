package DP.OneD;

import java.util.Arrays;

public class MinCoin {
    public static int recurr(int[] arr, int target){
        if(target == 0){
            return 0;
        }
        if(target < 0) {
            return Integer.MAX_VALUE;
        }
        int mini = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            int ans = recurr(arr, target-arr[i]);
            if(ans != Integer.MAX_VALUE){
                ans = Math.min(ans+1,mini);
            }
        }
        return mini;
    }
    public static int mem(int[] arr, int target,int[] dp){
        if(target == 0){
            return 0;
        }
        if(target < 0) {
            return Integer.MAX_VALUE;
        }
        if(dp[target] != -1){
            return dp[target];
        }

        int mini = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            int ans = recurr(arr, target-arr[i]);
            if(ans != Integer.MAX_VALUE){
                ans = Math.min(ans+1,mini);
            }
        }
        dp[target] = mini;

        return dp[target];
    }
    public static int tab(int[] arr,int target){
        int[] dp = new int[target+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=1;i<=target;i++){
            for(int j=0;j<arr.length;j++){
                if(i-arr[j] >= 0 && dp[i-arr[j]] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],dp[i-arr[j]]);
                }
            }
        }
        if(dp[target] == Integer.MAX_VALUE){
            return -1;
        }
        return dp[target];
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int target =  7;

        //recursion
        int ans = recurr(arr,target);
        if(ans == Integer.MAX_VALUE){
           System.out.println(-1);
        }
        System.out.println(ans);

        int[] dp = new int[target+1];

        Arrays.fill(dp,-1);

        //Memoisation
        int ans2 = mem(arr, target, dp);
        if(ans2 == Integer.MAX_VALUE){
            System.out.println(-1);
         }
         System.out.println(ans2);

        //Tabulation
        System.out.println(tab(arr, target));
    }
}
