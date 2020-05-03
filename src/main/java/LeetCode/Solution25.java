package LeetCode;


//136. 只出现一次的数字

public class Solution25 {
    public int singleNumber(int[] nums) {
        int res = 0 ;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{4,5,4};
        Solution25 s = new Solution25();
        int i = s.singleNumber(a);
        System.out.println(i);
    }
}
