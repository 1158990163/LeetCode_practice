package LeetCode;


import java.util.LinkedList;
import java.util.Queue;

public class Solution07 {
    public int numSquares(int n) {
        int last = n;
        Queue<Integer> list = new LinkedList<>();
        list.offer(n);
        int step = 1;

        while (!list.isEmpty()) {
            int temp = list.poll();

            if (temp == last && temp != n) {
                step += 1;
            }
            for (int i = 0; i < temp; i++) {
                if (Judge(temp - i)) {
                    if (i == 0) {
                        return step;
                    }
                    list.offer(i);
                    if (i == temp - 1 && temp == last) {
                        last = i;
                    }
                }

            }
            if (temp == n && temp > 3) {
                step += 1;
            }

        }
        return 0;

    }


    public static boolean Judge(int num) {
        int sqrt = (int) Math.sqrt(num);
        return (sqrt * sqrt) == num;
    }

    public static void main(String[] args) {
        Solution07 a = new Solution07();
        int i = a.numSquares(3);
        System.out.println(i);
    }


}
