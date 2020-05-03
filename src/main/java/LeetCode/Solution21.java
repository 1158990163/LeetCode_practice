package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution21 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        List<Integer> temp = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        getList(nums, res, len, temp, stack);


        return res;

    }

    private void getList(int[] nums, List<List<Integer>> res, int len, List<Integer> temp, Stack<Integer> stack) {
        if (stack.size() == nums.length) {
            //因为这里存的是地址，所以每次add后，再后续代码中改变temp都会影响到这里存入的temp
//            res.add(temp);不可行
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!stack.contains(nums[i])) {
                stack.push(nums[i]);
                temp.add(nums[i]);
                getList(nums, res, len, temp, stack);
                temp.remove(temp.size() - 1);
                stack.remove(stack.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution21 a = new Solution21();
        int[] nums = new int[]{1};
        List<List<Integer>> permute = a.permute(nums);
        System.out.println(permute.size());


    }
}
