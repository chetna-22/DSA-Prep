package DP.OneD;

import java.util.Arrays;

class HouseRobber {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(nums, n - 1, dp);
    }

    public int solve(int[] nums, int idx, int[] dp) {
        if (idx < 0) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        int incl = nums[idx] + solve(nums, idx - 2, dp);
        int excl = solve(nums, idx - 1, dp);

        dp[idx] = Math.max(incl, excl);

        return dp[idx];
    }
}
