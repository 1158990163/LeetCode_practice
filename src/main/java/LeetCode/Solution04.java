package LeetCode;

public class Solution04 {
//    给定一个非负整数数组，你最初位于数组的第一个位置。
//
//    数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
//    判断你是否能够到达最后一个位置。



    //      1.倒叙
//    public boolean canJump(int[] nums) {
//        int last = nums.length;
//        int index = last - 1;
//        for (int i = last-1; i >= 0; i--) {
//            if(nums[i]+i>=index){
//                index = i;
//            }
//        }
//        if(index==0){
//            return true;
//        }else {
//            return false;
//        }
//
//    }
//    2.正序
    // 贪心
    public boolean canJump(int[] nums) {
        int length = nums.length-1;
        int maxstep=0;
        for(int i=0;i<=maxstep;i++){
            maxstep = Math.max(maxstep,nums[i]+i);
            if(maxstep>=length){
                return true;
            }
        }
        return false;
    }


        public static void main (String[]args){
            int[] test = new int[]{2, 3, 1, 1, 4};
            Solution04 a = new Solution04();
            boolean s = a.canJump(test);
            System.out.println(s);
        }
    }
