package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class Solution14 {
    public static void main(String[] args) {
        Set<int[]> set = new HashSet<>();
        set.add(new int[]{1,2});
        set.add(new int[]{1,1});
        set.add(new int[]{1,3});
        boolean contains = set.contains(new int[]{1, 3});
        System.out.println(contains);
    }
}
