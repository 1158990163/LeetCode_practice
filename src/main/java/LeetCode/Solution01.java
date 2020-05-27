package LeetCode;

import java.lang.Math;
import java.util.LinkedList;
import java.util.Queue;

//给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
//
//        两个相邻元素间的距离为 1 。
//1.广度搜索

public class Solution01 {
    public int[][] updteMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        int line = matrix.length;
        int list = matrix[0].length;
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < list; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }

        int[] C_x = new int[]{-1, 1, 0, 0};
        int[] C_y = new int[]{0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int itemX = queue.peek()[0];
            int itemY = queue.poll()[1];
            for (int i = 0; i < 4; i++) {
                int newX = itemX + C_x[i];
                int newY = itemY + C_y[i];
                if (newX >= 0 && newX < line && newY >= 0 && newY < list && matrix[newX][newY] < 0) {
                    matrix[newX][newY] = matrix[itemX][itemY] + 1;
                    queue.add(new int[]{newX, newY});
                }
            }

        }
        return matrix;
    }

    public static void main(String[] args) {
        System.out.println("?");
    }

}
