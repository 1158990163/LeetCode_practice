package LeetCode;

//54. 螺旋矩阵

import java.util.ArrayList;
import java.util.List;

public class Solution48 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int line = matrix.length;
        if (line == 0) {
            return new ArrayList<>();
        }
        int list = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int x0 = 0;
        int y0 = 0;
        int x1 = line - 1;
        int y1 = list - 1;
        while (x0 <= x1 && y0 <= y1) {
            if (x0 == x1) {
                for (int i = y0; i <= y1; i++) {
                    res.add(matrix[x0][i]);
                }
                break;
            }
            if (y0 == y1) {
                for (int i = x0; i <= x1; i++) {
                    res.add(matrix[i][y0]);
                }
                break;
            }
            for (int i = y0; i < y1; i++) {
                res.add(matrix[x0][i]);
            }
            for (int i = x0; i < x1; i++) {
                res.add(matrix[i][y1]);
            }
            for (int i = y1; i > y0; i--) {
                res.add(matrix[x1][i]);
            }
            for (int i = x1; i > x0; i--) {
                res.add(matrix[i][y0]);
            }
            x0 += 1;
            y0 += 1;
            x1 -= 1;
            y1 -= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] s = new int[3][1];
        s[0] = new int[]{1};
        s[1] = new int[]{2};
        s[2] = new int[]{3};
        Solution48 solution48 = new Solution48();
        List<Integer> res = solution48.spiralOrder(s);
        for (Integer re : res) {
            System.out.println(re);
        }
    }
}
