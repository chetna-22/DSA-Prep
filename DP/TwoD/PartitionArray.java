package DP.TwoD;

import java.util.Arrays;

public class PartitionArray {
    public static boolean recurr(int n,int[] arr,int index,int target){
        if(index >= n){
            return false;
        }
        if(target < 0){
            return false;
        }
        if(target == 0){
            return true;
        }

        boolean incl = recurr(n, arr, index+1, target-arr[index]);
        boolean excl = recurr(n, arr, index+1, target);

        return (incl||excl);
    }
    public static boolean mem(int n,int[] arr,int index,int target,boolean[][] dp){
        if(index >= n){
            return false;
        }
        if(target < 0){
            return false;
        }
        if(target == 0){
            return true;
        }

        boolean incl = recurr(n, arr, index+1, target-arr[index]);
        boolean excl = recurr(n, arr, index+1, target);

        dp[index][target] = (incl||excl);
        return dp[index][target];
    }
    public static void main(String[] args) {
        int n = 4;
        int[] arr = {1,5,11,6};

        int sum = 0;
        for(int i=0;i<n;i++){
            sum += arr[i];
        }

        if(sum%2 != 0){
            System.out.println(false);
        }else{
            sum = sum/2;
        }

        //Recursion
        System.out.println(recurr(n, arr, 0, sum));

        //memoisation
        boolean[][] dp = new boolean[n+1][sum+1];
        for(boolean[] row:dp){
            Arrays.fill(row,false);
        }

        System.out.println(mem(n, arr, n, sum, dp));
    }
}
