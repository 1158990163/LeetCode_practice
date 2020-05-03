package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class Solution27 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int res = turnto(n);
        while (true){
            if (res==1){
                System.out.println("快乐数");
                return true;
            }
            if (set.contains(res)){
                System.out.println("非快乐数");
                return true;
            }
            set.add(res);
            res = turnto(res);
        }
    }
    public static int turnto(int n){
        int temp = 1;
        int last = 1;
        int sum = 0;
        int len = 0;

        while (temp != 0 || last!=0) {
            last = (int) (n / Math.pow(10, len));
            temp = last % 10;
            sum = temp * temp+sum;
            len += 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution27 a = new Solution27();
        a.isHappy(19);
    }
}
