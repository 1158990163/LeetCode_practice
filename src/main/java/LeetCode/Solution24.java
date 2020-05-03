package LeetCode;

//面试题56 - I. 数组中数字出现的次数

public class Solution24 {
    public int[] singleNumbers(int[] nums) {
        int xorNumber = nums[0];
        for(int k=1; k<nums.length; k++){
            xorNumber ^=nums[k];
        }
        int onePosition = xorNumber&(-xorNumber);
        System.out.println(onePosition);
        int ans1 = 0, ans2 = 0;
        for(int i=0; i<nums.length; i++){
            if((nums[i]&onePosition)==onePosition){
                ans1^=nums[i];
            }else{
                ans2^=nums[i];
            }
        }

        return new int[] {ans1^0, ans2^0};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,10,4,1,4,3,3};

        Solution24 a = new Solution24();
        int[] ints = a.singleNumbers(nums);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
