package JZoffer;

import java.util.ArrayList;
import java.util.List;

public class Solution02 {
    public int[] printNumbers(int n) {
        int max = (int) (Math.pow(10, n));
        int[] res = new int[max-1];
        for (int i = 1; i < max; i++) {
            res[i - 1] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution02 a = new Solution02();
        int[] ints = a.printNumbers(5);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }
}

