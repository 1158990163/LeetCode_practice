package LeetCode;


import java.util.OptionalInt;

public class Solution16 {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
        int sums = 0;
        for (int num : nums) sums += num;
        if (sums < S || (S + sums) % 2 == 1) return 0;
        int p = (S + sums) / 2;//找出正集合
        int[] dp = new int[p + 1];
        dp[0] = 1;
        int time = 0;
        for (int num : nums) {
            time+=1;
            for (int i = p; i >= num; i--) {
                dp[i] += dp[i - num];
                System.out.println("dp["+i+"] += dp["+(i-num)+"]"+"---->dp["+i+"]="+dp[i]);
            }
            System.out.println("");
        }
        return dp[p];
    }


    public static void main(String[] args) {
        int[] i = new int[]{3,1,1,1,1};
        int S = 3;
        Solution16 s = new Solution16();
        int a= s.findTargetSumWays(i,S);
        System.out.println(a);

    }
}
