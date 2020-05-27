package LeetCode;

//498. 对角线遍历


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution47 {
    public int[] findDiagonalOrder(int[][] matrix) {
        int M = matrix.length;
        if (M==0) return new int[0];
        int N = matrix[0].length;
        int[] res = new int[M * N];
        int[][] node = new int[M + N - 1][2];
        int now = 0;


        // 将对角线上的点保存
        for (int i = 0; i < N; i++) {
            node[now][0] = 0;
            node[now][1] = i;
            now += 1;
        }
        for (int i = 1; i < M; i++) {
            node[now][0] = i;
            node[now][1] = N - 1;
            now += 1;
        }

        now = 0;
        for (int i = 0; i < node.length; i++) {
            int m = node[i][0];
            int n = node[i][1];
            if (i % 2 == 0) {
                Stack<Integer> stack = new Stack<>();
                while (n >= 0 && m < M) {
                    stack.push(matrix[m][n]);
                    m += 1;
                    n -= 1;
                }
                while (!stack.isEmpty()) {
                    res[now] = stack.pop();
                    System.out.println(res[now]+"---->"+now);
                    now++;
                }
            } else {
                Queue<Integer> queue = new LinkedList<>();
                while (n >= 0 && m < M) {
                    queue.offer(matrix[m][n]);
                    m += 1;
                    n -= 1;
                }
                while (!queue.isEmpty()) {
                    res[now] = queue.poll();
                    System.out.println(res[now]+"---->"+now);
                    now++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution47 a = new Solution47();
        int[][] m = new int[2][3];
        m[0][0] = 1;
        m[0][1] = 2;
        m[0][2] = 3;
        m[1][0] = 4;
        m[1][1] = 5;
        m[1][2] = 6;
        int[] res = a.findDiagonalOrder(m);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}