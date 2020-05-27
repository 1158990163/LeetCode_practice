package LeetCode;

//724. 寻找数组的中心索引


public class Solution40 {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int temp = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            int res = sum - nums[i];
            if ((res % 2) == 0 && (res / 2) == temp) {
                return i;
            }
            temp += nums[i];
        }
        return -1;
    }
}
