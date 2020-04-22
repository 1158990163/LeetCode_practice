package LeetCode;

import java.lang.Math;
import java.util.LinkedList;
import java.util.Queue;

//给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
//
//        两个相邻元素间的距离为 1 。
//1.广度搜索

public class Solution01 {
    public int[][] updateMatrix(int[][] matrix) {
        int line = matrix.length;
        int list = matrix[0].length;
        Queue<int[]> dict = new LinkedList<>();
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < list; j++) {
                if (matrix[i][j] == 0) {
                    dict.add(new int[]{i, j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }
        while (!dict.isEmpty()) {
            int[] actX = new int[]{-1, 1, 0, 0};
            int[] actY = new int[]{0, 0, -1, 1};
            int x = dict.poll()[0];
            int y = dict.poll()[1];
            for (int k = 0; k < 4; k++) {
                int newx = x + actX[k];
                int newy = y + actY[k];
                if (newx > 0 && newx < line && newy > 0 && newy < list&&matrix[newx][newy]<0){
                    matrix[newx][newy]=matrix[x][y]+1;
                    dict.offer(new int[]{newx,newy});
                }
            }

        }
        return matrix;
    }
}
