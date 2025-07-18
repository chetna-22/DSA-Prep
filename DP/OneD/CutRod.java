package DP.OneD;

import java.util.Arrays;

public class CutRod {
    public static int recurr(int n,int x,int y,int z){
        if(n<0) return Integer.MIN_VALUE;
        if(n == 0)  return 0;

        int a = recurr(n-x, x, y, z);
        int b = recurr(n-y, x, y, z);
        int c = recurr(n-z, x, y, z);

        return Math.max(a, Math.max(b,c));
    }
    public static int mem(int n,int x,int y,int z,int[] dp){
        if(n<0) return Integer.MIN_VALUE;
        if(n == 0)  return 0;

        if(dp[n] != -1){
            return dp[n];
        }

        int a = recurr(n-x, x, y, z);
        int b = recurr(n-y, x, y, z);
        int c = recurr(n-z, x, y, z);

        dp[n] = Math.max(a, Math.max(b,c));

        return dp[n];
    }
    public static int tab(int n,int x,int y,int z){
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[0] = 0;

        for(int i=1;i<=n;i++){
            if(i-x>=0){
                dp[i] = Math.max(dp[i],dp[i-x]+1);
            }
            if(i-y>=0){
                dp[i] = Math.max(dp[i],dp[i-y]+1);
            }
            if(i-z >= 0){
                dp[i] = Math.max(dp[i],dp[i-z]+1);
            }
        }
        if(dp[n] < 0) return 0;

        return dp[n];
    }
    public static void main(String[] args) {
        int n  = 8;
        int x = 1,y=2,z=3;

        //recurr
        int ans = recurr(n,x,y,z);
        if(ans < 0){
            System.out.println(0);
        }
        System.out.println(ans);

        //Memoisation
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int ans2 = mem(ans, x, y, z, dp);
        if(ans2 < 0){
            System.out.println(0);
        }
        System.out.println(ans2);

        //Tabulation

        System.out.println(tab(n, x, y, z));
    }
}
