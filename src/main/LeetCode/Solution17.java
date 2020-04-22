package LeetCode;


import java.util.ArrayList;
import java.util.List;

public class Solution17 {
    public int numberOfSubarrays(int[] nums, int k) {
        int sum = 0;
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        for (int i = 0; i < len; i++) {
            if(nums[i]%2!=0&&nums[i]!=0){
                list.add(i);
            }
        }
        list.add(len);
        if (list.size()-2<k){
            System.out.println("====="+list.size()+"=====");
            return 0;
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("===========================================");
        for (int i = 1; i+k < list.size(); i++) {
            int n1 = list.get(i)-list.get(i-1)-1;
            int n2 = list.get(i+k)-list.get(i+k-1)-1;
            System.out.println(n1+"===="+n2);
            sum += (n1*(1+n2)+n2+1);
        }
        return sum;
    }

    public static void main(String[] args) {
//        nums = [1,1,2,1,1], k = 3

        int[] nums = new int[]{2,2,2,1,2,2,1,2,2,2};
        int k=2;
        Solution17 a = new Solution17();
        int i = a.numberOfSubarrays(nums, k);
        System.out.println(i);


    }
}
