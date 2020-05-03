package LeetCode;

//53. 最大子序和

public class Solution29 {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum<0){
                sum=0;
            }
            sum+=nums[i];
            res = Math.max(res,sum);
        }
        return res;
    }
}
