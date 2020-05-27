package LeetCode;

public class Solution31 {
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,1};
        Solution31 a = new Solution31();
        int jump = a.jump(nums);
        System.out.println(jump);
    }
}
