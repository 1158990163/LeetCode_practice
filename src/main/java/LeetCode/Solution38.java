package LeetCode;


///733. 图像渲染


import java.util.LinkedList;
import java.util.Queue;

public class Solution38 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<int[]> queue = new LinkedList<>();
        int line = image.length;
        int list = image[0].length;
        int color = image[sr][sc];
        queue.offer(new int[]{sr, sc});
        int[] inX = new int[]{0, 0, -1, 1};
        int[] inY = new int[]{1, -1, 0, 0};
        while (!queue.isEmpty()) {
            int newX = queue.peek()[0];
            int newY = queue.poll()[1];
            image[newX][newY] = newColor;
            for (int i = 0; i < 4; i++) {
                int X = newX + inX[i];
                int Y = newY + inY[i];
                if (X >= 0 && X < line && Y >= 0 && Y < list && image[X][Y] == color && image[X][Y] != newColor) {
                    queue.offer(new int[]{X, Y});
                }
            }
        }
        return image;
    }
}
