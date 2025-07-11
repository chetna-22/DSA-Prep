package DP.TwoD;

import java.util.Arrays;

public class Trangulation {
    public static int recurr(int[] arr,int i,int j){
        if(i+1 == j){
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            ans = Math.min(ans,(arr[i]*arr[k]*arr[j])+recurr(arr, i, k)+recurr(arr, k, j));
        }
        return ans;
    }
    public static int mem(int[] arr,int i,int j,int[][] dp){
        if(i+1 == j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            ans = Math.min(ans,(arr[i]*arr[k]*arr[j])+recurr(arr, i, k)+recurr(arr, k, j));
        }
        dp[i][j] = ans;
        return dp[i][j];
    }
    public static int tab(int[] arr,int n){
        int[][] dp = new int[n][n];
        for(int[] row:dp){
             Arrays.fill(row,0);
        }
        for(int i=n-1;i>=0;i--){
            for(int j=i+2;j<n;j++){
                int ans = Integer.MAX_VALUE;
                for(int k=i+1;k<j;k++){
                    ans = Math.min(ans,(arr[i]*arr[k]*arr[j])+dp[i][k]+dp[k][j]);
                }
                dp[i][j] = ans;
             }
        }
        return dp[0][n-1];
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int n = arr.length;
        int res = recurr(arr, 0, n-1);
        System.out.println(res);
    }
}
