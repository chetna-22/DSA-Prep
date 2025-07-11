package DP.TwoD;

import java.util.Arrays;

public class MaxSquare {
    public static int recurr(int[][] mat,int i,int j,int n,int[] max){
        if(i>=n || j>=n){
            return 0;
        }

        int right = recurr(mat, i, j+1, n,max);
        int dia = recurr(mat, i+1, j+1, n,max);
        int down = recurr(mat, i+1, j, n,max);

        if(mat[i][j] != 0){
            int ans = 1+Math.min(right,Math.min(dia, down));
            max[0] = Math.max(ans,max[0]);
            return ans;
        }else{
            return 0;
        }
    }
    public static int mem(int[][] mat,int i,int j,int n,int[] max,int[][] dp){
        if(i>=n || j>=n){
            return 0;
        }

        int right = mem(mat, i, j+1, n,max,dp);
        int dia = mem(mat, i+1, j+1, n,max,dp);
        int down = mem(mat, i+1, j, n,max,dp);

        if(mat[i][j] != 0){
            int ans = 1+Math.min(right,Math.min(dia, down));
            max[0] = Math.max(ans,max[0]);
            return ans;
        }else{
            return 0;
        }
    }
    public static void tab(int[][] mat,int n,int[] max){
        int[][] dp = new int[n+1][n+1];
        for(int[] row:dp){
            Arrays.fill(row,0);
        }

        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                int right = dp[i][j+1];
                int dia = dp[i+1][j+1];
                int down = dp[i+1][j];

                if(mat[i][j] != 0){
                    int ans = 1+Math.min(right,Math.min(dia, down));
                    max[0] = Math.max(ans,max[0]);
                   
                }else{
                    dp[i][j] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] mat = {{1,1,0},
                       {1,1,0},
                       {0,0,0}};
 
        //Recurive approach
        int[] max = {0};
        int n = mat.length;
        recurr(mat,0,0,mat.length,max);
        System.out.println(max[0]);

        //Memoisation
        int[][] dp = new int[n+1][n+1];
        for(int[] row:mat){
            Arrays.fill(row,-1);
        }
        mem(mat,0,0,n,max,dp);
        System.out.println(max[0]);

        //Tabulation
        tab(mat,n,max);
        System.out.println(max[0]);
    }
}
