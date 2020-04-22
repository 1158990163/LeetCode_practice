package LeetCode;

import java.util.Arrays;

//给出一个区间的集合，请合并所有重叠的区间。

public class Solution02 {
    public int[][] merge(int[][] intervals) {
        int line = intervals.length;
        int[][] res = new int[line][2];
        int size = -1;
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        for (int[] interval : intervals) {
            if (size < 0 || interval[0] > res[size][1]) {
                res[++size] = new int[]{interval[0], interval[1]};
            } else {
                res[size] = new int[]{res[size][0], Math.max(res[size][1], interval[1])};
            }
        }

        return Arrays.copyOf(res, size);
    }
}
