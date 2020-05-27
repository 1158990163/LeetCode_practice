package LeetCode;

public class Solution42 {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int add = 1;
        int index = len - 1;
        while (add == 1) {
            digits[index] += 1;
            if (digits[index] == 10) {
                digits[index] = 0;
                add = 1;
                index -= 1;
                if (index<0){
                    int[] res = new int[len+1];
                    res[0]=1;
                    return res;
                }
            } else {
                add = 0;
            }
        }

        return digits;
    }
}
