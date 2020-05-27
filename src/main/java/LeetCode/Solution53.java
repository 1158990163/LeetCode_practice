package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Solution53 {
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> maps = new HashMap<>();
        int num = 0;
        for (int i : A) {
            num += i;
            int out = (num % K < 0) ? K+ (num % K) : num % K;
            maps.put(out, maps.getOrDefault(out, 0) + 1);
            System.out.println(out+"-----"+maps.getOrDefault(out, 0));
        }
        int res = 0;

        for (int i = 0; i < K; i++) {
            res += maps.getOrDefault(i, 0) * (maps.getOrDefault(i, 0) - 1) / 2;
        }

        return res + maps.getOrDefault(0, 0);
    }

    public static void main(String[] args) {

        Solution53 a = new Solution53();
        int[] A = new int[]{2, -2, 2, -4};
        int i = a.subarraysDivByK(A, 6);
        System.out.println(i);
    }
}
