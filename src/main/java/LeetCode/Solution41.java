package LeetCode;

import java.util.HashSet;
import java.util.Set;

///747. 至少是其他数字两倍的最大数

public class Solution41 {
    public int dominantIndex(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int index = 0;
        int max1 = -1;
        int max2 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                max2 = max1;
                max1 = nums[i];
                index = i;
            }else if (nums[i]>max2){
                max2 = nums[i];
            }
        }
        return max2 * 2 <= max1 ? index : -1;
    }
}
