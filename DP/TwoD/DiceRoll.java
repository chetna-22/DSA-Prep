package DP.TwoD;

import java.util.Arrays;

public class DiceRoll {
    public static int recurr(int dice,int faces,int target){
        if(target < 0){
            return 0;
        }
        if(target !=0 && dice == 0){
            return 0;
        }
        if(target ==0 && dice != 0){
            return 0;
        }
        if(target == 0 && dice == 0){
            return 1;
        }

        int ans = 0;
        for(int i=1;i<=faces;i++){
            ans = ans + recurr(dice-1, faces, target-i);
        }
        return ans;

    }
    public static int mem(int dice,int faces,int target,int[][] dp){
        if(target < 0){
            return 0;
        }
        if(target !=0 && dice == 0){
            return 0;
        }
        if(target ==0 && dice != 0){
            return 0;
        }
        if(target == 0 && dice == 0){
            return 1;
        }

        if(dp[dice][target] != -1){
            return dp[dice][target];
        }

        int ans = 0;
        for(int i=1;i<=faces;i++){
            ans = ans + mem(dice-1, faces, target-i,dp);
        }
        dp[dice][target] = ans;

        return dp[dice][target];

    }
    public static int tab(int d,int f,int t){
        int[][] dp = new int[d+1][t+1];
        for(int[] row:dp){
            Arrays.fill(row,0);
        }

        dp[0][0] = 1;

        for(int dice =1;dice<=d;dice++){
            for(int target = 1;target<=t;target++){
                int ans = 0;
                for(int i=1;i<=f;i++){
                    if(target-i >= 0){
                        ans = ans + dp[dice-1][target-i];
                    }
                }
                dp[dice][target] = ans;
             }
        }
        return dp[d][t];
    }
    public static void main(String[] args) {
        int n = 3;
        int m = 6;
        int x = 12;

        //recurr
        System.out.println(recurr(n, m, x));

        //Memoisation
        int[][] dp = new int[n+1][x+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        System.out.println(mem(n, m, x, dp));

        //Tabulation
        System.out.println(tab(n, m, x));
    }
}
