package LeetCode;


//33. 搜索旋转排序数组

public class Solution23 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int head = 0;
        int last = len;
        while (head <= last) {
            int mid = (head + last) / 2;
            if (nums[mid] == target) return mid;
            if (nums[head] < nums[mid]) {
                if (target < nums[mid] && target > nums[head]) {
                    last = mid - 1;
                } else {
                    head = mid + 1;
                }
            } else if (nums[head] > nums[mid]) {
                if (target > nums[mid] && target < nums[last]) {
                    head = mid + 1;
                } else {
                    last = mid - 1;
                }
            }
        }
        return -1;
    }
}
