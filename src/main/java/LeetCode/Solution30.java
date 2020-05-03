package LeetCode;

//198. 打家劫舍

public class Solution30 {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];

        if (len == 0) {
            return 0;
        }

        if (len == 1) {
            return nums[0];
        }
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[len];
    }
}
